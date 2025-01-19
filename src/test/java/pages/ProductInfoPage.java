package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProductInfoPage {

    @Step("Открываем страницу продукта {0}")
    public void openProductInfoPage(String productLink) {
        open("/sankt-peterburg/catalog/product/" + productLink + "/");
    }

    @Step("Проверяем данные продукта {0}")
    public void assertProductInfo(PRODUCTS product) {
        SelenideElement form = $(byId("mainAnchor"));

        form.$(byText(product.getForm())).shouldBe(exist);
        form.$(byText(product.getDosage())).shouldBe(exist);
        form.$(byText(product.getExpirationDate())).shouldBe(exist);
        form.$(byText(product.getCountry())).shouldBe(exist);
        form.$(byText(product.getPrice())).shouldBe(exist);
    }
}
