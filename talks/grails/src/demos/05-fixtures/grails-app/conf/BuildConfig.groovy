grails.servlet.version = "2.5"
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6

grails.project.dependency.resolution = {
    inherits("global")
    log "error"
    checksums true
    repositories {
        inherits true
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenLocal()
        mavenCentral()
    }
    dependencies {
        test "org.codehaus.geb:geb-spock:0.7.2"
        test "org.seleniumhq.selenium:selenium-chrome-driver:2.25.0"
        test "org.seleniumhq.selenium:selenium-support:2.25.0"
    }
    plugins {
        runtime ":hibernate:$grailsVersion"
        build ":tomcat:$grailsVersion"
        
        test ":geb:0.7.2"
        test ":spock:0.6"
        build ":functional-test-development:0.9.3"
        test ":remote-control:1.3"
        test ":fixtures:1.1"
        // test ":build-test-data:1.1.1"
    }
}
