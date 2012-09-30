package content.portlets

import geb.Module

class Column extends Module {
    static content = {
        portlets { moduleList Portlet, $("div.portlet") }
        portletNames { portlets*.name }
    }
}
