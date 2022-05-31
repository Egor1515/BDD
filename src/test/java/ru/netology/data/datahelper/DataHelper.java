package ru.netology.data.datahelper;

import lombok.*;

public class DataHelper {

    private static final String cardInfo1 = "5559000000000001";
    private static final String cardInfo2 = "5559000000000002";
    public static String getCardInfo1() {
        return cardInfo1;
    }

    public static String getCardInfo2() {
        return cardInfo2;
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
