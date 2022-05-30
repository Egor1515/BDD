package ru.netology.data.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DashBoard {

    private static SelenideElement card1 = $x("//*[@id=\"root\"]/div/ul/li[1]/div/button");
    private static SelenideElement card2 = $x("//*[@id=\"root\"]/div/ul/li[2]/div/button");
    private static SelenideElement heading = $("[data-test-id='dashboard']");

    private static SelenideElement reload = $("[data-test-id='action-reload']");
    private static SelenideElement button = $("[data-test-id = 'action-deposit']");

    public DashBoard() {
        heading.shouldBe(visible);
    }

    private static ElementsCollection cards = $$(".list__item div");
    private static final String balanceStart = "баланс: ";
    private static final String balanceFinish = " р.";

    public static void firstCardButton() {
        card2.click();
    }
    public static void secondCardButton() {
        card1.click();
    }
    public static class GetCardBalance {

        public GetCardBalance() {
        }
        public int getFirstCardBalance() {
            val text = cards.first().text();
            return extractBalance(text);
        }

        private int extractBalance(String text) {
            val start = text.indexOf(balanceStart);
            val finish = text.indexOf(balanceFinish);
            val value = text.substring(start + balanceStart.length(), finish);
            return Integer.parseInt(value);
        }
    }
}