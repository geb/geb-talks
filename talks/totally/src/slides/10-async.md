# Ajax and effects

Trying to solve the halting problem…

## Async

Modern web apps are fundamentally async.

* Ajax
* Effects

Only practical solution is to use spin asserts.

## Spin asserts

Keep polling to see if something is true yet.

    sendRequestButton.click()
    waitFor { $("img.spinner").displayed }
    waitFor { $("p.requestResult").text() == "Request Successful!" }

The `waitFor()` method can be used anywhere to wait for any condition to be true.

## Groovy Truth

Groovy's flexible notion of “truth” makes this powerful.

    waitFor { $("p.errorMsg") }.text() == "Error!"
    waitFor { $("p.errorMsg").text() } == "Error!"
    waitFor { $("p.errorMsg").text() == "Error!" }

Depends on what you are testing for.


## Dynamic Content

    class DynamicPage extends Page {
        static content = {
            errorMsg(wait: true) { $("p.errorMsg") }
        }
    }

Geb will implicitly wait for this content to appear.

    to DynamicPage
    errorMsg.text == "Ajax request failed!"

By default, it will look for it every 100ms for 5s before giving up.

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

Wind up the timeout value on the CI server…

`GebConfig.groovy`:

    waiting {
        timeout = isCiServer ? 60 : 10
        retryInterval = 0.5
    }

Avoids premature timeouts and false failures.

# Demo

Async