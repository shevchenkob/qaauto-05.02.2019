import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    private WebDriver driver;

    private WebElement emailField;
    private WebElement passwordField;
    private WebElement signIn;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        initElements ();
    }

    private void initElements() {
        emailField = driver.findElement(By.id("login-email"));
        passwordField = driver.findElement(By.id("login-password"));
        signIn = driver.findElement(By.id("login-submit"));
    }


    public void login(String userEmail, String userPassword) {
        emailField.sendKeys(userEmail);
        passwordField.sendKeys(userPassword);
        signIn.click();
    }


    public boolean isPageLoaded() {
        return signIn.isDisplayed()
                && driver.getCurrentUrl().equals("https://www.linkedin.com/")
                && driver.getTitle().equals("LinkedIn: Log In or Sign Up");
    }
}
