package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticalFormPage {

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement calendarInput = $("#dateOfBirthInput");
    private final SelenideElement subjectInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private final SelenideElement uploadPictureButton = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement stateInput = $("#react-select-3-input");
    private final SelenideElement cityInput = $("#react-select-4-input");
    private final SelenideElement submitButton = $("#submit");
    private static final SelenideElement modalWindow = $(".modal-content");

    CalendarComponent calendarComponent = new CalendarComponent();

    CheckResultComponent checkResultComponent = new CheckResultComponent();

    @Step("Open registration page /automation-practice-form")
    public PracticalFormPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    @Step("Type first name \"{value}\"")
    public PracticalFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Type last name \"{value}\"")
    public PracticalFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Type email \"{value}\"")
    public PracticalFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Choosing a gender \"{value}\"")
    public PracticalFormPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Type number \"{value}\"")
    public PracticalFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Setting the date \"{day}\" \"{month}\" \"{year}\"")
    public PracticalFormPage setBirthDate(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Choosing a subject \"{value}\"")
    public PracticalFormPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Choosing a hobby \"{value}\"")
    public PracticalFormPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Uploading picture \"{value}\"")
    public PracticalFormPage uploadPicture(String value) {
        uploadPictureButton.uploadFromClasspath(value);

        return this;
    }

    @Step("Type address \"{value}\"")
    public PracticalFormPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    @Step("Type state \"{value}\"")
    public PracticalFormPage setState(String value) {
        stateInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Type city \"{value}\"")
    public PracticalFormPage setCity(String value) throws InterruptedException {
        cityInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Form confirmation")
    public PracticalFormPage submitClick() {
        submitButton.click();

        return this;
    }

    @Step("Check that field \"{key}\" has result \"{value}\"")
    public PracticalFormPage checkResultForm(String key, String value) {
        checkResultComponent.checkResult(key, value);

        return this;
    }

    @Step("Check presence of a modal window")
    public PracticalFormPage presenceOfModalWindow() {
        modalWindow.should(disappear);

        return this;
    }
}