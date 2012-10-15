package pages.scaffold

abstract class ScaffoldListPage extends ScaffoldPage {

    final action = "List"

    abstract getCreatePage()

    static content = {
        newItem(to: container.createPage) { navItem("create") }
        recordLink { $("div.scaffold-list tbody tr a", it) }
        records(required: false) { $("div.scaffold-list tbody tr") }
    }
}