import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmit {
    private WebDriver driver;
    private WebElement loginForm;
    private WebElement passwordError;
    private WebElement emailError;

    public boolean isPageLoaded() {
        return loginForm.isDisplayed()
                && driver.getCurrentUrl().contains("/login-submit")
                && driver.getTitle().contains("Sign In to LinkedIn");
    }


    public LoginSubmit (WebDriver driver) {
        this.driver = driver;
        initElements();
    }
    private void initElements () {
        loginForm = driver.findElement(By.xpath("//form[@class='login__form']"));
        passwordError = driver.findElement(By.xpath("//div[@id='error-for-password']"));
        emailError = driver.findElement(By.xpath("//div[@id='error-for-username']"));
    }
    public String passwordErrorText () {
        return passwordError.getText();
    }
    public String emailErrorText () {
        return emailError.getText();
    }

}
