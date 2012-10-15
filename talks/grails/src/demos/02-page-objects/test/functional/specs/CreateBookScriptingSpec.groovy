package specs

import geb.spock.*
import spock.lang.*

import pages.*
import pages.scaffold.author.*
import pages.scaffold.book.*

@Stepwise
class CreateBookScriptingSpec extends GebReportingSpec {

    def "go to list author page"() {
        when:
        go()
        $("div#controller-list ul li.controller a", text: startsWith("app.Author")).click()

        then:
        title == "Author List"
    }

    def "go to create author page"() {
        when:
        $("div.nav ul li a.create").click()

        then:
        title == "Create Author"
    }

    def "create author"() {
        when:
        $("form").name = "author1"
        create().click()

        then:
        title == "Show Author"
        $("span.property-label", text: iStartsWith("name")).next().text() == "author1"
    }

    def "create book with author"() {
        when:
        go()
        $("div#controller-list ul li.controller a", text: startsWith("app.Book")).click()

        then:
        title == "Book List"
    }

    def "go to create book page"() {
        when:
        $("div.nav ul li a.create").click()

        then:
        title == "Create Book"
    }

    def "create book"() {
        when:
        $("form").title = "book1"
        $("form")."author.id" = "author1"
        create().click()

        then:
        title == "Show Book"
        $("span.property-label", text: iStartsWith("title")).next().text() == "book1"
        $("span.property-label", text: iStartsWith("author")).next().text() == "author1"
    }

}