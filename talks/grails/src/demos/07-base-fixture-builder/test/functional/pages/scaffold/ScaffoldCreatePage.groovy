package pages.scaffold

abstract class ScaffoldCreatePage extends ScaffoldPage {

    final action = "Create"

    def getExpectedHeading() { 
        "$action $domainClass.simpleName"
    }

    abstract getShowPage()

    static content = {
        createButton(to: container.showPage) { create() }
        form { $("div[role=main] form") }
    }

}