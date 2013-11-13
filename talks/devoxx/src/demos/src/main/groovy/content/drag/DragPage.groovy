package content.drag

import geb.Page

class DragPage extends Page {

    static url = "/drag"

    static content = {
        square { i -> module(DraggableSquare, $("div.draggable", i)) }
    }
}
