# This and that

More info @ [http://gebish.org/manual/current](http://www.gebish.org/manual/current)

## Direct Downloading

Examine binary resources easily, with the session state.

    class AdminPdfSpec extends GebSpec {
        when:
        to LoginPage
        loginAs "user1", "password"
        
        then:
        def pdfUrl = $("a.pdf-download-link").@href
        def pdf = downloadBytes(downloadLink.@href)
        
        extractTextWithPdfBoxFrom(pdf) == "Username: user1"
    }

Also `downloadStream()` and `downloadText()`.

## JavaScript Interface

    <script>
        var globalVar;
        function globalFunction(arg1) {
            …
        }
    </script>

Access global JS variables and functions with Groovy code…

    js.globalVar = 1
    assert js.globalVar == 1
    
    js.globalFunction("the arg")

## jQuery Adapter

Dynamic Groovy side jQuery proxies.

    $("input").jquery.keydown()

Useful for event simulation.

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

## Remote Browsers

Selenium supports automating browsers on other machines.

Requires:

* Extra driver setup config
* A Selenium Server (just one jar)

Also supports a hub/node setup.

Browsers in the cloud by [SauceLabs](https://saucelabs.com/ "Sauce Labs: Mobile and Web App Testing Tools For Developers").
