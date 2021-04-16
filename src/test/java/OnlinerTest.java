import helpers.BaseTest;
import helpers.JsonDataReader;
import org.testng.annotations.Test;
import steps.MainPageSteps;

import java.util.Map;

public class OnlinerTest extends BaseTest {

    @Test(description = "Test login process")
    public void logInTest() {
        Map<String, String> testData = JsonDataReader.getTestData();
        // Actions
        MainPageSteps mainPageSteps = new MainPageSteps();
        mainPageSteps.open();
        mainPageSteps.openLoginForm();
        mainPageSteps.enterLogin(testData.get("login"));
        mainPageSteps.enterPassword(testData.get("password"));
        mainPageSteps.submitLoginForm();
        // Assert
        mainPageSteps.verifyLogin();
    }
}
