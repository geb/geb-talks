# Content DSL

Reuse FTW

## Content DSL

    class SomePage extends Page {
        static content = {
            «name»(«options») { «lookup» }
        }
    }

Content definitions are actually *templates*, implemented as Groovy closures.

## Content properties

    class SomePage extends Page {
        static content = {
            heading { $("h1") }
        }
    }

Defined content can be accessed as properties…

    to SomePage
    assert heading.tagName() == "h1"

## Content methods

    class SomePage extends Page {
        static content = {
            listItem { index -> $("li", index) }
        }
    }

Content can be parameterised, then accessed via methods…

    to SomePage
    assert listItem(3).text() == "Item 4"

## Stacked content

    class GoogleResultsPage extends Page {
        static content = {
            results { $("li.g") }
            result { i -> results[i] }
            resultLink { i -> result(i).find("a.l", 0) }
            firstResultLink { resultLink(0) }
        }
    }

Content definitions can *build* upon each other.

## Value content

    class SomePage extends Page {
        static content = {
            headingText { $("h1").text() }
        }
    }

Defined content can be any type of object…

    to SomePage
    assert heading == "Welcome to Geb!"

## Optional Content

    class OptionalPage extends Page {
        static content = {
            errorMsg(required: false) { $("p.errorMsg") }
        }
    }

By default, Geb will error if the content you select doesn't exist to support the principle of fail-fast.

The “`required`” option disables this check.

# Demo

Pages
