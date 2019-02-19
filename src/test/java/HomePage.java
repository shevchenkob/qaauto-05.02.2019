import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    WebElement home;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }
    public void initElements() {
        home = driver.findElement(By.xpath("//li[@id='feed-nav-item']"));
    }
public boolean homeButton() {
        return
                home.isDisplayed();
    }
}
