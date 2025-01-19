package asserts;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AssertText {
    @Step("Проверяем наличие текста {1} в блоке {2}")
    public static void assertExistByParentTextAndText(String parent, String text) {
        $(byText(parent)).parent().$(byText(text)).should(exist);
    }
}
