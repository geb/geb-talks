package specs

import geb.spock.*
import spock.lang.*

import pages.*
import pages.scaffold.author.*
import pages.scaffold.book.*

import util.TestFixture

class CreateBookPageSpec extends GebReportingSpec {

    def testFixture = new TestFixture()

    def setup() {
        testFixture.build(author: 2, book: 4)
    }

    def "check data"() {
        when:
        to HomePage
        books.click()

        then:
        at BookListPage
        records.size() == 4

        when:
        to HomePage
        authors.click()

        then:
        at AuthorListPage
        records.size() == 2
    }
    
    def cleanup() {
        testFixture.clean()
    }
}