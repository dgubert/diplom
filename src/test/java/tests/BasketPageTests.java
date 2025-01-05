package tests;

import api.BasketApiHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.BasketPage;
import pages.GOODS;

public class BasketPageTests extends BaseTest {

    BasketPage basketPage = new BasketPage();

    @ParameterizedTest
    @EnumSource(GOODS.class)
    @DisplayName("Проверка информации по товару в корзине")
    void test(GOODS good) {
        basketPage.openBasketPage();

        BasketApiHelper.addItemToBasketByApi(good.getId(), 1);
        basketPage.openBasketPage();
        basketPage.checkGoodInfo(good);

    }
}
