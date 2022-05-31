package ru.netology.data.test;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import ru.netology.data.datahelper.DataHelper;
import ru.netology.data.page.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTransferTest {

    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {
        Configuration.holdBrowserOpen = true;
        var page = new TransferPage();
        var loginPage = open("http://localhost:9999", LoginPageV1.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        int expected = DashBoard.GetCardBalance.getFirstCardBalance();
        page.sentFromSecondCard(DataHelper.getCardInfo2());
        int actual = DashBoard.GetCardBalance.getFirstCardBalance() - TransferPage.getAmount();
        assertEquals(expected, actual);

    }
//    @Test
//    void shouldTransferMoneyBetweenOwnCardsV2() {
//        Configuration.holdBrowserOpen = true;
//        var loginPage = open("http://localhost:9999", LoginPageV2.class);
//        var authInfo = DataHelper.getAuthInfo();
//        var verificationPage = loginPage.validLogin(authInfo);
//        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
//        verificationPage.validVerify(verificationCode);
//
//
//    }
//
//    @Test
//    void shouldTransferMoneyBetweenOwnCardsV3() {
//        var loginPage = open("http://localhost:9999", LoginPageV3.class);
//        var authInfo = DataHelper.getAuthInfo();
//        var verificationPage = loginPage.validLogin(authInfo);
//        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
//        verificationPage.validVerify(verificationCode);
//
//    }
}
