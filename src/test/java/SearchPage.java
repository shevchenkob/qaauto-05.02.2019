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

    @FindBy (xpath = "//div[@class='search-result__wrapper']")
    private List<WebElement> searchBlock;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean isPageLoaded() {
        return  resultsTotal.isDisplayed()
                && driver.getCurrentUrl().contains("/search/results/")
                && driver.getTitle().contains(" | Search ");
    }


    public List<String> getSearchResultsList() {
        List<String> searchListResultTexts = new ArrayList<String>();
        for (WebElement  searchBlockText: searchBlock){
             searchListResultTexts.add(searchBlockText.getText());
        }
        return searchListResultTexts;
    }

    public int getSearchResultCount () {
        return searchBlock.size();
    }


}
