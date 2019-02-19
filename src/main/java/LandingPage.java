import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    WebDriver driver;

    WebElement emailField;
    WebElement passwordField;
    WebElement signIn;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        initElements ();
    }

    public void initElements() {
        emailField = driver.findElement(By.id("login-email"));
        passwordField = driver.findElement(By.id("login-password"));
        signIn = driver.findElement(By.id("login-submit"));
    }


    public void login(String userEmail, String userPassword) {
        emailField.sendKeys(userEmail);
        passwordField.sendKeys(userPassword);
        signIn.click();
    }


}
