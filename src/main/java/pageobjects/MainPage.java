package pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    private final SelenideElement loginButton = $(".auth-bar__item.auth-bar__item--text");
    private final SelenideElement loginField = $("#auth-container input[type='text']");
    private final SelenideElement passwordField = $("#auth-container input[type='password']");
    private final SelenideElement submitLoginButton = $("#auth-container button");
    private final SelenideElement profileImage = $(".b-top-profile__image.js-header-user-avatar");
    private final SelenideElement searchInput = $(".search__input");
    private final SelenideElement searchFrame = $(".modal-iframe");
    private final ElementsCollection searchResults = $$(".product__title>a");
    private final SelenideElement cartButton = $("#cart-desktop");
    private final ElementsCollection categoryButtons = $$(".b-main-navigation__text");

    public void clickLoginButton() {
        this.loginButton.click();
    }

    public void fillInLoginField(String login) {
        this.loginField.setValue(login);
    }

    public void fillInPasswordField(String password) {
        this.passwordField.setValue(password);
    }

    public void clickSubmitLoginButton() {
        this.submitLoginButton.click();
    }

    public SelenideElement getProfileImage() {
        return this.profileImage;
    }

    public void clickCartButton() {
        this.cartButton.click();
    }

    public void clickCategoryButton(String name) {
        for (SelenideElement elem : this.categoryButtons) {
            if(elem.getText().equals(name)) {
                elem.click();
                break;
            }
        }
    }

    public void switchToSearchFrame() {
        Selenide.switchTo().frame(this.searchFrame);
    }

    public void setSearchOption(String option) {
        this.searchInput.setValue(option);
    }

    public ElementsCollection getSearchResults() { return this.searchResults; }

}
