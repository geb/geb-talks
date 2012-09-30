package content.dragdrop

import geb.Page

class DragDropPage extends Page {

    static url = "http://bculturemedia.com/zipdrop/"
    
    static at = { title == "ZipDrop | Drag, Drop, Zip, Download!" }
    
    static content = {
        dropZone { $("div#info") }

        candidateImages {
            moduleList(CandidateImage, $("div#thumbs div.thumb_container")).findAll { it.displayed }
        }

        candidateImage(wait: true, required: false) { name ->
            candidateImages.find { it.name.toLowerCase() == name.toLowerCase() }
        }

        selectedImages { moduleList SelectedImage, $("ul#file_ul li") }

        selectedImage(wait: true, required: false) { name ->
            selectedImages.find { it.name.toLowerCase() == name }
        }
    }

    boolean numberOfCandidateImagesIs(int num) {
        waitFor { candidateImages.size() == num }
    }

    boolean numberOfSelectedImagesIs(int num) {
        waitFor { selectedImages.size() == num }
    }

    boolean dragImageToDropZone(name) {
        interact {
            dragAndDrop candidateImage("Playtime").img, dropZone
        }
    }

    boolean imageIsSelected(name) {
        selectedImage(name) != null
    }

    boolean imageIsNotCandidate(name) {
        waitFor { !candidateImages*.name.contains(name) }
    }

    void unselectImage(name) {
        selectedImage(name).click()
    }
}
