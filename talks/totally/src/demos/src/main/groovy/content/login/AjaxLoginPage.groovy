package content.login

class AjaxLoginPage extends LoginPage {

    static url = "/ajax-login.html"

    static content = {
        signinButton(to: AjaxLoginPage) { $("form button") }
        alertDialog(wait: true) { $("div.alert") }
        alertMessage(wait: true) { alertDialog.find("div").text() }
        alertCloseButton { alertDialog.find(".close") }

        alertDialogIsClosed(wait: true) { !$("div.alert").displayed }
    }

}