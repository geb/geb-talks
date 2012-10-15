package pages.scaffold.author

import app.*
import pages.scaffold.ScaffoldShowPage

class AuthorShowPage extends ScaffoldShowPage {
    final domainClass = Author
    static content = {
        name { fieldValue("name") }
    }
}