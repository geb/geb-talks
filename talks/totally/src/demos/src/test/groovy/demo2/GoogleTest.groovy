package demo2

import content.google.GoogleHomePage
import content.google.GoogleResultsPage
import content.google.WikipediaPage
import geb.junit4.GebReportingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4)
class GoogleTest extends GebReportingTest {
    
    @Test 
    void theFirstLinkShouldBeWikipedia() {
        to GoogleHomePage
        at GoogleHomePage
        search.forTerm "wikipedia"
        at GoogleResultsPage
        firstResultLink.text() == "Wikipedia"
        firstResultLink.click()
        waitFor { at WikipediaPage }
    }
    
}