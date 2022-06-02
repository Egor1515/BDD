package ru.netology.data.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import ru.netology.data.datahelper.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {

    private final SelenideElement amountSent = $("[data-test-id='amount'] input");
    private final SelenideElement moneyFrom = $("[data-test-id='from'] input");
    private final SelenideElement buttonSent = $(".button[data-test-id='action-transfer']");

    public void sentFromSecondCard(String card, int amount) {
        amountSent.setValue(String.valueOf(amount));
        moneyFrom.setValue(card);
        buttonSent.click();
    }
}



