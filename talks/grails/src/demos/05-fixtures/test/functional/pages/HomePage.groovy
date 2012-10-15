package pages

import pages.scaffold.author.AuthorListPage
import pages.scaffold.book.BookListPage

class HomePage extends BasePage {

    static at = { heading == "Welcome to Grails" }

    static content = {
        controllerList { $("div#controller-list ul") }
        controllers { controllerList.find("li.controller a") }
        controller { name -> controllers.find { it.text().startsWith(name) } }

        authors(to: AuthorListPage) { controller("app.Author") }
        books(to: BookListPage) { controller("app.Book") }
    }

}