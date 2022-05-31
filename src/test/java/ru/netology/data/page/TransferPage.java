package ru.netology.data.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import ru.netology.data.datahelper.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {

    static Faker faker = new Faker();
    private static final SelenideElement amountSent = $("[data-test-id='amount'] input");
    private static final SelenideElement moneyFrom = $("[data-test-id='from'] input");
    private static final SelenideElement buttonSent = $(".button[data-test-id='action-transfer']");
    private static final int amount = Integer.parseInt(faker.numerify("###"));

    public void sentFromSecondCard(String card) {
        DashBoard.firstCardButton();
        amountSent.setValue(String.valueOf(amount));
        moneyFrom.setValue(card);
        buttonSent.click();
    }

    public static int getAmount() {
        return amount;
    }

    public void sentFromFirstCard(String card) {
        DashBoard.secondCardButton();
        amountSent.setValue(String.valueOf(amount));
        moneyFrom.setValue(String.valueOf(card));
        buttonSent.click();

    }

}



