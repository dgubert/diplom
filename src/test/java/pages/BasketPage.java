package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BasketPage {

    @Step("Открываем страницу корзины")
    public BasketPage openBasketPage() {
        open("/basket/");
        return this;
    }

    @Step("Проверяем информацию по товару {0} в корзине")
    public void checkGoodInfo(GOODS good) {
        /*SelenideElement form = $("#mainAnchor");

        form.$(byText(good.getForm())).shouldBe(exist);
        form.$(byText(good.getDosage())).shouldBe(exist);
        form.$(byText(good.getExpirationDate())).shouldBe(exist);
        form.$(byText(good.getCountry())).shouldBe(exist);
        form.$(byText(good.getPrice())).shouldBe(exist);
        */
        SelenideElement form = $(".basket-detail__content");

        form.$(byText(good.getPrice())).shouldBe(exist);
        form.$(byText(good.getGoodCategory().getName())).shouldBe(exist);
    }
}
