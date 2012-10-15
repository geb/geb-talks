package specs

import geb.spock.*
import spock.lang.*

import pages.*
import pages.scaffold.author.*
import pages.scaffold.book.*

import util.*

class SendEmailSpec extends GebReportingSpec {

    def testFixture = new TestFixture()
    def emails = new Emails()

    def setup() {
        testFixture.build(author: 1)
    }

    def "create book"() {
        expect:
        emails.count == 0

        when:
        to HomePage
        books.click()

        then:
        at BookListPage

        when:
        newItem.click()

        then:
        at BookCreatePage

        when:
        form.title = "New book"
        form."author.id" = testFixture.attribute("author", 0, "name")
        create().click()

        then:
        at BookShowPage
        emails.count == 1
        emails.body == "Title: New book"
    }

    def cleanup() {
        testFixture.clean()
        emails.clean()
    }
}