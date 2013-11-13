package _04_pages

import content.login.LoginFailedPage
import content.login.LoginPage
import geb.spock.GebReportingSpec
import spock.lang.Stepwise

@Stepwise
class _01_FailedLoginPageSpec extends GebReportingSpec {

    def "go to login page"() {
        when:
        to Logi nPage

        then:
        heading == "Please sign in"
        textTypeControls.size() == 2
    }

    def "fill out form with bad password"() {
        when:
        login("user", "wrong-password", true)

        then:
        at LoginFailedPage
    }

}
