package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.PRODUCTS;
import pages.ProductInfoPage;

public class ProductInfoPageTests extends BaseTest {

    final ProductInfoPage productInfoPage = new ProductInfoPage();

    @Owner("Denis Gubert")
    @ParameterizedTest
    @EnumSource(PRODUCTS.class)
    @DisplayName("Проверка информации по товару на странице товара {0}")
    void test(PRODUCTS product) {
        productInfoPage.openProductInfoPage(product.getLink());

        productInfoPage.assertProductInfo(product);

    }
}
