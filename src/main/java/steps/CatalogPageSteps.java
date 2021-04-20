package steps;

import static com.codeborne.selenide.WebDriverRunner.url;
import helpers.BaseTest;
import pageobjects.CatalogPage;
import utilities.CustomLogger;

public class CatalogPageSteps extends BaseTest {

    private final CatalogPage catalogPage = new CatalogPage();

    public void openCategory(String name) {
        CustomLogger.info("Open specified category");
        catalogPage.clickCategoryButton(name);
    }

    public void openSubCategoryButton(String name) {
        CustomLogger.info("Open specified subcategory");
        catalogPage.clickSubCategoryButton(name);
    }

    public void openProductCategory(String name) {
        CustomLogger.info("Open specified product category");
        catalogPage.clickProductCategoryButton(name);
    }

    public void markProductToCompare(int index) {
        CustomLogger.info("Mark specified product as compared");
        catalogPage.clickCompareCheckbox(index);
    }

    public void openCompareForm() {
        CustomLogger.info("Open compare form");
        catalogPage.clickCompareButton();
    }

    public String getProductTitle(int index) {
        CustomLogger.info("Get compared product title");
        return catalogPage.getProductTitle(index);
    }

    public void verifyCompare(String expectedUrl, String title1, String title2) {
        CustomLogger.info("Verify compare process");
        assert url().contains(expectedUrl);
        String compTitle1 = catalogPage.getComparedProductTitle(0);
        String compTitle2 = catalogPage.getComparedProductTitle(1);
        assert compTitle1.equals(title1);
        assert compTitle2.equals(title2);
    }

    public void clearCompare() {
        CustomLogger.info("Clear compare");
        catalogPage.clickClearCompareButton();
    }

    public void openProductPage(int index) {
        CustomLogger.info("Open specified product page");
        catalogPage.clickProductPageLink(index);
    }

}
