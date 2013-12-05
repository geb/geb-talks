package _05_async

import content.login.AsyncLoginPage
import content.login.LoginSuccessPage
import geb.spock.GebReportingSpec

class _01_AsyncLogin extends GebReportingSpec {

    def "bad login produces closeable error alert"() {
        given:
        to AsyncLoginPage

        when:
        login "foo", "bar", false

        then:
        alertMessage == "Login failed."
        alertDialog.hasClass "alert-error"

        when:
        alertCloseButton.click()

        then:
        alertDialogIsClosed
    }

    def "valid login goes to success page"() {
        given:
        to AsyncLoginPage

        when:
        login "rwx", "rwx", true

        then:
        waitFor { at LoginSuccessPage }
    }

}
