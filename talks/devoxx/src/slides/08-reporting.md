# Reporting

## Error reporting

Your tests will fail. Expect it.

Geb helps by…

* Taking screenshots and HTML reports
* Supporting good error diagnostics
* Failing fast

## Reporting Tests

    import geb.spock.*
    
    class MySpec extends GebReportingSpec {
        def "test some stuff"() {
            // …
        }
    }

HTML and screen dumps after each test method. 

## Adhoc reports

    class MySpec extends GebReportingSpec {
        void "some feature works"() {
            when:
            // some stuff…
            report "after some stuff"
            
            then:
            // it works
        }
    }