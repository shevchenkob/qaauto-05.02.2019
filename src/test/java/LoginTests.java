import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTests {
    @Test
    public void successfullLoginTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shevchenko_b\\IdeaProjects\\qaauto-05.02.2019\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentLogging", "true");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

//Here I write all elements that will be used
        String useremail = "qwerty@gmail.com";
        String userpassword = "mypassword";
        WebElement SignIn = driver.findElement(By.id("login-submit"));

//Here I write all methods
        WebElement emailfield = driver.findElement(By.id("login-email"));
        WebElement passwordfield = driver.findElement(By.id("login-password"));
        emailfield.sendKeys(useremail);
        passwordfield.sendKeys(userpassword);
        SignIn.click();

    }
}
