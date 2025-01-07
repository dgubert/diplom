package pages;

import com.codeborne.selenide.LocalStorage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static asserts.AssertText.assertExistByParentTextAndText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class GoodInfoPage {

    @Step("Открываем страницу продукта {0}")
    public void openGoodInfoPage(String goodLink) {
        open("/sankt-peterburg/catalog/product/" + goodLink + "/");
    }

    @Step("Проверяем данные продукта {0}")
    public void assertGoodInfo(GOODS good) {
        SelenideElement form = $(byId("mainAnchor"));

        form.$(byText(good.getForm())).shouldBe(exist);
        form.$(byText(good.getDosage())).shouldBe(exist);
        form.$(byText(good.getExpirationDate())).shouldBe(exist);
        form.$(byText(good.getCountry())).shouldBe(exist);
        form.$(byText(good.getPrice())).shouldBe(exist);
    }
}
