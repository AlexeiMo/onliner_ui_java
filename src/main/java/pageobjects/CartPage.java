package pageobjects;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private final SelenideElement createOrderButton = $(".cart-form__offers-part.cart-form__offers-part_confirm a");
    private final SelenideElement orderTitle = $(".cart-form__title.cart-form__title_big-alter.cart-form__title_extended-alter");

    public void clickCreateOrderButton() {
        this.createOrderButton.click();
    }

    public String getOrderTitle() {
        return this.orderTitle.getText();
    }

}
