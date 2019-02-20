import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmit {
    WebDriver driver;

    WebElement passwordError;
    WebElement emailError;


    public LoginSubmit (WebDriver driver) {
        this.driver = driver;
        initElements();
    }
    public void initElements () {
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
