import helpers.BaseTest;
import helpers.JsonDataReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.CartPageSteps;
import steps.CatalogPageSteps;
import steps.MainPageSteps;
import steps.ProductPageSteps;
import utilities.CustomLogger;

import java.util.Map;

public class OnlinerTest extends BaseTest {

    Map<String, String> testData = JsonDataReader.getTestData();
    MainPageSteps mainPageSteps = new MainPageSteps();
    CatalogPageSteps catalogPageSteps = new CatalogPageSteps();
    ProductPageSteps productPageSteps = new ProductPageSteps();
    CartPageSteps cartPageSteps = new CartPageSteps();

    @BeforeMethod()
    public void navigateToMainPage() {
        CustomLogger.info("Navigating to main page");
        mainPageSteps.open();
    }

    @Test(description = "Test login process")
    public void loginTest() {
        CustomLogger.info("Test login process");
        mainPageSteps.openLoginForm();
        mainPageSteps.enterLogin(testData.get("login"));
        mainPageSteps.enterPassword(testData.get("password"));
        mainPageSteps.submitLoginForm();
        mainPageSteps.verifyLogin();
    }

    @Test(description = "Test search")
    public void searchTest() {
        CustomLogger.info("Test search");
        mainPageSteps.searchItem(testData.get("searchOption"));
        mainPageSteps.verifySearchResults(testData.get("searchOption"));
    }

    @Test(description = "Test navigation")
    public void navigationTest() {
        CustomLogger.info("Test navigation");
        mainPageSteps.navigateToCategory(testData.get("categoryPageName"));
        mainPageSteps.verifyNavigation(testData.get("categoryUrl"));
    }

    @Test(description = "Test compare")
    public void compareTest() {
        CustomLogger.info("Test compare");
        mainPageSteps.navigateToCategory(testData.get("categoryPageName"));
        catalogPageSteps.openCategory(testData.get("categoryName"));
        catalogPageSteps.openSubCategoryButton(testData.get("subCategoryName"));
        catalogPageSteps.openProductCategory(testData.get("productCategoryName"));
        catalogPageSteps.markProductToCompare(0);
        catalogPageSteps.markProductToCompare(1);
        String title1 = catalogPageSteps.getProductTitle(0),
                title2 = catalogPageSteps.getProductTitle(1);
        catalogPageSteps.openCompareForm();
        catalogPageSteps.verifyCompare(testData.get("compareFormUrl"), title1, title2);
    }

    @Test(description = "Test order")
    public void orderTest() {
        CustomLogger.info("Test order");
        mainPageSteps.navigateToCategory(testData.get("categoryPageName"));
        catalogPageSteps.openCategory(testData.get("categoryName"));
        catalogPageSteps.openSubCategoryButton(testData.get("subCategoryName"));
        catalogPageSteps.openProductCategory(testData.get("productCategoryName"));
        catalogPageSteps.openProductPage(0);
        productPageSteps.moveToProductTraders();
        productPageSteps.acceptLocation();
        productPageSteps.addProductToCart(0);
        productPageSteps.openCartPage();
        cartPageSteps.createOrder();
        cartPageSteps.verifyOrderPage(testData.get("orderUrl"), testData.get("orderTitle"));
    }

    @AfterClass()
    public void removeProduct() {
        productPageSteps.removeProduct(testData.get("removeProductUrl"));
    }

}
