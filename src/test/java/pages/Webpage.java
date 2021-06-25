package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Webpage {

    protected Webpage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
