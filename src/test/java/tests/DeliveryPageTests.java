package tests;

import io.qameta.allure.Issue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.DeliveryPage;
import pages.MainPage;

public class DeliveryPageTests extends BaseTest {

    DeliveryPage deliveryPage = new DeliveryPage();
    MainPage mainPage = new MainPage();

    @Test
    @Issue("AUT-1244")
    @DisplayName("Проверка Title на странице Доставки")
    void shouldHaveDeliveryTitleTest() {
        deliveryPage.openDeliveryPage();

        deliveryPage.shoudHaveTitle("Самовывоз и доставка лекарств и товаров для ухода в Москве | Интернет-аптека «Озерки»");
    }

    @Issue("AUT-1245")
    @ParameterizedTest(name = "Отсутствие доставки для адреса {0}")
    @ValueSource( strings = {
            "Мурманск, ул. Аскольдовцев д.38 кв.38",
            "Санкт-Петербург"
    }
    )
    void addressShouldNotHaveDeliveryTest(String address) {
        deliveryPage.openDeliveryPage();
        mainPage.changeCity("Санкт-Петербург");
        deliveryPage.addressShouldNotHaveDelivery(address);
    }

    @Issue("AUT-1246")
    @ParameterizedTest(name = "Условия доставки для адреса {0}")
    @ValueSource( strings = {
            "Чичеринская улица, д 2",
            "Невский проспект, д 11/2"
    }
    )
    void checkAddressDeliveryConditionsTest(String address) {
        deliveryPage.openDeliveryPage();
        mainPage.changeCity("Санкт-Петербург");
        deliveryPage.assertAddressDeliveryConditions(address);
    }

    @Issue("AUT-1247")
    @ParameterizedTest(name = "Условия самовывоза из аптеки по адресу {0}")
    @ValueSource( strings = {
            "Гражданский проспект, 114к1",
            "проспект Обуховской Обороны, 229/7"
    }
    )
    void checkPickupConditionsFromPharmacyTest(String address) throws InterruptedException {
        deliveryPage.openDeliveryPage();
        mainPage.changeCity("Санкт-Петербург");
        deliveryPage.assertPickupConditionsFromPharmacy(address);
    }
}
