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

Geb uses Groovy's dynamism to remove boilerplate, to achieve pseudo English *code*.

    to GoogleHomePage
    searchFor "Wikipedia"
    assert resultName(0) == "Wikipedia"
    resultLink(0).click()
    at WikipediaPage

Conciseness = improved clarity & improved maintainability.

\* As of Geb 0.7.0 also uses Groovy's compile time transfomations for better error diagnostics.

# Demo

Google for Wikipedia