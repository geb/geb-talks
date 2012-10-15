package specs

import geb.spock.*
import spock.lang.*

import pages.*
import pages.scaffold.author.*
import pages.scaffold.book.*

@Stepwise
class CreateBookPageSpec extends GebReportingSpec {

    def "go to list author page"() {
        when:
        to HomePage
        authors.click()

        then:
        at AuthorListPage
    }

    def "go to create author page"() {
        when:
        newItem.click()

        then:
        at AuthorCreatePage
    }

    def "create author"() {
        when:
        form.name = "author1"
        create().click()

        then:
        at AuthorShowPage
        name == "author1"
    }

    def "create book with author"() {
        when:
        to HomePage
        books.click()
        
        then:
        at BookListPage
    }
    
    def "go to create book page"() {
         when:
         newItem.click()

         then:
         at BookCreatePage
    }
    
    def "create book"() {
        when:
        form.title = "book1"
        form."author.id" = "author1"
        create().click()

        then:
        at BookShowPage
        bookTitle == "book1"
        author == "author1"
    }
    
}