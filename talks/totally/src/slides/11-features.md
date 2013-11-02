# This and that

More info @ [http://gebish.org/manual/current](http://www.gebish.org/manual/current)

## Direct Downloading

Examine binary resources easily, with the session state.

    Browser.drive {
        go "http://myapp.com/login"

        // login
        username = "me"
        password = "secret"
        login().click()
        def downloadLink = $("a.pdf-download-link")

        // now get the pdf bytes (that requires authentication)
        def bytes = downloadBytes(downloadLink.@href)
    }

Also `downloadStream()` and `downloadText()`.

## JavaScript Interface

    <script>
        var globalVar;
        function globalFunction(arg1) {
            …
        }
    </script>

Can access global JS variables and functions with Groovy code…

    js.globalVar = 1
    assert js.globalVar == 1
    
    js.globalFunction("the arg")

## jQuery Adapter

Geb makes it easy to get a jQuery object for content.

    $("input").jquery.keydown()

Useful for simulating interactions that are difficult/unreliable with the WebDriver API.

The `jquery` property is a proxy for an equivalent jQuery object in the JS runtime.

**Not to be abused!**

## Interaction DSL (Actions)

DSL for building actions…

    import static org.openqa.selenium.Keys.*

    class SomeClass extends Page {
        static content = { someContent { $("div.someContent") } }
    }

    interact {
        keyDown SHIFT
        clickAndHold someContent
        moveToElement $("div.dropZone")
        keyUp SHIFT
        release()
    }

Builds on top of WebDriver's [`Actions`](http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/interactions/Actions.html) support.

# Demo

Interactions

## Remote Browsers

Selenium supports automating browsers on other machines.

Requires:

* Extra driver setup config
* A Selenium Server (just one jar)

Also supports a hub/node setup.

Browsers in the cloud by [SauceLabs](https://saucelabs.com/ "Sauce Labs: Mobile and Web App Testing Tools For Developers").

# Demo

Remote browsers
