import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;
import java.util.regex.Pattern;


public class BadCodeExample {
    public static void main(String[] args) {
        System.out.println("Hello World!!!");

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shevchenko_b\\IdeaProjects\\qaauto-05.02.2019\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentLogging", "true");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        String searchTerm = "Selenium";
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        List<WebElement> searchResultElements = driver.findElements(By.xpath("//div[@class='g']"));
        System.out.println("Results count: " + searchResultElements.size());

//        List<WebElement> listElement = driver.findElements(By.xpath("//div[@class='g']"));
//        for(int i =0;i<listElement.size();i++) {
//            String elementText = listElement.get(i).getText();
//            if
//            //(driver.findElement(By.xpath("//div[@class='g']")).getText()
//            (elementText.toLowerCase().contains("википедия".toLowerCase()))
//            {
//                System.out.println("searchTerm found");
//            }
//
//            else
//            {
//                System.out.println("searchTerm not found");
//            }
//            System.out.println(elementText);
//        }
//        driver.close();
        for (WebElement searchResultElement : searchResultElements) {
            String searchResultElementText = searchResultElement.getText();
            System.out.println(searchResultElementText);
            if (searchResultElementText.toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("serchTerm found");
            } else {
                System.out.println("serchTerm not found");
            }
        }
    }
}






