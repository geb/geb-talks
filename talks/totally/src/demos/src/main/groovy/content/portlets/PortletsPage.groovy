package content.portlets

import geb.Page

class PortletsPage extends Page {
    static url = "http://jqueryui.com/demos/sortable/portlets.html"
    static at = { title == "jQuery UI Sortable - Portlets" }
    static content = {
        column { module Column, $("div.column", it) }
        portlet { module Portlet, $("div.portlet-header", text: it).parent() }
    }
}
