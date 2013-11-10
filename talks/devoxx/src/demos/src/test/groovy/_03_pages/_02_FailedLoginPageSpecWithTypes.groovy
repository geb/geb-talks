package _03_pages

import content.login.LoginFailedPage
import content.login.LoginPage
import content.login.LoginSuccessPage
import geb.spock.GebReportingSpec
import spock.lang.Stepwise

@Stepwise
class _02_FailedLoginPageSpecWithTypes extends GebReportingSpec {

    def "go to login page"() {
        when:
        def page = to LoginPage

        then:
        page.heading == "Please sign in"
        page.textTypeControls.size() == 2
    }

    def "fill out form with bad password"() {
        def page = at LoginPage

        when:
        page.login("user", "wrong-password", true)

        then:
        at LoginFailedPage
    }

    def "successful login"() {
        def page = to LoginPage

        when:
        page.login("user", "password", true)

        then:
        at LoginSuccessPage
    }

}
