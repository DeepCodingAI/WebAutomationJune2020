package hometabs;


import base.CommonAPI;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LandingPage extends CommonAPI {

    @Test
    public void landingPage(){
        clickOnElement("#block_top_menu > ul > li:nth-child(1) > a");
    }

}
