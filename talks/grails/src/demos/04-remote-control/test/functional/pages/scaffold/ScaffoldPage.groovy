package pages.scaffold

import pages.*

abstract class ScaffoldPage extends BasePage {

    static at = { heading == expectedHeading }

    abstract getDomainClass()
    abstract getAction()

    def getExpectedHeading() {
        "$domainClass.simpleName $action"
    }

    static content = {
        navList { $("div.nav ul") }
        navItem { navList.find("ul a.$it") }
        home(to: HomePage) { navItem("home") }
    }

}