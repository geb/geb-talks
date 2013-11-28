import static ratpack.groovy.Groovy.*

ratpack {
    handlers {
        get("login") {
            def params = request.queryParams
            if (params.username) {
                def model = [:]
                model.username = params.username
                model.password = params.password
                model.remember = params.rememberme as boolean
                model.success = (model.username == "devoxx" && model.password == "devoxx")

                render groovyTemplate(model, "login-result.html")
            } else {
                render groovyTemplate("login.html")
            }
        }

        fileSystem("public") {
            assets "", "index.html"
            handler {
                def toServe = file(request.path + ".html")
                if (toServe.exists()) {
                    render toServe
                } else {
                    next()
                }
            }
        }
    }
}