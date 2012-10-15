import geb.spock.*

class FunctionalSpec extends GebReportingSpec {

    def "check front page"() {
        when:
        go()
        
        then:
        $("div#page-body h1").text() == "Welcome to Grails"
    }

}