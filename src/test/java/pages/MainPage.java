package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    SelenideElement linkCity = $(".header-upper-region-control__text-overflow"),
            chooseCityForm = $("#addressInput");

    @Step("Изменяем регион на {0}")
    public void changeCity(String city) {
        if (!linkCity.text().equals(city)) {
            linkCity.click();
            chooseCityForm.parent().parent().parent().$(byText(city)).click();
            chooseCityForm.shouldNotBe(exist);
        }
    }
}
