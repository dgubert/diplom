package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
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
    public void assertGoodInfo(GOODS good) {
        SelenideElement form = $(".basket-detail__content");

        form.$(byText(good.getPrice())).shouldBe(exist);
    }
}
