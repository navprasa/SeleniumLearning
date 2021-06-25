package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Webpage {

    @FindBy(css = "[name='q']")
    private WebElement Search;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void performsearch (String searchPhase){
        Search.sendKeys(searchPhase);
        Search.sendKeys(Keys.ENTER);
    }

}
