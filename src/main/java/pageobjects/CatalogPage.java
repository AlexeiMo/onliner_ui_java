package pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogPage {

    private final ElementsCollection categoryButtons = $$(".catalog-navigation-classifier__item-title-wrapper");
    private final ElementsCollection subCategoryButtons = $$(".catalog-navigation-list__aside-title");
    private final ElementsCollection productCategoryButtons
            = $$(".catalog-navigation-list__aside-item.catalog-navigation-list__aside-item_active .catalog-navigation-list__dropdown-title");
    private final ElementsCollection productTitles = $$(".schema-product__title span");
    private final ElementsCollection compareCheckboxes = $$(".schema-product__control");
    private final SelenideElement compareButton = $("#compare-button-container .compare-button.compare-button_visible");
    private final ElementsCollection comparedProducts
            = $$(".product-table__row.product-table__row_header.product-table__row_top .product-summary__caption");
    private final SelenideElement clearCompareButton = $(".compare-button__state.compare-button__state_clear.compare-button__state_hidden");
    private final ElementsCollection productPageLinks = $$(".schema-product__title span");

    public void clickCategoryButton(String name) {
        this.categoryButtons.shouldHave(sizeGreaterThan(0));
        for (SelenideElement elem: this.categoryButtons) {
            if(elem.getText().equals(name)) {
                elem.click();
                break;
            }
        }
    }

    public void clickSubCategoryButton(String name) {
        this.subCategoryButtons.shouldHave(sizeGreaterThan(0));
        for (SelenideElement elem: this.subCategoryButtons) {
            if(elem.getText().equals(name)) {
                elem.click();
                break;
            }
        }
    }

    public void clickProductCategoryButton(String name) {
        this.productCategoryButtons.shouldHave(sizeGreaterThan(0));
        for (SelenideElement elem: this.productCategoryButtons) {
            if(elem.getText().equals(name)) {
                elem.click();
                break;
            }
        }
    }

    public void clickCompareCheckbox(int index) {
        this.compareCheckboxes.shouldHave(sizeGreaterThan(0));
        this.compareCheckboxes.get(index).click();
    }

    public void clickCompareButton() {
        this.compareButton.click();
    }

    public String getProductTitle(int index) {
        this.productTitles.shouldHave(sizeGreaterThan(0));
        return this.productTitles.get(index).getText();
    }

    public String getComparedProductTitle(int index) {
        this.comparedProducts.shouldHave(sizeGreaterThan(0));
        return this.comparedProducts.get(index).getText();
    }

    public void clickClearCompareButton() {
        this.clearCompareButton.click();
    }

    public void clickProductPageLink(int index) {
        this.productPageLinks.shouldHave(sizeGreaterThan(0));
        this.productPageLinks.get(index).click();
    }

}
