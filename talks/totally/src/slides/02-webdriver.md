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
      <version>2.22.0</version>
    </dependency>

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

## Architecture

<img src="img/testing_architecture.png" style="margin-top: 2em"/>

## WebDriver API

Geb sits on top of WebDriver so you very rarely deal with its API, though it's accessible if you need it.

Geb never talks to the actual browser. 

That's what WebDriver does.
