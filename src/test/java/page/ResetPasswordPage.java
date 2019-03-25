package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage {
    private WebDriver driver;

    @FindBy (xpath = "//input[@id='username']")
    private WebElement emailRestoreField;

    @FindBy (xpath = "//button[@id='reset-password-submit-button']")
    private WebElement findAccountButton;

    @FindBy (xpath = "//input[@name='newPassword']")
    private WebElement newPasswordField;

    @FindBy (xpath = "//input[@name='confirmPassword']")
    private WebElement retypeNewPasswordField;

    @FindBy (xpath = "//button[@id='reset-password-submit-button']")
    private WebElement submit;

    @FindBy (xpath = "//button[@id='reset-password-submit-button']")
    private WebElement goToHomeButton;

    //String userEmail = "johndoeseleniumtest@gmail.com";
    String newPassword = "qwerty#3qwerty#3";

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage resetPassword (String userEmail) throws InterruptedException {
        emailRestoreField.sendKeys(userEmail);
        findAccountButton.click();
        Thread.sleep(180000);
        newPasswordField.sendKeys(newPassword);
        retypeNewPasswordField.sendKeys(newPassword);
        submit.click();
        Thread.sleep(3000);
        goToHomeButton.click();

        return new HomePage(driver);

    }

    public boolean isPageLoaded() {
        return findAccountButton.isDisplayed()
                && driver.getCurrentUrl().contains("request-password-reset")
                && driver.getTitle().equals("Reset Password | LinkedIn");
    }
}
