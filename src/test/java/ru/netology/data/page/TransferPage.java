package ru.netology.data.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {

    static Faker faker = new Faker();
    private static final SelenideElement amountSent = $("[data-test-id='amount'] input");
    private static final SelenideElement moneyFrom = $("[data-test-id='from'] input");
    private static final SelenideElement buttonSent = $(".button[data-test-id='action-transfer']");
    private static final int amount = Integer.parseInt(faker.numerify("###"));
    private final String card1 = "5559 0000 0000 0001";
    private final String card2 = "5559 0000 0000 0002";

    public void sentFromSecondCard(int card) {
        amountSent.setValue(String.valueOf(amount));
        moneyFrom.setValue(String.valueOf(card));
        buttonSent.click();
    }
    public static int getAmount() {
        return amount;
    }
    public void sentFromFirstCard(int card) {
        DashBoard.secondCardButton();
        amountSent.setValue(String.valueOf(amount));
        moneyFrom.setValue(String.valueOf(card));
        buttonSent.click();
    }
        public DashBoard cardTransfer1(String card) {
            $("[data-test-id='action-deposit']").should(Condition.text("Пополнить")).click();
            $("[data-test-id='amount'] input").setValue(String.valueOf(amountSent));
            $("[data-test-id='from'] input").setValue(card2);
            $("[data-test-id='action-transfer']").click();
            return new DashBoard();
        }
        public DashBoard cardTransfer2(String card) {
            $("button__text]").should(Condition.text("Пополнить")).click();
            $("[data-test-id='amount']").setValue(String.valueOf(amountSent));
            $("[data-test-id='from']").setValue(card1);
            $("[data-test-id='action-transfer']").click();
            return new DashBoard();
        }
    }



