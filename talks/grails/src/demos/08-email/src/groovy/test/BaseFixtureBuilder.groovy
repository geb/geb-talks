package test

import app.*

class BaseFixtureBuilder {

    def fixtureLoader
    def fixture
    
    Map<String, Integer> counts

    void build(Map counts) {
        this.counts = counts
        this.fixture = fixtureLoader.build {
            def builder = delegate

            (0..<count("author")).each { authorIndex ->
                def name = authorName(authorIndex)
                builder."$name"(Author, name: name)
            }

            (0..<count("book")).each { bookIndex ->
                def name = bookName(bookIndex)
                builder."$name"(Book, title: name, author: ref(authorName(bookIndex % count("author"))))
            }
        }
    }

    int count(k) {
        counts[k] ?: 1
    }

    def getBean(n) {
        fixture."$n"
    }

    def propertyMissing(String name) {
        getBean(name)
    }

    def methodMissing(String name, args) {
        def methodName = "${name}Name"
        if (this.metaClass.respondsTo(this, methodName)) {
            if (args && args[0] instanceof Range) {
                def tail = args.toList().tail()
                args[0].collect { getBean("$methodName"(it, *tail)) }
            } else {
                getBean("$methodName"(*args))
            }
        } else {
            throw new MissingMethodException(name, this.class, args)
        }
    }

    String authorName(authorIndex = 0) {
        "author$authorIndex"
    }

    String bookName(bookIndex = 0) {
        "book$bookIndex"
    }

    void reset() {
        fixture = null
    }

}