package pages.scaffold.book

import app.*
import pages.scaffold.ScaffoldListPage

class BookListPage extends ScaffoldListPage {
    final domainClass = Book
    final createPage = BookCreatePage
}