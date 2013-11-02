# Page Objects

**The** key to not pulling your hair out when dealing with web tests.

## What are they?

In a phrase: Domain Modelling.

By modelling and creating *abstractions*, we can isolate implementation detail.

Bad…

    go "/login.html"
    $("input[name=username]").value("user")
    $("input[name=password]").value("password")
    $("input[type=submit]").click()

## Page Objects

Better…

    void login(String username, String password) {
        $("input[name=username]").value(username)
        $("input[name=password]").value(password)
        $("input[type=submit]").click()
    }
    
    go "/login.html"
    login("user", "password")

Encapsulation, reuse, composition.
    
## Just good programming

Traditional browser automation focussed on the page document structure. 

    $("form.contact-details input[type=submit]").click()

Page objects abstract from this, focussing on _user_ concepts.

    somePage.submitButton().click()

## Domain modelling

When done well, introduces the lexicon of the application into the tests/scripts (e.g. books, people, orders).

    to OrdersPage
    
    orders[0].lineItems[2].price == 2.00

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

Pages can define a url that defines the page location.

The `to()` method sends the browser there and sets that as the current page object.

    to GoogleHomePage

The page url can be relative (will be resolved against a config driven base).

## Browser has-a Page

    browser.to(LoginPage)
    browser.page instanceof LoginPage
    
    browser.page.login(…)
    
    browser.page instanceof LoginFailedPage

Certain methods change the underlying page instance.

## Page delegation

The `browser` forwards unhandled method calls to its `page`.

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
