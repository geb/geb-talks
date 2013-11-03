package _02_testing

import geb.spock.GebSpec
import spock.lang.Stepwise

import static util.Pause.pause

@Stepwise
class _02_FailedLoginSpec extends GebSpec {

    def "go to login page"() {
        when:
        go "/login"
        pause(browser)

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
        $("button").click()

        then:
        title == "Login Result"
        $("h1").text() == "Login Failed"
    }

}