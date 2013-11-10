# Page Objects

## Page Objects

A useful unit of abstraction to give our code some structure.

Popularized by WebDriver.

Bad…

    go "/login.html"
    $("input[name=username]").value("user")
    $("input[name=password]").value("password")
    $("input[type=submit]").click()

## Page Objects

Better…

    to LoginPage
    login "user", "password"

Encapsulation, reuse, composition.
    
## Focus on the domain

Focus on interaction instead of structure. 

Bad…

    $("form.contact-details input[type=submit]").click()

Better…

    contactDetailsForm.submitButton().click()

## Domain modelling

    to OrdersPage
    orders[0].lineItems[2].price == 2.00

Application domain shines through.

## Geb's Page Objects

Geb builds the Page Object pattern deeply into the framework.

    import geb.*

    class GoogleHomePage extends Page {
        static url = "http://google.com/ncr"
        static at = { title == "Google" }
        static content = {
            // The content DSL
        }
        
        void anInstanceMethod() {}
    }


## The to() method

    class GoogleHomePage extends Page {
        static url = "http://google.com/ncr"
    }

Usage:

    to GoogleHomePage

Can be relative.

## Browser has-a Page

    browser.to(LoginPage)
    browser.page instanceof LoginPage
    
    browser.page.login(…)
    browser.page instanceof LoginFailedPage

## Page delegation

This:

    browser.page.login(…)
    
Can be written as:

    browser.login(…)

## At Checking

The “at checking” mechanism enables fail fast and less debugging.

    class LoginPage extends Page {
        static at = { 
            title == "Login Page"
            $("h1").text() == "Please log in" 
        }
    }

<!-- -->

    menu.loginButton.click()
    at LoginPage

Will throw an exception if every statement of the at check is not true.
