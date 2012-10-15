package pages.scaffold.book

import app.*
import pages.scaffold.ScaffoldShowPage

class BookShowPage extends ScaffoldShowPage {
    final domainClass = Book
    static content = {
        bookTitle { fieldValue("title") }
        author { fieldValue("author") }
    }
}