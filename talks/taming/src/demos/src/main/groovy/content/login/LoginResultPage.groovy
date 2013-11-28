package content.login

import geb.Page

class LoginResultPage extends Page {

    static at = { title == "Login Result" }

    static content = {
        heading { $("h1").text() }
    }
}
