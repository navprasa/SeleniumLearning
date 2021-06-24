import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class SeleniumRunner {

    public static void main(String args[]){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
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
                .filter(item->item.contains(searchPhrase))
                .collect(Collectors.toList());
        System.out.println(expectedItems);
        Assert.assertEquals(expectedItems,actualItems);

        driver.close();
    }
}
