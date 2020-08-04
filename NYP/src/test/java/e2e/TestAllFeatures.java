package e2e;

import base.CommonAPI;
import features.AllFunctionality;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import reporting.TestLogger;

import java.io.IOException;

public class TestAllFeatures extends CommonAPI {

    @Test
    public void allFeatures()throws InterruptedException,IOException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        AllFunctionality functionality = PageFactory.initElements(driver,AllFunctionality.class);
        functionality.runAllTheFeatureTest(driver);
    }

}
