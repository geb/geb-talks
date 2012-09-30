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

Geb can dump HTML and screenshots for each “test” to help in debugging.

## Screenshots and HTML reports

Geb's test adapters automatically do this after each test method.

File system location is determined by class name and test name.

    target/test-reports/myorg/tests/SomeTest/
                    001-001-I test some stuff-end.html
                    001-001-I test some stuff-end.png
                    002-001-I test some more stuff-end.html
                    002-001-I test some more stuff-end.png

Manual grabs can be made any time…

    to SomePage
    report "at SomePage" // report label

    target/test-reports/myorg/tests/SomeTest/
                    001-002-I test some stuff-at SomePage.html

# Demo

Geb Testing

