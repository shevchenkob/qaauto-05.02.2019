import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests {
    @Test
    public void successfullLoginTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shevchenko_b\\IdeaProjects\\qaauto-05.02.2019\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentLogging", "true");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

//Here I write all elements that will be used
        String useremail = "johndoeseleniumtest@gmail.com";
        String userpassword = "johndoepassword";
        WebElement SignIn = driver.findElement(By.id("login-submit"));


//Here I write all methods
        WebElement emailfield = driver.findElement(By.id("login-email"));
        WebElement passwordfield = driver.findElement(By.id("login-password"));
        emailfield.sendKeys(useremail);
        passwordfield.sendKeys(userpassword);
        SignIn.click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        WebElement home = driver.findElement(By.id("feed-tab-icon"));
        home.click();


    }
}
