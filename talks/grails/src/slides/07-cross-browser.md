## Cross Browser testing

Typical pattern:

1. Everyone uses the same browser for local test runs (usually FireFox or Chrome).
2. The CI farm runs the tests with other browsers.

Works great, except when you need to debug for one of the browsers tested by CI.

Really only an issue when multiple platforms are involved.

## Cross Browser Platform testing

Strategies?

1. Commit, push, pray, repeat (i.e. hope CI passes)
2. Setup a development environment on the other platform

Neither of these are really appealing.

## Remote browser execution

WebDriver (and therefore Geb) allow you to use browsers on other machines.

<img src="img/remotebrowser.png" />

You can debug, develop and execute from your familiar platform, and test with a browser on a different platform.

# Demo

\#9 - Remote Browsers

## CI?

You don't need Windows or Mac CI Servers.

You can have Windows and Mac “WebDriver servers” that just host browsers.

Developers can also use these servers for local debugging/development.

## SauceLabs

[SauceLabs](http://saucelabs.com/) offer cloud browser infrastructure that Geb can use.

    environments {
        "xp-ff-5" {
            def capabilities = DesiredCapabilities.firefox()
            capabilities.setCapability("version", "5")
            capabilities.setCapability("platform", Platform.XP)

            def url = "https://user:pass@ondemand.saucelabs.com:80/wd/hub"
            new RemoteWebDriver(new URL(url), capabilities)
        }
    }

Not free, but a very good service.