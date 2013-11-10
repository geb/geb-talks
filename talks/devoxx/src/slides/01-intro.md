# Geb & Spock

Taming Functional Web Testing

## The Problem

Automated functional web testing is painful.

Unfortunately, can't ignore it just because it's hard.

## High cost

* flakey
* hard to write
* slow

## High value

When done right, gives high assurance that things are working.

# Approaches

## Recorder Driven

e.g. Selenium IDE

* Easy to produce
* Hard to evolve
* Hard to read
* Hard to refactor
* Hard to remove

Incomprehensible.

## Programmatic

e.g. Canoo WebTest, early WebDriver

* Marginally better than recorder driven.
* Typically no reuse or abstractions.

## Model Driven

e.g. Page Objects

* Easier to maintain & refactor
* Supports reuse
* Better comprehensibility through abstractions

## Natural Language

e.g. Cucumber

* Can be layered on top of modelling
* Emphasis on comprehensibility
* Supports reuse
* Indirection cost

## Geb & Spock

Developer productivity focussed approach.

* DSL based (not Natural Language)
* Just Groovy code (no regular expression mapping)
* Emphasis on modelling
* Optimized for failure
