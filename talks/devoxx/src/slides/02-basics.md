# WebDriver

[seleniumhq.org/projects/webdriver/](http://seleniumhq.org/projects/webdriver/)

## WebDriver

a.k.a “Selenium 2”.

* Extremely active project
* Investment from big players (Facebook, Google, Mozilla, Opera)
* Heavily used by many big sites

Becoming a [W3C standard](http://dvcs.w3.org/hg/webdriver/raw-file/515b648d58ff/webdriver-spec.html).

# Demo

WebDriver & JUnit

# Spock

[spockframework.org](http://spockframework.org)

## Spock

A developer testing framework for Java and Groovy applications.

* Open Source (ASLv2)
* Mission: Expressive tests that are a joy to read and write
* Suitable for unit, integration, functional testing
* Strong JUnit integration
* Works with all major build tools, IDEs, and CI servers

About five years old.

# Demo

WebDriver & Spock

# Spock Feature Tour

## Data Driven Testing

Run the same test multiple times, vary the data.

    def "login verifies the user's credentials"() {
        when:
        login(username, password)

        then:
        at targetPage
        
        where:
        username | password || targetPage
        "devoxx" | "devoxx" || LoginSuccessPage
        "devoxx" | "dunno"  || LoginFailedPage           
    }

## Stubbing & Mocking

Spock comes with a built-in mocking framework.

## Extensions

Integrate with other frameworks and platforms.

* Hamcrest
* Unitils
* Spring
* Guice
* Tapestry
* Grails
* Griffon
* Arquillian
* ...

# Geb

[gebish.org](http://gebish.org)

## Geb

Full solution framework on top of WebDriver.

* Open Source (ASLv2)
* Groovy only
* DSL based
* Developer focussed
* Test framework agnostic (though optimized for Spock)
* Solutions to common problems

About four years old.

## Geb & Spock

Spock is the recommended test framework for Geb.

* Low ceremony (little syntactic noise)
* Highly readable
* No assertion APIs
* Great diagnostic messages

# Demo

Geb & Spock

## Geb API

The `geb.Browser` object.

    import geb.*
    
    def browser = new Browser()
    browser.go "http://app.org"
    browser.$("h1").text == "Some App"

Implicitly delegated to in GebSpecs.

    go "http://app.org"
    $("h1").text == "Some App"
