package _03_geb

import geb.spock.GebSpec
import spock.lang.Stepwise

@Stepwise
class LoginSpec extends GebSpec {
    def "can login successfully"() {
        when:
        go "/login"

        then:
        $("h1").text() == "Please sign in"

        when:
        username = "rwx"
        password = "rwx"
        signIn().click()

        then:
        $("h1").text() == "Login Successful"
    }

    def "navigate to secret page"() {
        when:
        $("a.btn").click()

        then:
        $("h1").text() == "Secret Page!"
    }
}
