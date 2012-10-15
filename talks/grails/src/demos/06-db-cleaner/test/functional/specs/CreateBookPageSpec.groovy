package specs

import geb.spock.*
import spock.lang.*

import pages.*
import pages.scaffold.author.*
import pages.scaffold.book.*

import grails.plugin.remotecontrol.RemoteControl

@Stepwise
class CreateBookPageSpec extends GebReportingSpec {

    def remote = new RemoteControl(useStringRepresentationIfResultWasUnserializable: true)

    def setup() {
        remote.exec {
            ctx.fixtureLoader.build {
               a1(app.Author, name: "author1", age: 10)
               b1(app.Book, title: "book1", author: a1)
            }
        }
    }

    def "check data"() {
        when:
        to HomePage
        books.click()

        then:
        at BookListPage
        records.size() == 1
        
        when:
        remote.exec { ctx.dbCleaner.clean() }
        to HomePage
        books.click()

        then:
        records.size() == 0
    }

}