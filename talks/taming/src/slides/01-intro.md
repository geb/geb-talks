# Spock & Geb

Taming Functional Web Testing

## About Us

Peter Niederwieser

* Principal Engineer at Gradleware
* Computer language & chocolate addict based in Linz, Austria
* Creator of Spock

Luke Daley

* Principal Engineer at Gradleware
* Musician & kangaroo hunter based in London
* Creator of Geb

## The Challenge

Functional web testing is hard:

* Hard to automate
* Flakey
* Slow

But also rewarding:

* Proves that your app works
* Iterate faster
* Save money

# Approaches

## Recorder Driven

Record human browser interaction.

Example: Selenium IDE

* Easy to produce
* Hard to reason about
* Hard to maintain
* Hard to evolve

## Scripting

Scripted browser interaction.

Examples: Canoo WebTest, early WebDriver

* Easier to reason about, maintain, and evolve than Recorder Driven
* Low-level, HTML-centric language
* Some reuse and abstraction

## Model Driven

Scripted interaction with (model of) web app.

Examples: WebDriver with Page Objects

* Easier to reason about, maintain, and evolve than Scripting
* High-level, domain-centric language
* Good reuse and abstraction
* Higher initial cost than Scripting

## Natural Language

Formulate use cases in English-like language.

Examples: Cucumber, JBehave

* Layer on top of Scripting/Model Driven
* Involve non-technical stakeholders
* Supports reuse
* Indirection cost

## Spock & Geb

Developer focused approach.

* (Groovy) code-only, yet very readable
* Strong modeling
* Focus on usability and good feedback
