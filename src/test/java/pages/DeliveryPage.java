package pages;

import com.codeborne.selenide.LocalStorage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static asserts.AssertText.assertExistByParentTextAndText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DeliveryPage extends MainPage {
    final SelenideElement txtAddress = $("#addressID");
    final SelenideElement btnCheckAddress = $(byText("Проверить"));
    final SelenideElement btnChoosePharmacy = $("[href='/samovyvoz-i-dostavka/pickup/']");

    @Step("Открываем страницу доставки")
    public void openDeliveryPage() {
        open("/samovyvoz-i-dostavka/");

        LocalStorage localStorage = localStorage();
        localStorage.setItem("ux_city", "Санкт-Петербург");
    }

    @Step("Проверяем недоступность доставки по адресу {0}")
    public void addressShouldNotHaveDelivery(String address) {
        txtAddress.setValue(address);
        btnCheckAddress.click();
        $(byText("Курьерская доставка")).shouldNotBe(exist);
    }

    @Step("Проверяем условия доставки по адресу {0}")
    public void assertAddressDeliveryConditions(String address) {
        txtAddress.setValue(address);
        $(".CUgKW").$(byText(address)).click();
        btnCheckAddress.click();
        $(byTagAndText("h2", "Курьерская доставка")).shouldBe(exist);
        assertExistByParentTextAndText("Оплата", "Картой на сайте");
        assertExistByParentTextAndText("Прием заказов", "Круглосуточно");
        assertExistByParentTextAndText("Максимальный вес", "до 5 кг");
        assertExistByParentTextAndText("Интервалы доставки", "Ежедневно с 10:00 до 20:00");
    }

    @Step("Проверяем условия самовывоза по адресу {0}")
    public void assertPickupConditionsFromPharmacy(String address) {
        btnChoosePharmacy.click();
        $(byText(address)).click();

        $(".input").shouldHave(value(address));
        $(byTagAndText("h2", "Самовывоз из аптеки")).shouldBe(exist);
        assertExistByParentTextAndText("Стоимость", "Бесплатно");
        assertExistByParentTextAndText("Оплата", "Картой на сайте");
        assertExistByParentTextAndText("Оплата", "Картой или наличными в аптеке");
        assertExistByParentTextAndText("Хранение заказов", "до 3-х дней");
        assertExistByParentTextAndText("Хранение заказов", "Возможно продление");
        assertExistByParentTextAndText("Рецептурные препараты", "Предъявите рецепт в аптеке");
        assertExistByParentTextAndText("Время сборки заказов", "до 30 минут");
        assertExistByParentTextAndText("Самовывоз заказов", "8:00-22:00");
        assertExistByParentTextAndText("Самовывоз заказов", "00:00-23:00");
    }
}
