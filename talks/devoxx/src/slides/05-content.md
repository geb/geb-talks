# Content DSL

## Content DSL

General form…

    class SomePage extends Page {
        static content = {
            «name»(«options») { «definition» }
        }
    }

## Content properties

Unparameterized…

    class SomePage extends Page {
        static content = {
            heading { $("h1") }
        }
    }

Read as properties…

    to SomePage
    assert heading.tagName() == "h1"

## Content methods

Parameterized…

    class SomePage extends Page {
        static content = {
            listItem { index -> $("li", index) }
        }
    }

Called like methods…

    to SomePage
    assert listItem(3).text() == "Item 4"

## Stacked content

Content can build on other content.

    class GoogleResultsPage extends Page {
        static content = {
            firstResultLink { resultLink(0) }
            resultLink { i -> result(i).find("a.l", 0) }
            result { i -> results[i] }
            results { $("li.g") }
        }
    }

## Value content

Content can be anything…

    class SomePage extends Page {
        static content = {
            headingText { $("h1").text() }
            price { $("div.cart").text().toDouble() }
        }
    }

<!-- -->

    to SomePage
    assert heading == "Welcome to Geb!"
    assert price == 99.99

## Fail fast

Content must be true-ish, unless not required.

    class OptionalPage extends Page {
        static content = {
            heading { $("h1") }
            errorMsg(required: false) { $("p.errorMsg") }
        }
    }

On empty page…

    heading.text() == "foo" // exception
    errorMsg.size() == 0 // no exception
