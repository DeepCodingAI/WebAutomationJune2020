package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public String browserStackUserName = "your_user_name";
    public String browserStackAccessKey = "your_access_key";
    public String sauceLabsUserName = "";
    public String sauceLabsAccessKey = "";

    public WebDriver driver = null;
    @Parameters({"useCloudEnv","cloudEnvName","url","os","os_version","browserName","browserVersion"})
    @BeforeMethod
    public void setUp(String useCloudEnv,String cloudEnvName, String url,String OS, String os_version, String browserName,
                      String browserVersion)throws IOException {
        if (useCloudEnv.equalsIgnoreCase("true")) {
            getCloudDriver(cloudEnvName,browserStackUserName,browserStackAccessKey,OS,os_version,browserName,browserVersion);
        } else if (useCloudEnv.equalsIgnoreCase("false")){
            getLocalDriver(OS,browserName);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public WebDriver getLocalDriver(String OS, String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
           if(OS.equalsIgnoreCase("OS X")){
            System.setProperty("webdriver.chrome.driver", "./Generic/driver/chromedriver");
                driver = new ChromeDriver();
            }else if(OS.equalsIgnoreCase("Windows")){
                System.setProperty("webdriver.chrome.driver", "./Generic/driver/chromedriver.exe");
                driver = new ChromeDriver();
            }
        }else if (browserName.equalsIgnoreCase("firefox")) {
               if(OS.equalsIgnoreCase("OS X")) {
                System.setProperty("webdriver.gecko.driver", "./Generic/driver/geckodriver");
                driver = new FirefoxDriver();
            } else if (OS.equalsIgnoreCase("Windows")) {
                    System.setProperty("webdriver.gecko.driver", "./Generic/driver/geckodriver.exe");
                    driver = new FirefoxDriver();

            }
        }

        return driver;
    }
    public WebDriver getCloudDriver(String envName, String envUserName, String envAccessKey, String OS,
                                    String os_version, String browserName, String browserVersion)throws IOException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browser", browserName);
        cap.setCapability("browserVersion", browserVersion);
        cap.setCapability("os", OS);
        cap.setCapability("os_version", os_version);
        if(envName.equalsIgnoreCase("Saucelabs")){
            driver = new RemoteWebDriver(new URL("http://"+envUserName+":"+envAccessKey+
                    "@ondemand.saucelabs.com:80/wd/hub"), cap);
        }else if(envName.equalsIgnoreCase("Browserstack")) {
            driver = new RemoteWebDriver(new URL("http://" + envUserName + ":" + envAccessKey +
                    "@hub-cloud.browserstack.com/wd/hub"), cap);
        }

        return driver;
    }
    @AfterMethod
    public void cleanUp(){
        driver.close();
    }

    public void clickOnElement(String locator){
        driver.findElement(By.cssSelector(locator)).click();
    }
    public void typeOnElement(String locator, String value){
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }
    public List<WebElement> getListOfWebElements(String locator){
        List<WebElement> elementList = driver.findElements(By.cssSelector(locator));

        return elementList;
    }
    public List<String> getListOfString(List<WebElement> elementList){
        List<String> listOfString = new ArrayList<String>();
        for(WebElement element:elementList){
            listOfString.add(element.getText());
        }
        return listOfString;
    }


}
