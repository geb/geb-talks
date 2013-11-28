# Page Objects

## Page Objects

A useful unit of abstraction to give our code some structure.

Popularized by WebDriver.

Bad…

    $("input[name=username]").value("user")
    $("input[name=password]").value("password")
    $("input[type=submit]").click()

## Page Objects

Better…

    page.login "user", "password"

* Encapsulation of structure
* Behaviour as methods
* Reusable unit 
    
## Higher abstractions

User language:

     contactDetailsForm.submitButton().click()

Domain language:

    orders[0].lineItems[2].price == 2.00
    
    
<br />More comprehensible.

## Geb's Page Objects

    import geb.*

    class GoogleHomePage extends Page {
        static url = "http://google.com/ncr"
        static at = { title == "Google" }
        
        static content = {
            // The content DSL
        }
        
        void anInstanceMethod() {}
    }

## Navigation

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

Delegated to implicitly…

    browser.login(…)    

In test/spec…

    login(…)

## At the right page?

Fail fast == less debugging.

    class LoginPage extends Page {
        static at = { 
            title == "Login Page"
            $("h1").text() == "Please log in" 
        }
    }

<!-- -->

    menu.loginButton.click()
    at LoginPage

Will throw an exception unless every statement of the at check is true.
