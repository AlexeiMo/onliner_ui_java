package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.ScreenShooter;
import utilities.CustomLogger;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setUp() {
        CustomLogger.info("Open the browser");
        // Define which browser we will use
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        // Size of the browser window
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://onliner.by";
        ScreenShooter.captureSuccessfulTests = true;
    }
}
