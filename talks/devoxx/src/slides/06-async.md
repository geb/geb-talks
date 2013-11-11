# Async

Trying to solve the halting problem…

## Async

Modern web apps are fundamentally async.

* Ajax
* Effects
* SPAs

Only known solution is to use spin asserts.

## Spin asserts

Keep polling to see if something is true yet.

    sendRequestButton.click()
    waitFor { $("img.spinner").displayed }
    waitFor { $("p.requestResult").text() == "Request Successful!" }

Or…

    waitFor {
        $("img.spinner").displayed
        $("p.requestResult").text() == "Request Successful!"
    }

Implicitly assertions.

## Groovy Truth

Groovy's truthiness.

    waitFor { $("p.errorMsg") }.text() == "Error!"
    
    waitFor { $("p.errorMsg").text() } == "Error!"
    
    waitFor { $("p.errorMsg").text() == "Error!" }

Very useful.

## Waiting Content

    class DynamicPage extends Page {
        static content = {
            errorMsg(wait: true) { $("p.errorMsg") }
        }
    }

Waiting now implicit.

    to DynamicPage
    errorMsg.text == "Ajax request failed!"

Best approach.

## Timeout and retry

Defaults specified via config…

`GebConfig.groovy`:

    waiting {
        timeout = 10
        retryInterval = 0.5
    }

## Wait Presets

Named presets support fail fast.

    waiting {
        presets {
            slow {
                timeout = 20
                retryInterval = 1
            }
            quick {
                timeout = 1
            }
        }
    }
    
<!-- -->

    waitFor("slow") { someVerySlowThing() }

## “Continuous Optimist”

Wind up the timeout value on the CI server.

`GebConfig.groovy`:

    waiting {
        timeout = isCiServer ? 60 : 10
        retryInterval = 0.5
    }

Avoids premature timeouts and false failures.
