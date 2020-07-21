package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SectionPage {

    @FindBy(how = How.CSS, using = "svg.menu-icon-svg")
    public static WebElement sectionNavBarWebElement;

    @FindBy(how = How.CSS, using = "ul#menu-main-menu li:nth-child(2) a")
    public static WebElement metroSectionWebElement;

    @FindBy(how = How.CSS, using = "ul#menu-main-menu li:nth-child(5) a")
    public static WebElement businessSectionWebElement;

    public static WebElement getSectionNavBarWebElement() {
        return sectionNavBarWebElement;
    }

    public static WebElement getMetroSectionWebElement() {
        return metroSectionWebElement;
    }

    public static WebElement getBusinessSectionWebElement() {
        return businessSectionWebElement;
    }

    public void clickOnSectionMenuTab(){
        getSectionNavBarWebElement().click();
    }
    public MetroPage goToMetroPage(WebDriver driver){
        getMetroSectionWebElement().click();
        return new MetroPage(driver);
    }

}
