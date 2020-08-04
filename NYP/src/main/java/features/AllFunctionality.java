package features;

import base.CommonAPI;
import datasuply.FetchTheSteps;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LandingPage;
import pages.SearchPage;
import pages.SectionsPage;
import pages.SignUpPage;
import reporting.TestLogger;

import java.io.IOException;

public class AllFunctionality {

    LandingPage landingPage = null;
    SignUpPage signUpPage = null;
    SearchPage searchPage = null;
    SectionsPage sectionsPage = null;

    public void signUp(WebDriver driver){
        landingPage = PageFactory.initElements(driver, LandingPage.class);
        signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        landingPage.clickOnSignUp();
        signUpPage.enterEmailAddress("abc123@gmail.com");
        signUpPage.clickOnSignUp();
    }
    public void search(WebDriver driver){
        landingPage = PageFactory.initElements(driver, LandingPage.class);
        landingPage.clickOnSearch();
        searchPage = PageFactory.initElements(driver, SearchPage.class);
        searchPage.typeOnSearchField("covid-19");
        searchPage.clickOnSearchButton();
    }
    public void clickOnSectionMenu(WebDriver driver)throws InterruptedException{
        landingPage = PageFactory.initElements(driver, LandingPage.class);
        landingPage.clickOnSectionMenu();
    }
    public void sectionsMenu(WebDriver driver)throws InterruptedException{
        clickOnSectionMenu(driver);
        sectionsPage = PageFactory.initElements(driver, SectionsPage.class);
        sectionsPage.goToMetroPage(driver).clickOnHeadLineNews();
        clickOnSectionMenu(driver);
        sectionsPage.goToBusinessPage(driver).clickOnHeadLineNews();
        clickOnSectionMenu(driver);
        sectionsPage.goToEntertainmentPage(driver).clickOnHeadLineNews();
    }
    public void runAllTheFeatureTest(WebDriver driver) throws InterruptedException,IOException {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        FetchTheSteps fetchTheSteps = new FetchTheSteps();
        String [] featureSteps = fetchTheSteps.getDataFromExcelFile();
        for(int i=1; i<featureSteps.length; i++){
            select(featureSteps[i],driver);
        }
    }

    public void select(String featureName, WebDriver driver)throws InterruptedException,IOException{
        switch(featureName){
            case "signUp":
                signUp(driver);
                break;
            case "sectionsMenu":
                sectionsMenu(driver);
                break;
            case "search":
                search(driver);
                break;
            default:
                throw new InvalidArgumentException("Invalid features choice");
        }
    }

}
