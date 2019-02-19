import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmit {
    WebDriver driver;

    WebElement passwordError;
    WebElement myEmailError;
    WebElement emailError;

    public LoginSubmit (WebDriver driver) {
        this.driver = driver;
        initElements();
    }
    public void initElements () {
        passwordError = driver.findElement(By.xpath("//div[@id='error-for-password']"));
        myEmailError = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        emailError = driver.findElement(By.xpath("//div[@id='error-for-username']"));
    }
    public String myEmailPasswordText () {
        return passwordError.getText();
    }
    public String myEmailErrorText () {
        return myEmailError.getText();
    }
    public String emailErrorText () {
        return emailError.getText();
    }

}
