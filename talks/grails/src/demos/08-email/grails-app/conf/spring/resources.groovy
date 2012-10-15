import grails.util.Environment

beans = {
    if (Environment.current == Environment.TEST) {
        dbCleaner(test.DbCleaner) { it.autowire = true }
        baseFixtureBuilder(test.BaseFixtureBuilder) { it.autowire = true }
    }
}
