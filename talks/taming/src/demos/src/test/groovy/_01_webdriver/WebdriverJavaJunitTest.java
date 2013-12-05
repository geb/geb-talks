package _01_webdriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class WebdriverJavaJunitTest {
    private static WebDriver driver;

    @BeforeClass
    public static void before() {
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void after() {
        driver.quit();
    }

    @Test
    public void canLoginSuccessFully() {
        driver.get("http://localhost:5050/login");
        assertEquals(driver.findElement(By.tagName("h1")).getText(), "Please sign in");
        driver.findElement(By.name("username")).sendKeys("rwx");
        driver.findElement(By.name("password")).sendKeys("rwx");
        driver.findElement(By.tagName("button")).click();
        assertEquals(driver.findElement(By.tagName("h1")).getText(), "Login Successful");
    }
}
