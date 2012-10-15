// baseUrl = "http://localhost:8080/03-development-cycle"
// reportsDir = "target/test-reports/geb"

import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

def remoteUrl = {
    new URL("http://" + System.getProperty("remote") + ":4444/wd/hub")
}

environments {
    'win-ie' {
        driver = { new RemoteWebDriver(remoteUrl(), DesiredCapabilities.internetExplorer()) }
    }

    'win-chrome' {
        driver = { new RemoteWebDriver(remoteUrl(), DesiredCapabilities.chrome()) }
    }
}