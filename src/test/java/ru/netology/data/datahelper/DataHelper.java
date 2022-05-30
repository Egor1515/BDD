package ru.netology.data.datahelper;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import static com.codeborne.selenide.Selenide.$;

public class DataHelper {
    private static final SelenideElement cardInfo1 = $("data-test-id ='92df3f1c-a033-48e6-8390-206f6b1f56c0'");
    private static final SelenideElement cardInfo2 = $("data-test-id ='0f3f5c2a-249e-4c3d-8287-09f7a039391d'");

    private DataHelper() {
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor

    public static class AuthInfo {
        String login;
        String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo(AuthInfo original) {
        return new AuthInfo("petya", "123qwerty");
    }

    @Value
    public static class VerificationCode {
        String code;
    }
    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }
}
