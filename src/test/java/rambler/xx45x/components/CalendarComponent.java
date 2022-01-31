package rambler.xx45x.components;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $( "#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1990");
        String dayLocator = format(".react-datepicker__day--031:not(.react-datepicker__day--outside-month)", day);
        $(dayLocator).click();

    }
}