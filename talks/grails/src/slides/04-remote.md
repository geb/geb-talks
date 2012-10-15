## Test Setup

How do you get the app in the right state for a test (e.g. data)?

1. At startup
2. GUI
3. A special interface
4. Via code (run the tests inside the app for direct access)

\#4 is the most convenient and maintainable, but comes at a cost.

# Or does it?

## Groovy Remote Control

The [Groovy Remote Control](http://groovy.codehaus.org/modules/remote) library allows closures to be *injected* into a running application.

1. Server listens for command (typically over HTTP)
1. Client sends serialized closures to server
1. Server deserializes the closure and executes it
1. Server sends the serialized result of the closure back to the client

This is code injection, not for production.

## Remote Control

    import groovyx.remote.client.RemoteControl
    import groovyx.remote.transport.http.HttpTransport

    // defines how to talk to the server
    def transport = new HttpTransport("http://localhost:8080/")

    // our agent for remote execution
    def remote = new RemoteControl(transport)

    // Do some math on the server
    // The return value of the closure is returned to the client
    assert remote.exec { 1 + 1 } == 2

    // Multiple closures can be executed in a chain, 
    // with the result of the previous passed to the next
    assert remote.exec({ 1 }, { it + 1 }, { it + 1 }) == 3

## Grails Remote Control Plugin

The [Grails Remote Control Plugin](http://grails.org/plugin/remote-control) takes care of the details.

1. Adds the HTTP server listener at test time
1. Preconfigures the client component during test execution
1. Gives access to the application context, for access to services etc.

<!-- -->

    import grails.plugin.remotecontrol.RemoteControl
    
    class SomeSpec extends Specification {
        def "some test"() {
            new RemoteControl().exec {
                ctx.peopleService.createPerson()
            }
        }
    }

# Demo

\#4 - Remote Control Plugin

## Remote Control

<img src="img/remote.png" />

* Facilitates fast development cycle by reducing need for application restarts.
* Grails plugin handles the configuration.
* Grails plugin is only configured for test environment.
