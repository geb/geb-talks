# WebDriver

[http://seleniumhq.org/projects/webdriver/](http://seleniumhq.org/projects/webdriver/)

## WebDriver

Successor to the Selenium project.

Also known as “Selenium 2”.

Sponsored and driven by Google.

Becoming a W3C standard.

[http://dvcs.w3.org/hg/webdriver/raw-file/515b648d58ff/webdriver-spec.html](http://dvcs.w3.org/hg/webdriver/raw-file/515b648d58ff/webdriver-spec.html)

## Cross-browser automation

Java based, with many language bindings.

    import org.openqa.selenium.*;
    import org.openqa.selenium.firefox.*;

    WebDriver driver = new FirefoxDriver();
    driver.get("http://google.com");
    WebElement searchBox = driver.findElement(By.name("q"));
    searchBox.sendKeys("webdriver");
    driver.findElement(By.name("btnK")).click();

<img src="img/browsers.png" style="margin-top: 2em"/>

## Mobile Browsers

Rapidly improving.

* iPad
* iPhone
* Android
* Blackberry

Can use real devices or emulators in most cases.

A headless driver based on [PhantomJS](http://phantomjs.org/ "PhantomJS: Headless WebKit with JavaScript API") (called [GhostDriver](https://github.com/detro/ghostdriver)) is in progress.

## Driver dependency

You need to pull in a specific driver implementation for each browser you want to work with.

    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-firefox-driver</artifactId>
      <version>2.30.0</version>
    </dependency>

## Browser farms

WebDriver supports running a "driver server" allowing the creation of a browser farm.

1. Use multiple browsers for parallel execution
2. Run tests on Linux, but test with IE
3. Centrally manage browsers for CI and developers in one place

You can even run browsers in the cloud with [SauceLabs](https://saucelabs.com/ "Sauce Labs: Cloudified Mobile & Browser Testing").

(more on this later)

## WebDriver

**Pros:**

1. The only game in town for cross browser automation
3. Very active development
4. Stable API and feature set

**Cons:**

1. Verbose
2. Low level
3. Not a complete solution

Geb aims to embrace the pros and solve the cons by building on top.

## Geb & WebDriver

WebDriver does the heavy lifting of talking to browsers. 

Geb is a convenience framework around WebDriver.

You can access the WebDriver API if you need it.
