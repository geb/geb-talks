# Grails

Productive Functional Testing

## Functional testing?

Tests the entire application stack. 

Simulates the users interaction with the application. 

Typically means automating a web browser.

At the HTTP or HTML/DOM level.

Grails has a dedicated `functional` testing phase.

## Automated functional tests

Many firms functionally test manually. This is wasteful.

Let machines do what they are good at; doing the same thing over and over.

Let humans (QA/testers) do what they are good at; explore and experience the system.

This talk is about _automating_.

## Cost vs. Value

Functional tests have the highest cost, but have the highest value.

Highest cost:

* Slower to run
* More complex to develop
* More fragile over time

Highest value:

* Most assurance that the system works
* Greatest number of lines of code under test
* Most important to the business

## It's hard

Why?

* Orchestration of many components (browser, app, db)
* Inherently asynchronous & temperamental
    * Orchestration (automating the browser)
    * Interactions (fancy UIs)
* Slower development feedback loop
* Tedious to debug

## Don't ignore it

Functional testing takes more effort than unit testing, both in development and maintenance.

Just because it's hard doesn't mean it shouldn't be done.

* Pick your battles
* Test the critical paths
* Use smart tools/techniques to reduce the cost
* Do cost/benefit analysis
