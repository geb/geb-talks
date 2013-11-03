import org.ratpackframework.groovy.templating.TemplateRenderer

import static org.ratpackframework.groovy.RatpackScript.ratpack

ratpack {
    handlers {
        assets "public"
        get("login") {
            def renderer = get(TemplateRenderer)
            def params = request.queryParams
            if (params.username) {
                def model = [:]
                model.username = params.username
                model.password = params.password
                model.remember = params.rememberme as boolean
                model.success = (model.username == "user" && model.password == "password")

                renderer.render(model, "login-result.html")
            } else {
                renderer.render("login.html")
            }
        }

    }
}