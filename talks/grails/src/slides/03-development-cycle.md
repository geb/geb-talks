## Development cycle

Biggest complaint about functional tests: *slow development cycle*

Typically looks like…

1. Write some test
2. `grails test-app …`
3. Write some more test
4. `grails test-app …`
5. *rinse repeat*

Slow because you have to restart the whole app each time.

This is unnecessary pain.

## Decoupling the tests

If the functional tests can run outside of the application process, no restart required.

Two strategies for this:

1. [Functional Test Development Plugin](http://grails.org/plugin/functional-test-development)
2. IDE configuration

The `-baseUrl=«url»` argument prevents the app from starting up.

## Functional Test Development

Orchestrates two separate Grails processes: the app and the tests.

Runs the tests many times against the same app instance.

New features:

1. Grails 2.0 support
2. Application change reloading
3. Readline (e.g. history) support

## IDE Configuration

You can simulate the “Functional Test Development” plugin with your IDE.

Downside is that it requires some fiddly configuration.

# Demo

\#3 - Development Cycle

## Functional Test Development

    grails develop-functional-tests

**Pros:**

1. Handles the orchestration of the app and test processes
2. No configuration

**Cons:**

1. More processes (more memory)
2. Not your IDE (different environment)

## IDE configuration

**Pros:**

1. No need to leave familiar environment
2. Clickable stacktraces

**Cons:**

1. Fiddly configuration
