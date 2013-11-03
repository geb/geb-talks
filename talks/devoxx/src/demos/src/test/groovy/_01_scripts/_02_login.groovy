package _01_scripts

import geb.Browser

import static util.Pause.pause

Browser.drive {
    go "/login"

    pause(browser)

    assert title == "Sign in page"
    assert $("h1").text() == "Please sign in"

    assert $("form").find("input[type=text],input[type=password]").size() == 2

    $("form").with {
        username = "user"
        password = "wrong-password"
        rememberme = true
    }

    $("button").click()

    assert title == "Login Result"
    assert $("h1").text() == "Login Failed"

}.quit()