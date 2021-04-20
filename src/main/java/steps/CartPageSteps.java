package steps;

import static com.codeborne.selenide.WebDriverRunner.url;
import helpers.BaseTest;
import pageobjects.CartPage;
import utilities.CustomLogger;

public class CartPageSteps extends BaseTest {

    private final CartPage cartPage = new CartPage();

    public void createOrder() {
        CustomLogger.info("Create order");
        cartPage.clickCreateOrderButton();
    }

    public void verifyOrderPage(String expectedUrl, String title) {
        assert cartPage.getOrderTitle().contains(title);
        assert url().equals(expectedUrl);
    }

}
