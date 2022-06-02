package ru.netology.data.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DashBoard {

    private final SelenideElement reload = $("[data-test-id='action-reload']");
    private final ElementsCollection buttons = $$("[data-test-id = 'action-deposit']");

    public DashBoard() {
        SelenideElement heading = $("[data-test-id='dashboard']");
        heading.shouldBe(visible);
    }

    private final ElementsCollection cards = $$(".list__item div");

    public void firstCardButton() {
        buttons.first().click();
    }

    public int getFirstCardBalance() {
        val text = cards.first().text();
        return extractBalance(text);

    }

    private int extractBalance(String text) {
        String balanceStart = "баланс: ";
        val start = text.indexOf(balanceStart);
        String balanceFinish = " р.";
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
}