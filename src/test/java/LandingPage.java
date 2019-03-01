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


    public Object login(String userEmail, String userPassword) {
        emailField.sendKeys(userEmail);
        passwordField.sendKeys(userPassword);
        signIn.click();
        String url = driver.getCurrentUrl();
        if (url.contains("/feed")) {
        return new HomePage(driver);}
        else { return new LoginSubmit(driver); }
    }

    public boolean isPageLoaded() {
        return signIn.isDisplayed()
                && driver.getCurrentUrl().equals("https://www.linkedin.com/")
                && driver.getTitle().equals("LinkedIn: Log In or Sign Up");
    }
}
