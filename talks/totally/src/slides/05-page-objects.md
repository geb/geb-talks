# Page Objects

**The** key to not pulling your hair out when dealing with web tests.

## What are they?

In a phrase: Domain Modelling.

By modelling and creating *abstractions*, we can isolate implementation detail.

    $("input[name=username]").value("user")
    $("input[name=username]").value("password")
    $("input[type=submit]").click()

Is far more fragile than this…

    void login(String username, String password) {
        $("input[name=username]").value(username)
        $("input[name=username]").value(password)
        $("input[type=submit]").click()
    }

    login("user", "password")

## Just good programming

It's the application of trusted principles; encapsulation and reuse. Not new at all, but new to the world of web testing/automation.

Traditional browser automation focussed on the page document structure. 

    $("form.contact-details input[type=submit]").click()

Page objects abstract from this, focussing on _user_ concepts.

    somePage.submitButton().click()

When done well, introduces the lexicon of the application into the tests/scripts (e.g. books, people, orders).

    orders[0].lineItems[2].price == 2.00

## Browser has-a Page

    to GoogleHomePage
    search.forTerm "wikipedia"
    at GoogleResultsPage
    assert firstResultLink.text() == "Wikipedia"
    firstResultLink.click()
    waitFor { at WikipediaPage }

The `to()` and `click()` methods are changing the underlying page.

You can refer to the current page's content and methods just by name.

---

This is the first introduction to all of the dynamic dispatch stuff. Might deserve a better treatment.

## Geb's Page Objects

Geb builds the Page Object pattern deeply into the framework (though it is optional).

    import geb.*

    class GoogleHomePage extends Page {
        static url = "http://google.com/ncr"
        static at = { title == "Google" }
        static content = {
            search { module GoogleSearchModule }
        }
    }

## Geb's Page Objects

Features the “Content DSL” for naming content in a dynamic and powerful way.

    import geb.*

    class GoogleResultsPage extends Page {
        static content = {
            search { module GoogleSearchModule }
            results { $("li.g") }
            result { i -> results[i] }
            resultLink { i -> result(i).find("a.l", 0) }
            firstResultLink { resultLink(0) }
        }
    }

More on this later.

## Geb's Page Objects

Very lightweight, minimum requirements are low.

    import geb.*

    class WikipediaPage extends Page {
        static at = { title == "Wikipedia" }
    }

You can pick which Page Object features you want.

# Demo

Google for Wikipedia (with pages)
