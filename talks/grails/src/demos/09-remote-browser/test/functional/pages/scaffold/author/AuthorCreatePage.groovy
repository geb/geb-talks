package pages.scaffold.author

import app.*
import pages.scaffold.ScaffoldCreatePage

class AuthorCreatePage extends ScaffoldCreatePage {
    final domainClass = Author
    final showPage = AuthorShowPage
}