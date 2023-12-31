package ru.ffin.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.ffin.pages.CifraBrokerMainPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Главная страница Цифра брокер")
public class CifraBrokerMainTests extends TestBase {
    CifraBrokerMainPage cifraBrokerMainPage = new CifraBrokerMainPage();

    @ValueSource(strings = {
            "Готовые инвестиционные решения",
            "Широкие возможности для достижения ваших целей",
            "Команда экспертов по фондовому рынку",
            "Новости компании"
    })
    @ParameterizedTest(name = "Проверка заголовка {0} на главной странице")
    @Tags({
            @Tag("main"),
            @Tag("smoke")
    })
    @DisplayName("Отображение основных разделов на Главной странице")
    void checkPrimarySectionsOnMainPage(String section) {
        step("Открыть главную страницу", () -> {
            cifraBrokerMainPage.openCifraBrokerPage();
        });
        step("Проверить наличие заголовка " + section, () -> {
            cifraBrokerMainPage.checkSection(section);
        });
    }

    @ValueSource(strings = {
            "Поле обязательно для заполнения",
            "E-mail введен некорректно. Пример: example@mail.ru",
            "Телефон введен некорректно. Пример: +7 (901) 123-45-67",
            "Чтобы продолжить, необходимо ваше согласие"
    })
    @ParameterizedTest(name = "Поле {0}")
    @Tags({
            @Tag("main"),
            @Tag("smoke")
    })
    @DisplayName("Валидация полей на странице открытия счета")
    void openModalNewAccount(String validation) {
        step("Открыть главную страницу", () -> {
            cifraBrokerMainPage.openCifraBrokerPage();
        });
        step("Перейти к модальному окну \"Откройте счёт\"", () -> {
            cifraBrokerMainPage.openModalNewAccount();
        });
        step("Отправить пустые поля на проверку", () -> {
            cifraBrokerMainPage.submitEmptyInputs();
        });
        step("Проверить наличие валидации " + validation, () -> {
            cifraBrokerMainPage.checkValidationInput(validation);
        });
    }

    @Test
    @Tag("main")
    @DisplayName("Скрытие Cookie Consent Banner")
    void acceptCookieConsent() {
        step("Открыть главную страницу", () -> {
            cifraBrokerMainPage.openCifraBrokerPage();
        });
        step("Проверить наличие Cookie Consent Banner", () -> {
            cifraBrokerMainPage.displayCookieConsent(true);
        });
        step("Согласиться с cookie", () -> {
            cifraBrokerMainPage.acceptCookieConsent();
        });
        step("Проверить отсутствие Cookie Consent Banner", () -> {
            cifraBrokerMainPage.displayCookieConsent(false);
        });
    }

    @CsvSource({
            "Telegram, .icon-telegram-filled, https://t.me/vse_v_cifre",
            "VK, .icon-vkontakte, https://vk.com/cifra.broker",
            "YouTube, .icon-youtube-play, https://www.youtube.com/channel/UCov52Rv9qZTkVu9WERSwccg"
    })
    @ParameterizedTest(name = "{0}")
    @Tag("main")
    @DisplayName("Проверка наличия в футере иконки")
    void checkSocialMedia(String media, String locatorMedia, String urlMedia) {
        step("Открыть главную страницу", () -> {
            cifraBrokerMainPage.openCifraBrokerPage();
        });
        step("Проверить наличие ссылки на кнопке соцсети " + media, () -> {
            cifraBrokerMainPage.checkSocialMedia(locatorMedia, urlMedia);
        });
    }
}
