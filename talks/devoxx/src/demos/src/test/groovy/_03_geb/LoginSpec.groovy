package _03_geb

import geb.spock.GebSpec
import spock.lang.Unroll

class LoginSpec extends GebSpec {

    @Unroll
    "#type login produces #msg message"() {
        when:
        go "/login"

        then:
        $("h1").text() == "Please sign in"

        when:
        username = usernameValue
        password = passwordValue
        signIn().click()

        then:
        $("h1").text() == msg

        where:
        type      | usernameValue | passwordValue | msg
        "success" | "devoxx"      | "devoxx"      | "Login Successful"
        "failed"  | "wrong"       | "wrong"       | "Login Failed"
    }
}
