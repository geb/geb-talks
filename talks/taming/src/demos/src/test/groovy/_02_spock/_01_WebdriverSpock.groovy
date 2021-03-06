package _02_spock

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise
import spock.lang.Unroll

@Stepwise
class _01_WebdriverSpock extends Specification {
    @Shared
    @AutoCleanup("quit")
    WebDriver driver = new ChromeDriver()

    def "can login successfully"() {
        when:
        driver.get("http://localhost:5050/login")

        then:
        driver.findElement(By.tagName("h1")).text == "Please sign in"

        when:
        driver.findElement(By.name("username")).sendKeys("rwx")
        driver.findElement(By.name("password")).sendKeys("rwx")
        driver.findElement(By.tagName("button")).click()

        then:
        driver.findElement(By.tagName("h1")).text == "Login Successful"
    }

    def "navigate to secret page"() {
        when:
        driver.findElement(By.cssSelector("a.btn")).click()

        then:
        driver.findElement(By.tagName("h1")).text == "Secret Page!"
    }
}
