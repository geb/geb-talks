package pages.scaffold

abstract class ScaffoldShowPage extends ScaffoldPage {

    final action = "Show"

    def getExpectedHeading() {
        "$action $domainClass.simpleName"
    }

    static content = {
        propertyList { $("ol.property-list") }
        field { $("span.property-label", text: iStartsWith(it)).next() }
        fieldValue { field(it).text() }
    }

}