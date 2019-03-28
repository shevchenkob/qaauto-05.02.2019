package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import util.GMailService;

public class ResetPasswordPage extends BasePage{


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

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage resetPassword (String userEmail, String newPassword) throws InterruptedException {
        emailRestoreField.sendKeys(userEmail);

        String messageSubject = "here's the link to reset your password";
        String messageTo = userEmail;
        String messageFrom = "security-noreply@linkedin.com";

        GMailService gMailService = new GMailService();
        gMailService.connect();
        findAccountButton.click();

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 120);
        System.out.println("Content: " + message);

        resetPasswordUrl = StringUtils
                .substringBetween(message, "line-height:1.25;\"><a href=\"", "\" style=\"cursor:pointer;color:#008CC9;-webkit-text-size-adjust:100%;display:inline-block;text-decoration:none;-ms-text-size-adjust:100%;\">Reset my password")
                .replace("amp", "");
        System.out.println(resetPasswordUrl);
        driver.get(resetPasswordUrl);

        Thread.sleep(10000);
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
