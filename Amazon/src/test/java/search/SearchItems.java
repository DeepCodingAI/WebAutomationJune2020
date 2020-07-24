package search;

import base.CommonAPI;
import datasuply.DataReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchItems extends CommonAPI {

    @Test
    public void test1() throws InterruptedException{
        List<String> data = DataReader.getListOfItems();
        for(int i=0; i<data.size(); i++) {
            typeOnElement("#twotabsearchtextbox", data.get(i));
            Thread.sleep(2000);
            clearInputField("#twotabsearchtextbox");
        }
    }

    @Test
    public void test2(){
        String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle,actualTitle);
    }

}
