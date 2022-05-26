package ru.netology.data.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.netology.data.datahelper.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPageV1 {
    public static VerificationPage validLogin(DataHelper.AuthInfo info) {
        $("[data-test-id=login] input").setValue(info.getLogin());
        $("[data-test-id=password] input").setValue(info.getPassword());
        $("[data-test-id=action-login]").click();
        return new VerificationPage();
    }

    public static class LoginPageV2 {

        private final SelenideElement loginField = $("[data-test-id=login] input");
        private final SelenideElement passwordField = $("[data-test-id=password] input");
        private final SelenideElement loginButton = $("[data-test-id=action-login]");

        public VerificationPage validLogin(DataHelper.AuthInfo info) {
            loginField.setValue(info.getLogin());
            passwordField.setValue(info.getPassword());
            loginButton.click();
            return new VerificationPage();
        }
    }

    public static class LoginPageV3 {
        @FindBy(css = "[data-test-id=login] input")
        private SelenideElement loginField;
        @FindBy(css = "[data-test-id=password] input")
        private SelenideElement passwordField;
        @FindBy(css = "[data-test-id=action-login]")
        private SelenideElement loginButton;

        public VerificationPage validLogin(DataHelper.AuthInfo info) {
            loginField.setValue(info.getLogin());
            passwordField.setValue(info.getPassword());
            loginButton.click();
            return page(VerificationPage.class);
        }

    }
}