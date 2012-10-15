package pages.scaffold.book

import app.*
import pages.scaffold.ScaffoldCreatePage

class BookCreatePage extends ScaffoldCreatePage {
    final domainClass = Book
    final showPage = BookShowPage
}