# Groovy

[http://groovy-lang.org](http://groovy-lang.org)

## Dynamic JVM Language 

Groovy is…

* Compiled, never interpreted
* Dynamic, optionally typed
* 99% Java syntax compatible
* Concise, clear and pragmattic
* Great for DSLs

## Geb & Groovy

Geb uses Groovy's dynamism to remove boilerplate.

    import geb.*
    
    Browser.drive {
        go "http://google.com/ncr"
        assert title == "Google"
        $("#gs_lc0").q = "Wikipedia"
        waitFor { $("li.g") }
        assert $("li.g a.l", 0).text() == "Wikipedia"
        $("li.g a.l", 0).click()
        waitFor { title == "Wikipedia" }
    }

\* As of Geb 0.7.0 also uses Groovy's compile time transfomations for better error diagnostics.

# Demo

Google for Wikipedia