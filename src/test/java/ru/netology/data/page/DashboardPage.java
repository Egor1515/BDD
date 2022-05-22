package ru.netology.data.page;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    Faker faker = new Faker();
    private final SelenideElement amountSent = $("[data-test-id='amount'] input");
    private final SelenideElement moneyFrom = $("[data-test-id='from'] input");
    private final SelenideElement buttonSent = $(".button[data-test-id='action-transfer']");
    private final SelenideElement button = $(".button[data-test-id='action-deposit']");


    public void sentFromSecondCard(String card) {
        amountSent.setValue(faker.numerify("###"));
        moneyFrom.setValue(card);
        buttonSent.click();

    }

    public void sentFromFirstCard(String card) {
        button.click();
        amountSent.setValue(faker.numerify("###"));
        moneyFrom.setValue(card);
        buttonSent.click();

    }


}

