package test;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.ResetPasswordPage;

public class SuccessfulPasswordResetTest extends BaseTest {

    @Test
    public void SuccessfulPasswordResetTest () throws InterruptedException {

        String userEmail = "johndoeseleniumtest@gmail.com";

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        ResetPasswordPage resetPasswordPage = landingPage.resetPassword();

        Assert.assertTrue(resetPasswordPage.isPageLoaded(), "Reset password page is not loaded.");
        Thread.sleep(5000);
        HomePage homePage = resetPasswordPage.resetPassword(userEmail);

        Thread.sleep(5000);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");



    }
}