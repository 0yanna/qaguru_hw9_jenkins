package rambler.xx45x.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import rambler.xx45x.helper.Attach;

import static io.qameta.allure.Allure.step;

public class TextBoxTestWithPageObjects {

    RegistrationPages registrationPages = new RegistrationPages();

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1152";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        //конфигурируем удаленный запуск
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }
    @DisplayName("Homework#5")
    @Test
    void automationPracticeForm () {
        step("Открываем страницу", () -> {
        registrationPages.openPage();
        });
        step("Вводим фамилию и имя", () -> {
        registrationPages.typeFirstName("Alex")
                .typeLastName("Smith");
        });
        step("Вводим личные данные и адрес", () -> {
        registrationPages.typeEmail("xx@mail.ru")
                .typeGenterWrapper()
                .typeuserNumber("9110000000")
                .setDate("31", "January", "1990" )
                .subjectsContainer("Maths")
                .hobbiesWrapper("Sports")
                //.addFile()
                .currentAddress("Some address")
                .state("Haryana")
                .stateCity("Karnal");
        });
        step("Нажимаем сохранить", () -> {
        registrationPages.typeSubmitButton();
        });
        step("Проверяем введенные данные", () -> {
        registrationPages.checkResultRegistrationForm()
                .checkResultsValue("Student Name", "Alex Smith")
                .checkResultsValue("Student Email", "xx@mail.ru")
                .checkResultsValue("Gender", "Male")
                .checkResultsValue("Mobile", "9110000000")
                .checkResultsValue("Date of Birth","31 January,1990")
                .checkResultsValue("Subjects", "Maths")
                .checkResultsValue("Hobbies", "Sports")
                //.checkResultsValue("Picture", "pic.png")
                .checkResultsValue("Address", "Some address")
                .checkResultsValue("State and City", "Haryana Karnal");
        });
    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
