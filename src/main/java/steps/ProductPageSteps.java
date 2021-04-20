package steps;

import com.codeborne.selenide.Selenide;
import helpers.BaseTest;
import pageobjects.ProductPage;
import utilities.CustomLogger;

public class ProductPageSteps extends BaseTest {

    private final ProductPage productPage = new ProductPage();

    private boolean isProductAdded = false;

    public void moveToProductTraders() {
        CustomLogger.info("Move to product traders page");
        productPage.clickProductTraders();
    }

    public void addProductToCart(int index) {
        CustomLogger.info("Add product to cart");
        productPage.clickBuyProductButton(index);
        isProductAdded = true;
    }

    public void openCartPage() {
        CustomLogger.info("Open cart page");
        productPage.clickCartButton();
    }

    public void acceptLocation() {
        CustomLogger.info("Accept location");
        productPage.moveToLocationButton();
        productPage.clickLocationButton();
    }

    public void removeProduct(String url) {
        CustomLogger.info("Remove product from cart");
        if(isProductAdded) {
            Selenide.open(url);
            productPage.clickRemoveProductButton();
        }
    }

}
