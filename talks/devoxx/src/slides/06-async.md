# Async

Trying to solve the halting problem…

## Async

Modern web apps are fundamentally async.

* Ajax
* Effects
* Single Page Apps

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

# Demo 

Async Login