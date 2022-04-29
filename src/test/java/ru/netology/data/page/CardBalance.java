package ru.netology.data.page;

import com.codeborne.selenide.ElementsCollection;
import lombok.val;

import static com.codeborne.selenide.Selenide.$$;

public class CardBalance {
    public class GetCardBalance {
        private ElementsCollection cards = $$(".list__item div");
        private final String balanceStart = "баланс: ";
        private final String balanceFinish = " р.";

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
