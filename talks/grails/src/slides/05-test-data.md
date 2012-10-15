## Test data

Functional tests can require non trivial data sets.

Having a good strategy and good tools for rapidly creating data sets is an enabler.

GORM by hand is too cumbersome for real data sets.

## Fixtures Plugin

The [Fixtures Plugin](http://grails.org/plugin/fixtures) is a specialised DSL for loading domain object _graphs_.

More concise and DRY than straight GORM, and more convenient to use dynamically.

It's a Spring application context of domain objects, and uses the BeanBuilder DSL.

It also integrates with the excellent [Build Test Data Plugin](http://grails.org/plugin/build-test-data).

# Demo

\#5 - Fixtures Plugin

## Test data isolation

Grails integration tests use rollback-only transactions to isolate test data.

This is not possible for functional tests.

A generally applicable strategy is to use a “db cleaner”. 

That is, before each test just delete all data.

## DB Cleaner

General approach…

1. Disable referential integrity checks
1. Loop through tables, TRUNCATEing
1. Enable referential integrity checks

This is generally the easiest way.

# Demo

\#6 - DB Cleaner

## Parallelism?

Using a DB cleaner prevents parallel test execution.

There are solutions to this problem that we'll discuss at the end.

## Base Fixture Builders

Create factories and builders that can generate test data sets that your app needs.

Use domain knowledge to create generic data sets in different shapes, then fine tune for your needs.

Use scaling strategies to create the initial generic set.

# Demo

\#7 - Base Fixture Builders

## Base Fixture Builders

Takes some thinking to get right. 

If done well, makes getting data set up for new tests trivial. 

You can have more than one type of builder.

The fixture plugin DSL is convenient to “wrap” because of the referencing.