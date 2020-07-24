package pages;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchPage {

    @FindBy(how = How.CSS, using = "#search-field")
    public static WebElement searchFieldWebElement;

    @FindBy(how = How.CSS, using = "#search-submit")
    public static WebElement searchSubmitButtonWebElement;

    public WebElement getSearchFieldWebElement(){

        return searchFieldWebElement;
    }
    public WebElement getSearchSubmitButtonWebElement(){

        return searchSubmitButtonWebElement;
    }
    public void typeOnSearchField(String value){
        getSearchFieldWebElement().sendKeys(value);
    }
    public void clickOnSearchButton(){
        getSearchSubmitButtonWebElement().click();
    }

}
