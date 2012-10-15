package specs

import geb.spock.*
import spock.lang.*

import pages.*
import pages.scaffold.author.*
import pages.scaffold.book.*

import util.TestFixture

class TweakBookSpec extends GebReportingSpec {

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
        
        when:
        recordLink(0).click()
        
        then:
        at BookShowPage
        author == testFixture.attribute("author", 0, "name")
        
        when:
        navItem("list").click()
        
        then:
        at BookListPage
        
        when:
        recordLink(1).click()
        
        then:
        at BookShowPage
        author == testFixture.attribute("author", 1, "name")
        
        when:
        testFixture.modify("book", 1) {
            it.author = fixture.author0
        }
        driver.navigate().refresh()
        
        then:
        author == testFixture.attribute("author", 0, "name")
    }
    
    def cleanup() {
        testFixture.clean()
    }
}