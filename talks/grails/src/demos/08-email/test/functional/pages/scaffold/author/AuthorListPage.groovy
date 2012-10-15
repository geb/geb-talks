package pages.scaffold.author

import app.*
import pages.scaffold.ScaffoldListPage

class AuthorListPage extends ScaffoldListPage {
    final domainClass = Author
    final createPage = AuthorCreatePage
}