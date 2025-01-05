package tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.DeliveryPage;
import pages.VacancyPage;

public class DeliveryPageTests extends BaseTest {

    DeliveryPage page = new DeliveryPage();

    @Test
    @Severity(SeverityLevel.MINOR)
    @Issue("AUT-1244")
    @DisplayName("Проверка Title на странице Доставки")
    void shouldHaveDeliveryTitleTest() {
        page.openDeliveryPage();

        page.shoudHaveTitle("Самовывоз и доставка лекарств и товаров для ухода в Москве | Интернет-аптека «Озерки»");
    }

    @Severity(SeverityLevel.NORMAL)
    @Issue("AUT-1245")
    @ParameterizedTest(name = "Отсутствие доставки для адреса {0}")
    @ValueSource( strings = {
            "Мурманск, ул. Аскольдовцев д.38 кв.38",
            "Санкт-Петербург"
    }
    )
    void addressShouldNotHaveDeliveryTest(String address) {
        page.openDeliveryPage();

        page.addressShouldNotHaveDelivery(address);
    }

    @Severity(SeverityLevel.NORMAL)
    @Issue("AUT-1246")
    @ParameterizedTest(name = "Условия доставки для адреса {0}")
    @ValueSource( strings = {
            "Чичеринская улица, д 2",
            "Невский проспект, д 11/2"
    }
    )
    void checkAddressDeliveryConditionsTest(String address) {
        page.openDeliveryPage();

        page.assertAddressDeliveryConditions(address);
    }

    @Severity(SeverityLevel.NORMAL)
    @Issue("AUT-1247")
    @ParameterizedTest(name = "Условия самовывоза из аптеки по адресу {0}")
    @ValueSource( strings = {
            "Гражданский проспект, 114к1",
            "проспект Обуховской Обороны, 229/7"
    }
    )
    void checkPickupConditionsFromPharmacyTest(String address) throws InterruptedException {
        page.openDeliveryPage();

        page.assertPickupConditionsFromPharmacy(address);
    }
}
