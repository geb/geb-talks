package content.login

class AsyncLoginPage extends LoginPage {

    static url = "/async-login"

    static content = {
        signinButton(to: AsyncLoginPage) { $("form button") }
        alertDialog(wait: true) { $("div.alert") }
        alertMessage(wait: true) { alertDialog.find("div").text() }
        alertCloseButton { alertDialog.find(".close") }

        alertDialogIsClosed(wait: true) { !$("div.alert").displayed }
    }

}