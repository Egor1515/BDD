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

    DashBoard.GetCardBalance balance = new DashBoard.GetCardBalance();
    DataHelper info = new DataHelper();
//    String card1 = "5559000000000001";
//    String card2 = "5559000000000002";
    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {
        Configuration.holdBrowserOpen = true;
        var page = new TransferPage();
        var loginPage = open("http://localhost:9999", LoginPageV1.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        int expected = balance.getFirstCardBalance();
        page.sentFromFirstCard(DataHelper.cardInfo2());
        int actual = balance.getFirstCardBalance() - TransferPage.getAmount();
        assertEquals(expected,actual);

    }
//    @Test
//    void shouldReturn(){
//        final SelenideElement cardInfo2 = $("data-test-id ='0f3f5c2a-249e-4c3d-8287-09f7a039391d'");
//
//        DataHelper.cardInfo();
//    }

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
