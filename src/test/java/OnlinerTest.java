import com.codeborne.selenide.Selenide;
import helpers.BaseTest;
import helpers.JsonDataReader;
import org.testng.annotations.Test;
import steps.MainPageSteps;
import utilities.CustomLogger;

import java.util.Map;

public class OnlinerTest extends BaseTest {

    Map<String, String> testData = JsonDataReader.getTestData();

    @Test(description = "Test login process")
    public void logInTest() {
        CustomLogger.info("Test login process");
        MainPageSteps mainPageSteps = new MainPageSteps();
        mainPageSteps.open();
        mainPageSteps.openLoginForm();
        mainPageSteps.enterLogin(testData.get("login"));
        mainPageSteps.enterPassword(testData.get("password"));
        mainPageSteps.submitLoginForm();
        mainPageSteps.verifyLogin();
    }

    @Test(description = "Test search")
    public void searchTest() {
        CustomLogger.info("Test search");
        MainPageSteps mainPageSteps = new MainPageSteps();
        mainPageSteps.open();
        mainPageSteps.searchItem(testData.get("searchOption"));
        mainPageSteps.verifySearchResults(testData.get("searchOption"));
    }
}
