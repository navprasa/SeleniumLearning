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

import java.util.List;
import java.util.stream.Collectors;


public class J5 {

    private static WebDriver driver;

    @BeforeAll
    public  static void loaddriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkS(){

        driver.get("https://www.github.com");

        String searchPhrase = "selenium";
        WebElement Search = driver.findElement(By.cssSelector("[name='q']"));
        Search.sendKeys(searchPhrase);
        Search.sendKeys(Keys.ENTER);


        List<String> actualItems = driver.findElements(By.xpath("//ul[@class='repo-list']")).stream()
                .map(element->element.getText().toLowerCase())
                .collect(Collectors.toList());

        //Assert.assertTrue(actualItems.stream().allMatch(items->items.matches(searchPhrase)));

        List<String> expectedItems = actualItems.stream()
                .filter(item->item.contains("asdfkja"))
                .collect(Collectors.toList());
        System.out.println(expectedItems);
        Assertions.assertEquals(expectedItems,actualItems);

    }

    @AfterAll
    public static void teardown(){
        driver.close();
    }
}
