package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginSubmit;

public class LoginTests extends BaseTest{

    @DataProvider
    public Object[][] ValidData() {
        return new Object[][]{
                {"johndoeseleniumtest@gmail.com", "johndoepassword"},
                //{"johndoeSeleniumTest@gmail.com", "johndoepassword"},
               // {" johndoeseleniumtest@gmail.com ", "johndoepassword"}
        };
    }

    @Test(dataProvider = "ValidData", priority = 1)
    public void successfulLoginTest(String userEmail, String userPassword) throws InterruptedException {
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        HomePage homePage = landingPage.login(userEmail, userPassword, HomePage.class);

        Thread.sleep(5000);

        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");
    }
//**Start error scenarious**
    @DataProvider
    public Object[][] inValidData() {
        return new Object[][]{
                {"johndoeseleniumtest@gmail.com", "fake", "Hmm, that's not the right password. Please try again or request a new one.", ""},
               // {"johndoeseleniumtest@fake.com", "johndoepassword", "", "Hmm, we don't recognize that email. Please try again."},
              //  {"fake", "johndoepassword", "", "Please enter a valid email address."}
        };
    }

    @Test(dataProvider = "inValidData", priority =2)
    public void negativeLoginTestIncorrectPassword(String userEmail, String userPassword, String passwordError, String emailError) throws InterruptedException {

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        LoginSubmit loginSubmit =  landingPage.login(userEmail, userPassword, LoginSubmit.class);

        Thread.sleep(5000);

        loginSubmit.passwordErrorText().equals(passwordError);
        loginSubmit.emailErrorText().equals(emailError);
        Assert.assertTrue(loginSubmit.isPageLoaded(), "Login submit page is not loaded");

        Assert.assertEquals(loginSubmit.passwordErrorText(), passwordError, "incorrect password warning is not displayed on page.");
        Assert.assertEquals(loginSubmit.emailErrorText(), emailError, "incorrect email warning is not displayed on page.");
    }

}
