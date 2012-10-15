package specs

import geb.spock.*
import spock.lang.*

import pages.*
import pages.scaffold.author.*
import pages.scaffold.book.*

import util.TestFixture

class TweakAuthorSpec extends GebReportingSpec {

    def testFixture = new TestFixture()

    def setup() {
        testFixture.build(author: 2, book: 4)
    }

    def "check data"() {
        when:
        to HomePage
        authors.click()

        then:
        at AuthorListPage

        when:
        recordLink(1).click()

        then:
        at AuthorShowPage
        name == testFixture.attribute("author", 1, "name")
        
        when:
        testFixture.modify("author", 1, name: "foo")
        driver.navigate().refresh()
        
        then:
        name == "foo"
    }
    
    def cleanup() {
        testFixture.clean()
    }
}