import geb.report.ReportState
import geb.report.Reporter
import geb.report.ReportingListener
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

baseUrl = "http://localhost:5050"
reportsDir = "geb-reports"

driver = {
    new ChromeDriver()
}

// Enable integration with: https://wiki.jenkins-ci.org/display/JENKINS/JUnit+Attachments+Plugin
reportingListener = new ReportingListener() {
    void onReport(Reporter reporter, ReportState reportState, List<File> reportFiles) {
        reportFiles.each {
            println "[[ATTACHMENT|$it.absolutePath]]"
        }
    }
}

environments {
    ie {
        baseUrl = "http://10.98.253.167:5050"

        // See http://code.google.com/p/selenium/wiki/RemoteWebDriverServer
        // You need to have the selenium-server running on a machine with IE installed
        driver = {
            def server = new URL("http://172.16.229.144:4444/wd/hub")
            def browserProfile = DesiredCapabilities.internetExplorer()
            new RemoteWebDriver(server, browserProfile)
        }
    }
    firefox {
        driver = { new FirefoxDriver() }
    }
}