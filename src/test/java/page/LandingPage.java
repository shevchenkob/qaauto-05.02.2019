package page;

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


//    public Object login2(String userEmail, String userPassword) {
//        emailField.sendKeys(userEmail);
//        passwordField.sendKeys(userPassword);
//        signIn.click();
//        String url = driver.getCurrentUrl();
//        if (url.contains("/feed")) {
//        return new page.HomePage(driver);}
//        else { return new page.LoginSubmit(driver); }
//    }

    public <GenericPage> GenericPage login (String userEmail, String userPassword) {
        emailField.sendKeys(userEmail);
        passwordField.sendKeys(userPassword);
        signIn.click();
        if (driver.getCurrentUrl().contains("/feed")) {
            return (GenericPage) new HomePage(driver);
        }
       else {
            return (GenericPage) new LoginSubmit(driver);
        }
        }

        public <T> T login(String userEmail, String userPassword, Class<T> expectedPage) {
            emailField.sendKeys(userEmail);
            passwordField.sendKeys(userPassword);
            signIn.click();
            return PageFactory.initElements(driver, expectedPage);
        }


    public boolean isPageLoaded() {
        return signIn.isDisplayed()
                && driver.getCurrentUrl().equals("https://www.linkedin.com/")
                && driver.getTitle().equals("LinkedIn: Log In or Sign Up");
    }
}
