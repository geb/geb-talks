package _06_interaction

import content.drag.DragPage
import content.drag.DraggableSquare
import geb.spock.GebSpec
import spock.lang.Stepwise

import static util.Pause.pause

@Stepwise
class _01_DragDrop extends GebSpec {

    def "can drag squares"() {
        given:
        to DragPage

        DraggableSquare greenSquare = page.square(0)
        DraggableSquare blueSquare = page.square(1)

        when:
        blueSquare.drag(200, 200)

        def blueTopLeft = [blueSquare.x, blueSquare.y]
        def blueBottomLeft = [blueSquare.x, blueSquare.y + blueSquare.height]
        def blueBottomRight = [blueSquare.x + blueSquare.width, blueSquare.y + blueSquare.height]
        def blueTopRight = [blueSquare.x + blueSquare.width, blueSquare.y]

        6.times {
            // top left
            greenSquare.dragTo(blueTopLeft[0] - greenSquare.width, blueTopLeft[1] - greenSquare.height)

            // bottom left
            greenSquare.dragTo(blueBottomLeft[0] - greenSquare.width, blueBottomLeft[1])

            // bottom right
            greenSquare.dragTo(blueBottomRight[0], blueBottomRight[1])

            // top right
            greenSquare.dragTo(blueTopRight[0], blueTopRight[1] - greenSquare.height)
        }

        then:
        true
    }

}
