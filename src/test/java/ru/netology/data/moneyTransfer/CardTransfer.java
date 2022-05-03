package ru.netology.data.moneyTransfer;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import ru.netology.data.page.DashBoard;

import static com.codeborne.selenide.Selenide.$;


public class CardTransfer {
    Faker faker = new Faker();

    private final String amountSent = faker.numerify("###");
    private final String card1 = "5559 0000 0000 0001";
    private final String card2 = "5559 0000 0000 0002";

    public DashBoard cardTransfer1() {
        $("[data-test-id='action-deposit']").should(Condition.text("Пополнить")).click();
        $("[data-test-id='amount'] input").setValue(amountSent);
        $("[data-test-id='from'] input").setValue(card2);
        $("[data-test-id='action-transfer']").click();
        return new DashBoard();

    }

    public DashBoard cardTransfer2() {
        $("button__text]").should(Condition.text("Пополнить")).click();
        $("[data-test-id='amount']").setValue(amountSent);
        $("[data-test-id='from']").setValue(card1);
        $("[data-test-id='action-transfer']").click();
        return new DashBoard();
    }
}
