package tests;

import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.VacancyPage;

@Owner("Denis Gubert")
public class VacancyPageTests extends BaseTest {

    final VacancyPage vacancyPage = new VacancyPage();

    @Owner("Denis Gubert")
    @Test
    @Issue("AUT-1234")
    @DisplayName("Проверка Title на странице Вакансий")
    void shouldHaveVacancyTitle() {
        vacancyPage.openVacancyPage();

        vacancyPage.shouldHaveTitle("Вакансии | Озерки");
    }

    @Owner("Denis Gubert")
    @Issue("AUT-1235")
    @ParameterizedTest(name = "Проверка наличия вакансии {0}")
    @ValueSource(strings = {
            "Консультант в аптеку (Приладожский 23А)",
            "Фармацевт-провизор (Загородный пр-кт, 36)"
    }
    )
    void shouldHaveVacancies(String vacancy) {
        vacancyPage.openVacancyPage();

        vacancyPage.shouldHaveVacancy(vacancy);
    }

    @Owner("Denis Gubert")
    @Issue("AUT-1236")
    @ParameterizedTest(name = "Проверка поиска вакансии по значению {0}")
    @ValueSource(strings = {
            "Приладожский",
            "Пейзажная"
    }
    )
    void shouldHaveVacanciesAfterSearch(String searchString) throws InterruptedException {
        vacancyPage.openVacancyPage()
                .filterVacanciesByString(searchString);

        vacancyPage.shouldHaveStringInVacancies(searchString);
    }
}
