import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.remote.DesiredCapabilities

driver = "firefox" // firefox is default

reportsDir = new File("build/geb-reports")

waiting {
    timeout = 5
}

environments {

    htmlunit = {
        def driver = new HtmlUnitDriver()
        driver.javascriptEnabled = true
        driver
    }

    chrome {
        driver = "chrome"
    }
    
    firefox {
        driver = { new FirefoxDriver() }
    }

    ie {
        // See http://code.google.com/p/selenium/wiki/RemoteWebDriverServer
        // You need to have the selenium-server running on a machine with IE installed
        driver = {
            def server = new URL("http://«ip address of your webdriver server here»:4444/wd/hub")
            def browserProfile = DesiredCapabilities.internetExplorer()
            new RemoteWebDriver(server, browserProfile)
        }
    }

}
