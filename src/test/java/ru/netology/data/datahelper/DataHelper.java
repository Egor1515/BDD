package ru.netology.data.datahelper;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.*;

import static com.codeborne.selenide.Selenide.*;

public class DataHelper {
    private static final ElementsCollection cardInfo1 = $$(".list__item div");
    private static final String cardInfoStart = "";
    private static final String cardInfoFinish = ", баланс";


    public static int cardInfo1() {
        val text = cardInfo1.first().text();
        return extractCardNumber(text);
    }

//    public static int cardInfo2() {
//        val text = cardInfo2.text();
//        return extractCardNumber(text);
//    }


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
