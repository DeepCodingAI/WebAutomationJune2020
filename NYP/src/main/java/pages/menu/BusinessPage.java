package pages.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.News;

public class BusinessPage extends News {
    private final WebDriver driver;
    public BusinessPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //implement Section menu

    @FindBy(how = How.CSS, using = "div.headline-wrapper a:nth-child(2) h3")
    public static WebElement headLineNewsWebElement;

    public WebElement getHeadLineNewsWebElement(){
        return headLineNewsWebElement;
    }
}