package demo1

import geb.*

import content.google.GoogleHomePage
import content.google.GoogleResultsPage
import content.google.WikipediaPage

Browser.drive {
    to GoogleHomePage

    search.forTerm "wikipedia"
    at GoogleResultsPage

    assert firstResultLink.text() == "Wikipedia"
    firstResultLink.click()

    waitFor { at WikipediaPage }
}.quit()

// Same as…
//    def browser = new Browser()
//    browser.to GoogleHomePage
//    browser.at GoogleHomePage
//    browser.search.forTerm "wikipedia"
//    browser.at GoogleResultsPage
//    assert browser.firstResultLink.text() == "Wikipedia"
//    browser.firstResultLink.click()
//    browser.waitFor { browser.at WikipediaPage }