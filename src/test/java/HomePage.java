import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    private WebElement home;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }
    private void initElements() {
        home = driver.findElement(By.xpath("//li[@id='feed-nav-item']"));
    }

    public boolean isPageLoaded() {
        return home.isDisplayed()
                && driver.getCurrentUrl().contains("/feed/")
                && driver.getTitle().contains("LinkedIn");
    }
}
