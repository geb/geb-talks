package _02_spock

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import spock.lang.Specification
import spock.lang.Unroll

class WebdriverSpock extends Specification {

    WebDriver driver = new ChromeDriver()

    def cleanup() {
        driver.quit()
    }

    @Unroll
    "#type login produces #msg message"() {
        when:
        driver.get("http://localhost:5050/login")

        then:
        driver.findElement(By.tagName("h1")).text == "Please sign in"

        when:
        driver.findElement(By.name("username")).sendKeys(username)
        driver.findElement(By.name("password")).sendKeys(password)
        driver.findElement(By.tagName("button")).click()

        then:
        driver.findElement(By.tagName("h1")).text == msg

        where:
        type      | username | password | msg
        "success" | "devoxx" | "devoxx" | "Login Successful"
        "failed"  | "wrong"  | "wrong"  | "Login Failed"
    }

}
