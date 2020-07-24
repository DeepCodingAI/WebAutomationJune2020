package pages;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LandingPage {

    @FindBy(how = How.CSS, using = "#sections > span.menu-icon > svg")
    public static WebElement sectionNavBarWebElement;

    @FindBy(how = How.CSS, using = "#page-nav .icon-email")
    public static WebElement signUpWebElement;

    @FindBy(how = How.CSS, using = "span.search-text")
    public static WebElement searchWebElement;

    public static WebElement getSectionNavBarWebElement() {
        return sectionNavBarWebElement;
    }

    public static WebElement getSignUpWebElement() {
        return signUpWebElement;
    }

    public static WebElement getSearchWebElement() {
        return searchWebElement;
    }

    public void clickOnSignUp(){
        getSignUpWebElement().click();
    }
    public void clickOnSearch(){
        getSearchWebElement().click();
    }
    public void clickOnSectionMenu()throws InterruptedException{
        try {
            getSectionNavBarWebElement().click();
        }catch(Exception ex){
            CommonAPI.navigateBack();
            Thread.sleep(2000);
            getSectionNavBarWebElement().click();
        }
    }

}
