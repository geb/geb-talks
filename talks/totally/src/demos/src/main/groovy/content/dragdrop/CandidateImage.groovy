package content.dragdrop

import geb.Module

class CandidateImage extends Module {

    static content = {
        name { $("span").text() }
        img { $("img") }
    }
}
