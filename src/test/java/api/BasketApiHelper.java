package api;

import io.qameta.allure.Step;
import models.AddItemToBasketRequestModel;
import models.AddItemToBasketResponseModel;
import models.ItemJsonRequestModel;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import static specs.RequestSpec.requestSpec;
import static specs.ResponseSpec.response200Spec;

public class BasketApiHelper {

    public static int regionId = 27;
    public String cartId;

    public static String getCartId() {

        Cookie cookie = getWebDriver().manage().getCookieNamed("cartId");

        if (cookie == null) {
            refresh();

            cookie = getWebDriver().manage().getCookieNamed("cartId");
        }

        return cookie.getValue();

    }
    @Step("Добавление товара {0} в корзину")
    public static AddItemToBasketResponseModel addItemToBasketByApi(int goodId, int quantity) {
        BasketApiHelper basketApiHelper = new BasketApiHelper();

        basketApiHelper.cartId = getCartId();

        ItemJsonRequestModel item = new ItemJsonRequestModel();
        item.setGoodsId(goodId);
        item.setQuantity(quantity);

        ItemJsonRequestModel[] items = {item};


        AddItemToBasketRequestModel requestModel = new AddItemToBasketRequestModel();
        requestModel.setCartId(basketApiHelper.cartId);
        requestModel.setRegionId(regionId);
        requestModel.setItems(items);


        return given(requestSpec)
                .body(requestModel)
            .when()
                .post("/api/basket/current/items/add")
            .then()
                .spec(response200Spec)
                .extract().response().as(AddItemToBasketResponseModel.class);
    }

    @Step("Удаление товара {0} из корзины")
    void deleteItemFromBasketByApi(int item) {

    }
}
