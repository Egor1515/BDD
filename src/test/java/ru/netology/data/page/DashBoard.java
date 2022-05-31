package ru.netology.data.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DashBoard {

    private static SelenideElement heading = $("[data-test-id='dashboard']");

    private static SelenideElement reload = $("[data-test-id='action-reload']");
    private static ElementsCollection buttons = $$("[data-test-id = 'action-deposit']");

    public DashBoard() {
        heading.shouldBe(visible);
    }

    private static ElementsCollection cards = $$(".list__item div");
    private static final String balanceStart = "баланс: ";
    private static final String balanceFinish = " р.";

    public static void firstCardButton() {
        buttons.first().click();
    }

    public static void secondCardButton() {
        buttons.last().click();
    }
    public static class GetCardBalance {

        public static int getFirstCardBalance() {
            val text = cards.first().text();
            return extractBalance(text);

        }
        public int getSecondCardBalance() {
            val text = cards.last().text();
            return extractBalance(text);

        }

        private static int extractBalance(String text) {
            val start = text.indexOf(balanceStart);
            val finish = text.indexOf(balanceFinish);
            val value = text.substring(start + balanceStart.length(), finish);
            return Integer.parseInt(value);
        }
    }
}