package util

import grails.plugin.remotecontrol.RemoteControl

class TestFixture {

    RemoteControl remote = new RemoteControl(useStringRepresentationIfResultWasUnserializable: true)

    void build(Map counts) {
        remote.exec { ctx.baseFixtureBuilder.build(counts) }
    }

    protected createSaveCommand() {
        return {
            it.merge(failOnError: true, flush: true)
            it.id
        }
    }

    protected createGetObjectCommand(kind, index, refresh) {
        return { k, i, r ->
            def obj = ctx.baseFixtureBuilder."$k"(i)
            try {
                obj.attach()
            } catch (org.springframework.orm.hibernate3.HibernateSystemException e) {

            }
            if (r) {
                obj.refresh()
            }
            obj
        }.curry(kind, index, refresh)
    }

    protected createSetupFixtureInCommandContextCommand() {
        return {
            fixture = ctx.baseFixtureBuilder.fixture
        }
    }

    def modify(String kind, index, Closure modifications) {
        remote.exec(
            createSetupFixtureInCommandContextCommand(),
            createGetObjectCommand(kind, index, true),
            modifications,
            createGetObjectCommand(kind, index, false),
            createSaveCommand()
        )
    }

    def modify(Map attributes, String kind) {
        modify(attributes, kind, 0)
    }

    def modify(Map attributes, String kind, index) {
        modify(kind, index) { obj ->
            attributes.each { k, v ->
                obj."$k" = v
            }
        }
    }

    def with(kind, index, Closure block) {
        remote.exec(
            createSetupFixtureInCommandContextCommand(),
            createGetObjectCommand(kind, index, true),
            block
        )
    }

    def attribute(String kind, index, String attributeName) {
        with(kind, index) { it.getProperty(attributeName) }
    }

    def attribute(String kind, String attributeName) {
        with(kind, 0) { it.getProperty(attributeName) }
    }

    def clean() {
        remote.exec { ctx.dbCleaner.clean() }
    }

}