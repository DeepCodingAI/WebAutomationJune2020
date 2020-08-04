package search;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import reporting.TestLogger;

import java.util.List;

public class DropDownMenu extends CommonAPI {

    @Test
    public void dropDown(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        List<WebElement> elementList = getListOfWebElementsByCss("#searchDropdownBox option");
        List<String> listOfString = getListOfString(elementList);
        for(String st:listOfString){
            System.out.println(st);
            System.out.println("wait for page to load");
        }
    }
}
