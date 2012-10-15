## User Emulation Strategies

From most accurate and most costly to least…

1. Real browser automation
2. Simulated browser (e.g. HTMLUnit)
3. HTTP with HTML scraping

\#3 may be a valid option in some cases.

## My advice…

If you're going to go to the effort of having full stack functional tests, do it properly. 

That is, **automate a real browser**.

Why?

1. Most assurance that things work
2. It's not _that_ much more cost

Tools are getting better all the time to reduce the cost.

## Geb & WebDriver

[Geb](http://www.gebish.org/ "Geb - Very Groovy Browser Automation") is a Groovy DSL layer on top of [WebDriver](http://code.google.com/p/selenium/) (aka Selenium 2).

WebDriver = browser orchestration.

WebDriver + Groovy + Framework = Geb

Why Geb?

1. Groovy DSL (concise)
2. Complete framework
3. Lots of features (e.g. reporting)
4. Promotes good patterns

## Geb & Spock

[Spock](http://spockframework.org/) is a next generation testing tool, replacing JUnit.

Geb is not a test execution framework, so it integrates with a few:

1. Spock
2. JUnit
3. TestNG
4. EasyB
5. Cucumber

Geb was written with Spock in mind and it's a nice fit.

# Demo

\#1 - Getting Geb running

## Page Objects

Geb supports the [“page object” pattern](http://www.gebish.org/pages).

The page object pattern is the concept that enables domain modelling for interacting with web sites.

Why?

2. Reuse
3. Maintainability
4. Comprehensibility

# Demo

\#2 - Page Objects

## Quality matters

Test code quality is critical. 

If you don't keep your test code well factored and clean it will atrophy and die.

Functional test code exacerbates this issue due to the inherent complexity.

Bottom line:

1. Embrace reuse
2. Model abstractions/concepts
3. Refactor