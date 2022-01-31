package rambler.xx45x.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TextBoxTestWithPageObjects {

    RegistrationPages registrationPages = new RegistrationPages();

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1152";
    }
    @DisplayName("Homework#5")
    @Test
    void automationPracticeForm () {
        registrationPages.openPage();
        registrationPages.typeFirstName("Alex")
                .typeLastName("Smith")
                .typeEmail("xx@mail.ru")
                .typeGenterWrapper()
                .typeuserNumber("9110000000")
                .setDate("31", "January", "1990" )
                .subjectsContainer("Maths")
                .hobbiesWrapper("Sports")
                .addFile()
                .currentAddress("Some address")
                .state("Haryana")
                .stateCity("Karnal")
                .typeSubmitButton()
                .checkResultRegistrationForm()
                .checkResultsValue("Student Name", "Alex Smith")
                .checkResultsValue("Student Email", "xx@mail.ru")
                .checkResultsValue("Gender", "Male")
                .checkResultsValue("Mobile", "9110000000")
                .checkResultsValue("Date of Birth","31 January,1990")
                .checkResultsValue("Subjects", "Maths")
                .checkResultsValue("Hobbies", "Sports")
                .checkResultsValue("Picture", "pic.png")
                .checkResultsValue("Address", "Some address")
                .checkResultsValue("State and City", "Haryana Karnal");
    }
}
