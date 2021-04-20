package pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductPage {

    private final SelenideElement productTraders = $(".button.button_orange.button_big.offers-description__button");
    private final ElementsCollection buyProductButtons = $$(".offers-list__control.offers-list__control_default>a");
    private final SelenideElement cartButton = $("#cart-desktop");
    private final SelenideElement locationButton = $(".button-style.button-style_another.button-style_base.offers-form__button");
    private final SelenideElement locationInfo = $(".offers-list__description.offers-list__description_alter.offers-list__description_base");
    private final SelenideElement removeProductButton = $(".cart-form__offers-part.cart-form__offers-part_remove a");

    public void clickProductTraders() {
        this.productTraders.click();
    }

    public void clickBuyProductButton(int index) {
        this.buyProductButtons.shouldHave(sizeGreaterThan(0));
        this.buyProductButtons.get(index).click();
    }

    public void clickCartButton() {
        this.cartButton.click();
    }

    public void moveToLocationButton() {
        this.locationButton.scrollTo();
    }

    public void clickLocationButton() {
        this.locationButton.click();
    }

    public void clickRemoveProductButton() {
        this.removeProductButton.hover();
        this.removeProductButton.click();
    }

}
