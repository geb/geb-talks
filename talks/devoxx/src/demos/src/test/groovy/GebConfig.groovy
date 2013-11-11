import geb.driver.SauceLabsDriverFactory
import geb.report.ReportState
import geb.report.Reporter
import geb.report.ReportingListener
import org.openqa.selenium.chrome.ChromeDriver

baseUrl = "http://localhost:5050"
reportsDir = "geb-reports"

// Enable integration with: https://wiki.jenkins-ci.org/display/JENKINS/JUnit+Attachments+Plugin
reportingListener = new ReportingListener() {
    void onReport(Reporter reporter, ReportState reportState, List<File> reportFiles) {
        reportFiles.each {
            // println "[[ATTACHMENT|$it.absolutePath]]"
        }
    }
}




def sauceBrowser = System.getProperty("geb.sauce.browser")
if (sauceBrowser) {
    def username = System.getenv("GEB_SAUCE_LABS_USER")
    assert username
    def accessKey = System.getenv("GEB_SAUCE_LABS_ACCESS_PASSWORD")
    assert accessKey

    reportsDir = "cross-browser/${[sauceBrowser username, accessKey].join("_")}"

    driver = {
        new SauceLabsDriverFactory().create(sauceBrowser, username, accessKey)
    }
} else {
    driver = {
        new ChromeDriver()
    }
}