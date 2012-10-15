package pages

import geb.*

class BasePage extends Page {
    static content = {
        heading { $("div[role=main] h1").text() }
    }
}