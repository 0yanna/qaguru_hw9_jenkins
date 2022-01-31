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
    //SelenideElement uploadFile = $("#uploadPicture");
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

    public RegistrationPages typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPages typeLastName (String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPages typeEmail (String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPages typeGenterWrapper () {
        genterWrapperInput.$(byText("Male")).click();
        return this;
    }
    public RegistrationPages typeuserNumber (String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationPages setDate(String day, String month, String year) {
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPages subjectsContainer (String value) {
        subjectsContainerInput.click();
        subjectsContainerInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPages hobbiesWrapper (String value) {
        hobbiesWrapperInput.$(byText(value)).click();
        return this;
    }
    //public RegistrationPages addFile () {
    //    File file = new File("src/test/resources/img/pic.png");
    //    uploadFile.uploadFile(file);
    //    return this;
    //}
    public RegistrationPages currentAddress (String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    public RegistrationPages state (String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPages stateCity (String value) {
        stateCityInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPages typeSubmitButton() {
        submitButton.click();
        return this;
    }
    public RegistrationPages checkResultRegistrationForm() {
        resultRegistrationForm.should(visible);
        return this;
    }
    public RegistrationPages checkResultsValue(String key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }
}