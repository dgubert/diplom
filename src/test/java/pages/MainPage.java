package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

public class MainPage {

    SelenideElement linkCity = $(".header-upper-region-control__text-overflow"),
            chooseCityForm = $("[placeholder=\"Ваш город или регион\"]");

    @Step("Проверяем Title страницы на соответствие {0}")
    public void shouldHaveTitle(String title) {
        Assertions.assertEquals(title(), title);
    }

    @Step("Изменяем регион на {0}")
    public void changeCity(String city) {
        if (!linkCity.text().equals(city)) {
            linkCity.click();
            chooseCityForm.parent().parent().parent().$(byText(city)).click();
            chooseCityForm.shouldNotBe(visible);
        }
    }
}
