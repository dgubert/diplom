package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BasketPage extends MainPage {

    @Step("Открываем страницу корзины")
    public void openBasketPage() {
        open("/basket/");
    }

    @Step("Проверяем информацию по товару {0} в корзине")
    public void assertProductInfo(PRODUCTS product) {
        SelenideElement form = $(".basket-detail__content");

        form.$(byText(product.getPrice())).shouldBe(exist);
    }
}
