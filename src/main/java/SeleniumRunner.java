import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumRunner {

    public static void main(String args[]){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.github.com");

        WebElement Search = driver.findElement(By.cssSelector("[name='q']"));
        Search.sendKeys("Selenium");
        Search.sendKeys(Keys.ENTER);
        driver.quit();


    }
}
