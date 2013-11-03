package _05_async

import content.login.AjaxLoginPage
import content.login.LoginSuccessPage
import geb.spock.GebSpec

class _01_AjaxLogin extends GebSpec {

    def "bad login produces closeable error alert"() {
        given:
        to AjaxLoginPage

        when:
        login("foo", "bar", false)

        then:
        alertMessage == "Login failed."
        alertDialog.hasClass("alert-error")

        when:
        alertCloseButton.click()

        then:
        alertDialogIsClosed
    }

    def "valid login goes to success page"() {
        given:
        to AjaxLoginPage

        when:
        login("user", "password", true)

        then:
        waitFor { at LoginSuccessPage }
    }

}
