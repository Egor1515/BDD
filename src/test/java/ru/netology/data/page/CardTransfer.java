package ru.netology.data.page;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.$;


public class CardTransfer {
    Faker faker = new Faker();

    private final String amountSent = faker.numerify("###");
    private final String card1 = "5559 0000 0000 0001";
    private final String card2 = "5559 0000 0000 0002";

    public DashBoard cardTransfer1(String card) {
        $("[data-test-id='action-deposit']").should(Condition.text("Пополнить")).click();
        $("[data-test-id='amount'] input").setValue(amountSent);
        $("[data-test-id='from'] input").setValue(card2);
        $("[data-test-id='action-transfer']").click();
        return new DashBoard();

    }

    public DashBoard cardTransfer2(String card) {
        $("button__text]").should(Condition.text("Пополнить")).click();
        $("[data-test-id='amount']").setValue(amountSent);
        $("[data-test-id='from']").setValue(card1);
        $("[data-test-id='action-transfer']").click();
        return new DashBoard();
    }
}
