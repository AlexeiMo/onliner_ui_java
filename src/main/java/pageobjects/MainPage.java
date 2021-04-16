package pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    // Elements
    private final SelenideElement loginButton = $(".auth-bar__item.auth-bar__item--text");
    private final SelenideElement loginField = $("#auth-container input[type='text']");
    private final SelenideElement passwordField = $("#auth-container input[type='password']");
    private final SelenideElement submitLoginButton = $("#auth-container button");
    private final SelenideElement profileImage = $(".b-top-profile__image.js-header-user-avatar");

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

}
