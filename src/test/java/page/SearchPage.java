package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    private WebDriver driver;

    @FindBy (xpath = "//h3[contains(@class, 'search-results__total')]")
    private WebElement resultsTotal;

    @FindBy (xpath = "//li[contains(@class, 'search-result search-result__occluded-item')]")
    private List<WebElement> searchBlocks;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean isPageLoaded() {
        return  resultsTotal.isDisplayed()
                && driver.getCurrentUrl().contains("/search/results/")
                && driver.getTitle().contains(" | Search ");
    }


//    public List<String> getSearchResultsList() {
//        List<String> searchListResultTexts = new ArrayList<String>();
//        for (WebElement  searchBlock: searchBlocks){
//             searchListResultTexts.add(searchBlock.getText());
//        }
//        return searchListResultTexts;
//    }

    public List<String> getSearchResultsList() {
        List<String> searchResultList = new ArrayList<String>();
        for (WebElement searchBlock: searchBlocks) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", searchBlock);
            searchResultList.add(searchBlock.getText());
        }
        return searchResultList;
    }

    public int getSearchResultCount () {
        return searchBlocks.size();
    }

}
