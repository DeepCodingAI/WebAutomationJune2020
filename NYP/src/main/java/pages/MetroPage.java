package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetroPage extends News{
    private WebDriver driver = null;

    public MetroPage(){ }

    public MetroPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
