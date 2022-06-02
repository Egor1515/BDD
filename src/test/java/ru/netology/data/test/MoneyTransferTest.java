package ru.netology.data.test;


import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.datahelper.DataHelper;
import ru.netology.data.page.DashBoard;
import ru.netology.data.page.LoginPageV1;
import ru.netology.data.page.TransferPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTransferTest {

    Faker faker = new Faker();
    private final int amount = Integer.parseInt(faker.numerify("###"));

    @BeforeAll
    static void setUp() {
        var loginPage = open("http://localhost:9999", LoginPageV1.class);
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {
        Configuration.holdBrowserOpen = true;
        var page = new TransferPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = LoginPageV1.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        DashBoard dash = new DashBoard();
        int expected = dash.getFirstCardBalance();
        dash.firstCardButton();
        page.sentFromSecondCard(DataHelper.getCardInfo2(), amount);
        int actual = dash.getFirstCardBalance() - amount;
        assertEquals(expected, actual);

    }
}
