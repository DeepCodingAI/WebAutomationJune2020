package search;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItems extends CommonAPI {

    @Test
    public void test1() throws InterruptedException{
        typeOnElement("twotabsearchtextbox","Comic Book");
        Thread.sleep(2000);
        System.out.println("potential conflict");
    }

    @Test
    public void test2(){
        String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle,actualTitle);
    }

}
