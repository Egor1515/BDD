package ru.netology.data.datahelper;

import com.codeborne.selenide.SelenideElement;
import lombok.*;

import static com.codeborne.selenide.Selenide.$;

public class DataHelper {
    private static final String cardInfoStart = "number: '";
    private static final String cardInfoFinish = "'";
    private static final SelenideElement cardInfo1 = $("data-test-id ='92df3f1c-a033-48e6-8390-206f6b1f56c0'");
    private static final SelenideElement cardInfo2 = $("data-test-id ='0f3f5c2a-249e-4c3d-8287-09f7a039391d'");

    public static int cardInfo1() {
        val text = cardInfo1.text();
        return extractCardNumber(text);
    }

    public static int cardInfo2() {
        val text = cardInfo2.text();
        return extractCardNumber(text);
    }


    public static int extractCardNumber(String text) {
        val start = text.indexOf(cardInfoStart);
        val finish = text.indexOf(cardInfoFinish);
        val value = text.substring(start + cardInfoStart.length(), finish);
        return Integer.parseInt(value);
    }

    public DataHelper() {
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
