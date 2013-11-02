package _02_testing

import geb.junit4.GebTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import static util.Pause.pause

@RunWith(JUnit4)
class _01_FailedLoginTest extends GebTest {

    @Test
    void unsuccessfulLogin() {
        go "/login"
        pause(browser)

        assert title == "Sign in page"

        $("h1").text() == "Please sign in"
        $("form").find("input[type=text],input[type=password]").size() == 2
        $("form").with {
            username = "user"
            password = "wrong-password"
            rememberme = true
        }

        $("button").click()

        assert title == "Login Result"
        assert $("h1").text() == "Login Failed"
    }
}