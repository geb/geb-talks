package content.drag

import geb.Page

class DragPage extends Page {

    static url = "/drag.html"

    static content = {
        square { i -> module(DraggableSquare, $("div.draggable", i)) }

        // squareDiv { color -> $("div").find { it.firstElement().getCssValue("background-color") == color } }
    }
}
