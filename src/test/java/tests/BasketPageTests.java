package tests;

import api.BasketApiHelper;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.BasketPage;
import pages.GOODS;

public class BasketPageTests extends BaseTest {

    BasketPage basketPage = new BasketPage();

    @Owner("Denis Gubert")
    @Test
    @Issue("AUT-1344")
    @DisplayName("Проверка Title на странице Корзины")
    void shouldHaveBasketTitleTest() {
        basketPage.openBasketPage();

        basketPage.shoudHaveTitle("Корзина");
    }

    @Owner("Denis Gubert")
    @ParameterizedTest
    @EnumSource(GOODS.class)
    @DisplayName("Проверка информации по товару в корзине")
    void test(GOODS good) {
        basketPage.openBasketPage();
        basketPage.changeCity("Санкт-Петербург");
        BasketApiHelper.addItemToBasketByApi(good.getId(), 1);
        basketPage.openBasketPage();
        basketPage.assertGoodInfo(good);

    }
}
