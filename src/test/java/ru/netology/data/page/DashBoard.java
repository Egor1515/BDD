package ru.netology.data.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashBoard {

    private SelenideElement heading = $("[data-test-id='dashboard']");

    public DashBoard() {
        heading.shouldBe(visible);
    }
}
