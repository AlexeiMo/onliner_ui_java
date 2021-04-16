package steps;

import static com.codeborne.selenide.Condition.visible;
import com.codeborne.selenide.Selenide;
import helpers.BaseTest;
import pageobjects.MainPage;


public class MainPageSteps extends BaseTest {

    private final MainPage mainPage = new MainPage();

    public void open() {
        logger.info("Open onliner.by page");
        Selenide.open("/");
    }

    public void openLoginForm() {
        logger.info("Open login form");
        mainPage.clickLoginButton();
    }

    public void enterLogin(String login) {
        logger.info("Type login to the form");
        mainPage.fillInLoginField(login);
    }

    public void enterPassword(String password) {
        logger.info("Type password to the form");
        mainPage.fillInPasswordField(password);
    }

    public void submitLoginForm() {
        logger.info("Submit login form");
        mainPage.clickSubmitLoginButton();
    }

    public void verifyLogin() {
        logger.info("Verify login process");
        mainPage.getProfileImage().should(visible);
    }

}
