package content.portlets

import geb.Module

class Portlet extends Module {
    static content = {
        name { $("div.portlet-header").text() }
    }

    void moveAfter(Portlet portlet) {
        def xOffset = portlet.x + 5 - this.x
        def yOffset = portlet.y + portlet.height + 50 - this.y

        move(xOffset, yOffset)
    }

    void moveBefore(Portlet portlet) {
        def xOffset = portlet.x - this.x
        def yOffset = portlet.y - 5 - this.y

        move(xOffset, yOffset)
    }

    void moveToStartOf(Column column) {
        def xOffset = column.x - this.x
        def yOffset = column.y - this.y

        move(xOffset, yOffset)
    }

    void move(int xOffset, int yOffset) {
        browser.interact {
            dragAndDropBy this, xOffset, yOffset
        }
    }

}
