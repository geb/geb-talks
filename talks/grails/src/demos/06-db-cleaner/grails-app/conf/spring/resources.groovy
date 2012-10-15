import grails.util.Environment

beans = {
    if (Environment.current == Environment.TEST) {
        dbCleaner(test.DbCleaner) { it.autowire = true }
    }
}
