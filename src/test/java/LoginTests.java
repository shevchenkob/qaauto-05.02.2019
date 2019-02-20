import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shevchenko_b\\IdeaProjects\\qaauto-05.02.2019\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test(priority = 1)
    public void successfulLoginTest() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.login("johndoeseleniumtest@gmail.com", "johndoepassword");

        Thread.sleep(5000);

        HomePage homePage = new HomePage(driver);

        homePage.homeButton();
        Assert.assertTrue(homePage.homeButton(), "home is not displayed on Home page.");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Home page URL is incorrect");

    }

    @Test(priority = 2)
    public void negativeLoginTestIncorrectPassword() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.login("johndoeseleniumtest@gmail.com", "fake");

        Thread.sleep(5000);

        LoginSubmit loginSubmit = new LoginSubmit(driver);
        Assert.assertEquals(loginSubmit.passwordErrorText(), "Hmm, that's not the right password. Please try again or request a new one.", "incorrect password warning is not displayed on page.");

    }

    @Test(priority = 3)
    public void negativeLoginTestIncorrectEmail() throws InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.login("johndoeseleniumtest@fake.com", "johndoepassword");

        Thread.sleep(5000);

        LoginSubmit loginSubmit = new LoginSubmit(driver);

        Assert.assertEquals(loginSubmit.emailErrorText(), "Hmm, we don't recognize that email. Please try again.", "incorrect email warning is not displayed on page.");

    }

    @Test(priority = 4)
    public void negativeLoginTestNotValidEmail() throws InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.login("fake", "johndoepassword");


        Thread.sleep(5000);

        LoginSubmit loginSubmit = new LoginSubmit(driver);

        Assert.assertEquals(loginSubmit.emailErrorText(), "Please enter a valid email address.", "Please enter a valid email address. warning is not displayed on page.");
    }

}
