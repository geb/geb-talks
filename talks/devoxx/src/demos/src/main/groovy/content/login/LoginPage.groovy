package content.login

import geb.Page

class LoginPage extends Page {

    static url = "/login"

    static at = { title == "Sign in page" }

    static content = {
        form { $("form") }
        heading { $("h1").text() }
        signinButton { $("button") }
        textTypeControls { form.find("input[type=text],input[type=password]") }
    }

    void login(String usernameValue, String passwordValue, boolean rememberValue) {
        username = usernameValue
        password = passwordValue
        rememberme = rememberValue

        signinButton.click()
    }

}
