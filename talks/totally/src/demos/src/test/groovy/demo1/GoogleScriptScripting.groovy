package demo1

import geb.*

Browser.drive {
    go "http://google.com/ncr"
    assert title == "Google"

    $("#gs_lc0").q = "Wikipedia"
    waitFor { $("li.g") }

    assert $("li.g a.l", 0).text() == "Wikipedia"
    $("li.g a.l", 0).click()

    waitFor { title == "Wikipedia" }
}.quit()

// Same as…
//    def browser = new Browser()
//    browser.go "http://google.com/ncr"
//    assert browser.title == "Google"
//
//    browser.$("#gs_lc0").q = "Wikipedia"
//    browser.waitFor { browser.$("li.g") }
//
//    assert browser.$("li.g a.l", 0).text() == "Wikipedia"
//    browser.$("li.g a.l", 0).click()
//
//    browser.waitFor { browser.title == "Wikipedia" }
//    browser.quit()
