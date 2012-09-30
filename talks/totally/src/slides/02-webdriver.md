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

    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.By;
    import org.openqa.selenium.firefox.FirefoxDriver;

    WebDriver driver = new FirefoxDriver();
    driver.get("http://google.com");
    WebElement heading = driver.findElement(By.tagName("h1"));

<img src="img/browsers.png" style="margin-top: 2em"/>

## Mobile Browsers

Rapidly improving.

* iPad
* iPhone
* Android
* Blackberry

Can use real devices or emulators in most cases.

A headless webkit based driver (PhantomJS) is in progress.

## WebDriver API

Geb sits on top of WebDriver so you very rarely deal with its API, though it's accessible if you need it.

Geb never talks to the actual browser. 

That's what WebDriver does.

## Driver dependency

You need to pull in a specific driver implementation for each browser you want to work with.

    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-firefox-driver</artifactId>
      <version>2.22.0</version>
    </dependency>
