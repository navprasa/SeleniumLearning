import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.SearchResultsPage;

import java.util.List;
import java.util.stream.Collectors;


public class J5 {

    private static WebDriver driver;
    private static final String searchText = "selenium";
    @BeforeAll
    public  static void loaddriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkS(){

        driver.get("https://www.github.com");

        HomePage homepage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        homepage.performsearch(searchText);

        List<String> actualItems = searchResultsPage.searchResultsItemsText();
        List<String> expectedItems = searchResultsPage.searchResultsItemsWithText(searchText);

        Assertions.assertEquals(expectedItems,actualItems);

    }

    @AfterAll
    public static void teardown(){
        driver.close();
    }
}
