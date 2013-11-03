# Reporting

When things go wrong

## Error reporting

Your tests will fail. Expect it.

Geb helps by…

* Taking screenshots and HTML reports
* Supporting good error diagnostics
* Failing fast

## Reporting Tests

Geb's test adapters take state reports after each test method.

Reports are saved in a directory based on the name of the executing test.

    class MyTest extends GebReportingTest {
        @Test void aTest() {
            // …
        }
    }

`GebReportingTest` and `GebReportingSpec` add this functionality.

## Manual reports

You can take a report at any time with the `report «label»` method.

    class MySpec extends GebReportingSpec {
        void "some feature works"() {
            when:
            // some stuff…
            report "after some stuff"
            
            then:
            // it works
        }
    }

## Configuration

Geb has a built in configuration framework.

You must specify where to write reports.

`GebConfig.groovy`:

    reports = "build/geb-reports"

There are other config options.

# Demo

Reporting
  