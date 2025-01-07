package tests;

import api.BasketApiHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.GOODS;
import pages.GoodInfoPage;

public class GoodInfoPageTests extends BaseTest {

    GoodInfoPage goodInfoPage = new GoodInfoPage();

    @ParameterizedTest
    @EnumSource(GOODS.class)
    @DisplayName("Проверка информации по товару на странице товара {0}")
    void test(GOODS good) {
        goodInfoPage.openGoodInfoPage(good.getLink());

        goodInfoPage.assertGoodInfo(good);

    }
}