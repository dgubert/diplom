package tests;

import api.BasketApiHelper;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.BasketPage;
import pages.PRODUCTS;

public class BasketPageTests extends BaseTest {

    final BasketPage basketPage = new BasketPage();

    @Owner("Denis Gubert")
    @Test
    @Issue("AUT-1344")
    @DisplayName("Проверка Title на странице Корзины")
    void shouldHaveBasketTitleTest() {
        basketPage.openBasketPage();

        basketPage.shouldHaveTitle("Корзина");
    }

    @Owner("Denis Gubert")
    @ParameterizedTest
    @EnumSource(PRODUCTS.class)
    @DisplayName("Проверка информации по товару в корзине")
    void test(PRODUCTS product) {
        basketPage.openBasketPage();
        basketPage.changeCity("Санкт-Петербург");
        BasketApiHelper.addItemToBasketByApi(product.getId(), 1);
        basketPage.openBasketPage();
        basketPage.assertProductInfo(product);

    }
}
