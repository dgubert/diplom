package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class VacancyPage extends MainPage {

    SelenideElement vacanciesList = $(".vacancies__list"),
            vacanciesSearch = $(".vacancies__search [type=\"search\"]");

    ElementsCollection vacanciesTitle = vacanciesList.$$("h3");

    @Step("Открываем страницу вакансий")
    public VacancyPage openVacancyPage() {
        open("/vacancies/");
        return this;
    }

    @Step("Фильтр вакансий по строке {0}")
    public VacancyPage filterVacanciesByString(String searchString) throws InterruptedException {
        vacanciesSearch.setValue(searchString).pressEnter();
        Thread.sleep(1000);
        return this;
    }

    @Step("Проверяем наличие вакансии {0}")
    public void shoudHaveVacancy(String vacancy) {
        vacanciesList.shouldHave(text(vacancy));
    }

    @Step("Проверяем наличие в отображаемых вакансиях {0}")
    public void shoudHaveStringInVacancies(String str) {
        for (SelenideElement vacancy:
                vacanciesTitle) {
            vacancy.shouldHave(text(str));
        }
    }
}
