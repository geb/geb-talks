package _03_reporting

import geb.spock.GebReportingSpec
import spock.lang.Stepwise

@Stepwise
class _01_FailedLoginReportingSpec extends GebReportingSpec {

    def "go to login page"() {
        when:
        go "/login"

        then:
        title == "Sign in page"
        $("h1").text() == "Please sign in"
        $("form").find("input[type=text],input[type=password]").size() == 2
    }

    def "fill out form with bad password"() {
        given:
        $("form").with {
            username = "user"
            password = "wrong-password"
            rememberme = true
        }

        when:
        report "after fill out form"
        $("button").click()

        then:
        title == "Login Result"
        $("h1").text() == "Login led"
    }

}