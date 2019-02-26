import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    private WebDriver driver;

    @FindBy(id = "login-email")
    private WebElement emailField;

    @FindBy(id = "login-password")
    private WebElement passwordField;

    @FindBy(id = "login-submit")
    private WebElement signIn;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }




    public HomePage login(String userEmail, String userPassword) {
        emailField.sendKeys(userEmail);
        passwordField.sendKeys(userPassword);
        signIn.click();
        return new HomePage(driver);
    }
    public LoginSubmit loginToSubmit(String userEmail, String userPassword) {
        emailField.sendKeys(userEmail);
        passwordField.sendKeys(userPassword);
        signIn.click();
        return new LoginSubmit(driver);
    }

    public boolean isPageLoaded() {
        return signIn.isDisplayed()
                && driver.getCurrentUrl().equals("https://www.linkedin.com/")
                && driver.getTitle().equals("LinkedIn: Log In or Sign Up");
    }
}
