package content.drag

import geb.Module

import static java.lang.Math.*

class DraggableSquare extends Module {

    void drag(int xOffset, int yOffset) {
        def endX = x + xOffset
        def endY = y + yOffset

        def chunks = 6

        def xChunkSize = abs(ceil(xOffset / chunks).toInteger())
        def yChunkSize = abs(ceil(yOffset / chunks).toInteger())

        (chunks + 1).times { i ->
            def distanceToX = max(x, endX) - min(x, endX)
            def distanceToY = max(y, endY) - min(y, endY)

            def moveX = x == endX ? 0 : min(distanceToX, xChunkSize)
            def moveY = y == endY ? 0 : min(distanceToY, yChunkSize)

            if (xOffset < 0) {
                moveX = 0 - moveX
            }

            if (yOffset < 0) {
                moveY = 0 - moveY
            }

            browser.interact {
                dragAndDropBy $(), moveX, moveY
            }
        }

        assert x == endX
        assert y == endY
    }

    void dragTo(int toX, int toY) {
        drag(toX - x, toY - y)
    }
}
