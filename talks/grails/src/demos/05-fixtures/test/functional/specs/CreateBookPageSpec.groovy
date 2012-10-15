package specs

import geb.spock.*
import spock.lang.*

import pages.*
import pages.scaffold.author.*
import pages.scaffold.book.*

import grails.plugin.remotecontrol.RemoteControl

@Stepwise
class CreateBookPageSpec extends GebReportingSpec {

    def setup() {
        def remote = new RemoteControl()
        remote.exec {
            ctx.fixtureLoader.load {
                a1(app.Author, name: "author1", age: 10)
                b1(app.Book, title: "book1", author: a1)
            }
            
            //ctx.fixtureLoader.build {
            //    a1(app.Author, name: "author1")
            //    b1(app.Book, title: "book1", author: a1)
            //}
            
            null // to prevent unserializable return
        }
    }

    def "check data"() {
        when:
        to HomePage
        books.click()

        then:
        at BookListPage

        when:
        recordLink(0).click()

        then:
        at BookShowPage
        bookTitle == "book1"
        author == "author1"
    }

}