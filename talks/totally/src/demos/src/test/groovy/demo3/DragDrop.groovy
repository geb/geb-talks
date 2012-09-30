package demo3

import geb.spock.GebReportingSpec
import spock.lang.Stepwise
import content.dragdrop.DragDropPage

@Stepwise
class DragDrop extends GebReportingSpec {

    def "images are there"() {
        when:
        to DragDropPage

        then:
        at DragDropPage
        
        and:
        numberOfCandidateImagesIs 5
        
        and:
        numberOfSelectedImagesIs 0
    }

    def "drag the playtime image"() {
        when:
        dragImageToDropZone "playtime"

        then:
        imageIsSelected "playtime"

        and:
        imageIsNotCandidate "playtime"

        and:
        numberOfCandidateImagesIs 4
    }

    def "clicking on the image puts in back in the list"() {
        when:
        unselectImage "playtime"

        then:
        numberOfSelectedImagesIs 0

        and:
        numberOfCandidateImagesIs 5
    }
    
    def cleanup() {
        sleep 1000
    }
}
