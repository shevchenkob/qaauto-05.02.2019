import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest {

    @Test
    public void SearchTest() throws InterruptedException {
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        HomePage homePage = landingPage.login("johndoeseleniumtest@gmail.com", "johndoepassword");
        Thread.sleep(5000);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");
    }
}
