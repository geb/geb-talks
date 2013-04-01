# Feature Tour!

More info @ [http://gebish.org/manual/current](http://www.gebish.org/manual/current)

## Form Shortcuts

Geb makes it easy to deal with all form controls. Read and write `input`s like properties.

Finds first `input`|`select`|`textarea` with the given name.

    Browser.drive {
        firstName = "Luke" // write
        firstName == "Luke" // read
        
        someCheckbox = true
        someSelect = "some option name or value"
        someMultiSelect = ["selected1", "selected2"]
    }

Unified API for all element types.

## Driver Management

Geb caches the `WebDriver` instance (per thread) and shares it across test cases.

Manages clearing cookies and is configurable.

This can be disabled and tuned.

## Configuration Management

Looks for `GebConfig` class or `GebConfig.groovy` file (or class) on classpath.

    driver = { 
        new FirefoxDriver()
    }

    waiting {
        timeout = 2
        slow { timeout = 100 }
    }

    reportsDir = "geb-reports"

    environments {
        chrome { driver = "chrome" }
    }

`grails -Dgeb.env=chrome test functional:`

## Adhoc waiting

The `waitFor` method can be used anywhere to wait for any condition to be true.

Groovy's flexible notion of “truth” makes this powerful.

    waitFor { $("p.errorMsg") }.text() == "Error!"
    waitFor { $("p.errorMsg").text() } == "Error!"
    waitFor { $("p.errorMsg").text() == "Error!" }

Waiting options are configurable…

    waitFor(timeout: 10, retry: 0.1) { … }
    waitFor("fast") { … }

Defaults and named presets controlled by configuration.

## Implicit (power) Assertions

Implicitly turns certain statements into assertions. For example, when waiting:

    waitFor { title == "Page Title" }
    waitFor { assert title == "Page Title" } // equivalent (sorta)

Gives informative error message…

    geb.waiting.WaitTimeoutException: condition did not pass in 5.0 seconds (failed with exception)
        …
    Caused by: Assertion failed:

    title == "Page Title"
    |     |
    |     false
    Something else

## Implicit (power) Assertions

Applies to waiting content…

    class DynamicPage extends Page {
        static content = {
            errorMsg(wait: true) { $("p.errorMsg") }
        }
    }

And page “at checks”

    class GoogleHomePage extends Page {
        static at = { title == "Google" }
    }

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

## Frame / Window Support

Jumping to frames temporarily…

    withFrame($('#footer')) { assert $('span') == 'frame text' }

Focussing on an open window…

    withWindow({ title == "Another Window" }) {
        // do some stuff with the window
    }
    // back to the previous window

Managing opening new windows…

    withNewWindow({ $('a').click() }) {
        // do some stuff with the new window
    }
    // back to the previous window

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

WebDriver can automate remote browsers. This might be a local Windows VM, or a browser out in the “cloud”.

[SauceLabs](http://saucelabs.com/) offer cloud browser infrastructure that Geb can use.

    def capabillities = DesiredCapabilities.firefox()
    capabillities.setCapability("version", "5")
    capabillities.setCapability("platform", Platform.XP)
    
    def url = "http://user:pass@ondemand.saucelabs.com:80/wd/hub"
    def sauceLabsDriver = new RemoteWebDriver(
       new URL(url), capabillities
    )
    
    def browser = new Browser(sauceLabsDriver)

# Demo

[RemoteWebDriverServer](http://code.google.com/p/selenium/wiki/RemoteWebDriverServer)
