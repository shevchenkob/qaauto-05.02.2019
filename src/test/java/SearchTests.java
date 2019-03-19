import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests extends BaseTest {

    @Test
    public void SearchTest() throws InterruptedException {
        String searchTerm = "HR";

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");
        HomePage homePage = landingPage.login("johndoeseleniumtest@gmail.com", "johndoepassword");
        Thread.sleep(5000);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");

        SearchPage searchPage = homePage.search(searchTerm);
        Assert.assertTrue(searchPage.isPageLoaded(), "Search page is not loaded.");

        Assert.assertEquals(searchPage.getSearchResultCount(), 10, "Search results count is wrong.");

        List<String> searchResultsList = searchPage.getSearchResultsList();

        for (String searchResult : searchResultsList) {
            Assert.assertTrue(searchResult.contains(searchTerm), "pls write this message(searchTerm not found in searchResultsList)");
        }


        }


    }

