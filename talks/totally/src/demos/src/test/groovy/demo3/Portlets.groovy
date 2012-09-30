package demo3

import geb.spock.GebReportingSpec
import content.portlets.PortletsPage
import spock.lang.Stepwise

@Stepwise
class Portlets extends GebReportingSpec {

    def "go to page"() {
        when:
        to PortletsPage

        then:
        at PortletsPage
    }

    def "check state"() {
        expect:
        column(0).portletNames == ["Feeds", "News"]
        column(1).portletNames == ["Shopping"]
        column(2).portletNames == ["Links", "Images"]
    }

    def "drag the news portlet"() {
        when:
        portlet("News").moveAfter portlet("Images")

        then:
        column(0).portletNames == ["Feeds"]
        column(1).portletNames == ["Shopping"]
        column(2).portletNames == ["Links", "Images", "News"]
    }

    def "move the shopping portlet"() {
        when:
        portlet("Shopping").moveBefore portlet("Feeds")

        then:
        column(0).portletNames == ["Shopping", "Feeds"]
        column(1).portlets.empty
        column(2).portletNames == ["Links", "Images", "News"]

    }

    def "move the images portlet"() {
        when:
        portlet("Images").moveToStartOf column(1)

        then:
        column(0).portletNames == ["Shopping", "Feeds"]
        column(1).portletNames == ["Images"]
        column(2).portletNames == ["Links", "News"]
    }

    def cleanup() {
        sleep 1000
    }
}
