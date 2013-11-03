package _01_scripts

import geb.Browser

import static util.Pause.pause

def browser = new Browser()

browser.go "/login"

pause(browser)

assert browser.page.title == "Sign in page"
assert browser.page.find("h1").text() == "Please sign in"

assert browser.page.find("form").find("input[type=text],input[type=password]").size() == 2

browser.page.find("#username").value("user")
browser.page.find("#password").value("wrong-password")
browser.page.find("#rememberme").value(true)

browser.page.find("button").click()

assert browser.page.title == "Login Result"
assert browser.page.find("h1").text() == "Login Failed"

browser.quit()