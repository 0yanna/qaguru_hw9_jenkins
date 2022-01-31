package rambler.xx45x.test;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import rambler.xx45x.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPages {
    private final SelenideElement
                    firstNameInput = $( "#firstName");
    SelenideElement lastNameInput = $( "#lastName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement genterWrapperInput = $("#genterWrapper");
    SelenideElement userNumberInput = $("#userNumber");
    SelenideElement subjectsContainerInput = $("#subjectsInput");
    SelenideElement hobbiesWrapperInput = $("#hobbiesWrapper");
    SelenideElement uploadFile = $("#uploadPicture");
    SelenideElement currentAddressInput = $("#currentAddress");
    SelenideElement stateInput = $("#react-select-3-input");
    SelenideElement stateCityInput = $("#react-select-4-input");
    SelenideElement submitButton = $("#submit");
    SelenideElement resultRegistrationForm = $(".table-responsive");
    SelenideElement resultsTable = $(".table-responsive");

    //@Step("Открываем страницу и проверяем что она содержит значение")
    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    private final CalendarComponent calendarComponent = new CalendarComponent();

    //@Step("Вводим имя")
    public RegistrationPages typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    //@Step("Вводим фамилию")
    public RegistrationPages typeLastName (String value) {
        lastNameInput.setValue(value);
        return this;
    }
    //@Step("Вводим Email")
    public RegistrationPages typeEmail (String value) {
        userEmailInput.setValue(value);
        return this;
    }
    //@Step("Вводим пол")
    public RegistrationPages typeGenterWrapper () {
        genterWrapperInput.$(byText("Male")).click();
        return this;
    }
    //@Step("Вводим номер телефона")
    public RegistrationPages typeuserNumber (String value) {
        userNumberInput.setValue(value);
        return this;
    }
    //@Step("Вводим дату рождения")
    public RegistrationPages setDate(String day, String month, String year) {
        calendarComponent.setDate(day, month, year);
        return this;
    }
    //@Step("Ввыбираем предмет")
    public RegistrationPages subjectsContainer (String value) {
        subjectsContainerInput.click();
        subjectsContainerInput.setValue(value).pressEnter();
        return this;
    }
    //@Step("Указываем хобби")
    public RegistrationPages hobbiesWrapper (String value) {
        hobbiesWrapperInput.$(byText(value)).click();
        return this;
    }
    //@Step("Загружаем файл")
    public RegistrationPages addFile () {
        File file = new File("src/test/resources/img/pic.png");
        uploadFile.uploadFile(file);
        return this;
    }
    //@Step("Вводим адрес")
    public RegistrationPages currentAddress (String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    //@Step("Указываем штат")
    public RegistrationPages state (String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }
    //@Step("Указываем город")
    public RegistrationPages stateCity (String value) {
        stateCityInput.setValue(value).pressEnter();
        return this;
    }
    //@Step("Нажимаем submit")
    public RegistrationPages typeSubmitButton() {
        submitButton.click();
        return this;
    }
    //@Step("Проверяем, что заполненная форма отображается")
    public RegistrationPages checkResultRegistrationForm() {
        resultRegistrationForm.should(visible);
        return this;
    }
    //@Step("Проверяем введенные данные")
    public RegistrationPages checkResultsValue(String key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }
}