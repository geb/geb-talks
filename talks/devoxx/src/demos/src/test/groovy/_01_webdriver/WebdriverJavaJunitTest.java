package _01_webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class WebdriverJavaJunitTest {

    private WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void canSuccessfullyLogInToSite() {
        driver.get("http://localhost:5050/login");
        assertEquals(driver.findElement(By.tagName("h1")).getText(), "Please sign in");
        driver.findElement(By.name("username")).sendKeys("devoxx");
        driver.findElement(By.name("password")).sendKeys("devoxx");
        driver.findElement(By.tagName("button")).click();
        assertEquals(driver.findElement(By.tagName("h1")).getText(), "Login Successful");
    }

    @Test
    public void canUnSuccessfullyLogInToSite() {
        driver.get("http://localhost:5050/login");
        assertEquals(driver.findElement(By.tagName("h1")).getText(), "Please sign in");
        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("password")).sendKeys("wrong");
        driver.findElement(By.tagName("button")).click();
        assertEquals(driver.findElement(By.tagName("h1")).getText(), "Login Failed");
    }

}
