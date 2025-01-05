package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static asserts.AssertText.assertExistByParentTextAndText;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import static asserts.AssertText.*;
import static com.codeborne.selenide.WebDriverRunner.driver;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.equalTo;

public class DeliveryPage {
    SelenideElement txtAddress = $("#addressID"),
            btnCheckAddress = $(byText("Проверить")),
            btnChoosePharmacy = $("[href='/samovyvoz-i-dostavka/pickup/']");

    @Step("Открываем страницу доставки")
    public DeliveryPage openDeliveryPage() {
        open("/samovyvoz-i-dostavka/");
        return this;
    }

    @Step("Проверяем Title страницы на соответствие {0}")
    public void shoudHaveTitle(String title) {
        Assertions.assertEquals(title(), title);
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
        assertExistByParentTextAndText("Оплата","Картой на сайте");
        assertExistByParentTextAndText("Прием заказов","Круглосуточно");
        assertExistByParentTextAndText("Максимальный вес","до 5 кг");
        assertExistByParentTextAndText("Интервалы доставки","Ежедневно с 10:00 до 20:00");
    }

    @Step("Выбираем аптеку {0} для самовывоза")
    public void choosePharmacyForPickup(String pharmacyAddress) {

    }

    @Step("Проверяем условия самовывоза по адресу {0}")
    public void assertPickupConditionsFromPharmacy(String address) throws InterruptedException {
        btnChoosePharmacy.click();
        $(byText(address)).click();

        $(".input").shouldHave(value(address));
        $(byTagAndText("h2", "Самовывоз из аптеки")).shouldBe(exist);
        assertExistByParentTextAndText("Стоимость", "Бесплатно");
        assertExistByParentTextAndText("Оплата","Картой на сайте");
        assertExistByParentTextAndText("Оплата","Картой или наличными в аптеке");
        assertExistByParentTextAndText("Хранение заказов","до 3-х дней");
        assertExistByParentTextAndText("Хранение заказов","Возможно продление");
        assertExistByParentTextAndText("Рецептурные препараты","Предъявите рецепт в аптеке");
        assertExistByParentTextAndText("Время сборки заказов","до 30 минут");
        assertExistByParentTextAndText("Самовывоз заказов","8:00-22:00");
        assertExistByParentTextAndText("Самовывоз заказов","00:00-23:00");
    }
}
