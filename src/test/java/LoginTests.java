import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class LoginTests {

    WebDriver driver;
@BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shevchenko_b\\IdeaProjects\\qaauto-05.02.2019\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
    }
    @AfterMethod
    public void afterMethod() {
    driver.quit();
    }

    @Test
    public void successfullLoginTest() throws InterruptedException {


//elements that will be used
        String useremail = "johndoeseleniumtest@gmail.com";
        String userpassword = "johndoepassword";
        WebElement signIn = driver.findElement(By.id("login-submit"));



//methods
        WebElement emailfield = driver.findElement(By.id("login-email"));
        WebElement passwordfield = driver.findElement(By.id("login-password"));
        emailfield.sendKeys(useremail);
        passwordfield.sendKeys(userpassword);
        signIn.click();
        Thread.sleep(5000);

        WebElement home = driver.findElement(By.xpath("//li[@id='feed-nav-item']"));
        Assert.assertTrue(home.isDisplayed(),"home is not displayed on Home page.");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Home page URL is incorrect");



    }

    public void negativeLoginTest() {

    }
}
