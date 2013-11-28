# Geb Feature Tour

More info @ [http://gebish.org/manual/current](http://www.gebish.org/manual/current)

## Mobile Browsers

WebDriver supports:

* Android Browser
* Mobile Safari (iPhone & iPad)

[https://code.google.com/p/selenium/wiki/WebDriverForMobileBrowsers](https://code.google.com/p/selenium/wiki/WebDriverForMobileBrowsers)

## Single Page Apps

No real difference.

Can still use page objects.

Liberal use of _waiting_.

## JavaScript Interface

    <script>
        var globalVar;
        function globalFunction(arg1) {
            …
        }
    </script>

Access global JS variables and functions from Groovy code…

    js.globalVar = 1
    assert js.globalVar == 1
    
    js.globalFunction("the arg")

## jQuery Adapter

Dynamic Groovy side jQuery proxies.

    $("input").jquery.keydown()

Useful for simulating events.

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
