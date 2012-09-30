package content.dragdrop

import geb.Module

class SelectedImage extends Module {

    static content = {
        text(cache: true) { $().text() }
        name(cache: true) { text.split(".jpg")[0] }
    }

}
