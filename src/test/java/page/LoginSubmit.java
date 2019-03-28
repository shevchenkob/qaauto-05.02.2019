package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSubmit extends BasePage{


    @FindBy (xpath = "//form[@class='login__form']")
    private WebElement loginForm;

    @FindBy (xpath = "//div[@id='error-for-password']")
    private WebElement passwordError;

    @FindBy (xpath = "//div[@id='error-for-username']")
    private WebElement emailError;

    public boolean isPageLoaded() {
        return loginForm.isDisplayed()
                && driver.getCurrentUrl().contains("/login-submit")
                && driver.getTitle().contains("Sign In to LinkedIn");
    }

    public LoginSubmit (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String passwordErrorText () {
        return passwordError.getText();
    }
    public String emailErrorText () {
        return emailError.getText();
    }

}
