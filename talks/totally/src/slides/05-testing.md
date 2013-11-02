# Testing

Geb's testing adapters

## Geb for Testing

Geb can be used with…

* Spock
* JUnit (3 & 4)
* TestNG
* EasyB
* Cucumber (Cuke4Duke)

The majority of Geb users use Spock.

## Test adapters

The heart is the **geb-core** dependency which is all you really need (plus WebDriver).

For testing, you also need one of these:

* geb-spock
* geb-junit3
* geb-junit4
* geb-testng
* geb-easyb

There is also a Grails plugin.

## Architecture

<img src="img/testing_architecture.png" style="margin-top: 2em"/>

## Implicit browser delegation

    class GoogleTest extends GebTest {
        @Test void aTest() {
            go "http://google.com"
            assert title == "Google"
        }
    }

Via Groovy's `methodMissing()` and `propertyMissing()`.

# Demo

Geb Testing
