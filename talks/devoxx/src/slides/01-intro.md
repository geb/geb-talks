# Geb & Spock

Taming Functional Web Testing

## The Problem

# Approaches

## Recorder Driven

* Easy to produce, impossible to maintain
* Optimizing the wrong thing
* Difficult to understand after fact
* Hard to refactor
* Hard to remove (don't know what it's doing)

## Programmatic

Early generations of tools: Imperative scripts, no modelling.

Only slightly better than recorded tests.

Lots of duplicate code.

Hard to understand over time.

## Model Driven

Introduction of page objects (i.e. domain modelling).

Modelling framework for web app interaction.

Focussed on the _concept_ of a page as the central unit.

Reduced duplication, increased clarity (somewhat).

## Natural Language

Different execution model based on higher order story description.

e.g. Fitnesse, Cucumber.

Introduces indirection overhead to enhance clarity and promote reuse.

Cost of extra overhead is not always offset by increased communication gains.
Developers understand code, optimise for developers.

## Geb & Spock

Geb: DSL oriented framework for browser automation
Spock: Productivity and expressivity focussed test execution framework

Maintainable, expressive tests purely in code.



