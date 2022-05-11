package ru.netology.data.test;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import ru.netology.data.datahelper.DataHelper;
import ru.netology.data.page.CardTransfer;
import ru.netology.data.page.*;

import static com.codeborne.selenide.Selenide.open;

class MoneyTransferTest {
    CardTransfer card = new CardTransfer();
    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {
        Configuration.holdBrowserOpen= true;
        var page = new DashboardPage();
        var loginPage = open("http://localhost:9999", LoginPageV1.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        card.cardTransfer1();
        page.getFirstCardBalance();
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV2() {
        Configuration.holdBrowserOpen = true;
        var loginPage = open("http://localhost:9999", LoginPageV2.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        card.cardTransfer1();




    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV3() {
        var loginPage = open("http://localhost:9999", LoginPageV3.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

    }
}
