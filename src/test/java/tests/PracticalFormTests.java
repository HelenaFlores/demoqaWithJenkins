package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PracticalFormPage;
import utils.RandomUtils;


public class PracticalFormTests extends TestBase {
    private PracticalFormPage practicalFormPage = new PracticalFormPage();
    private RandomUtils randomUtils = new RandomUtils();

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        practicalFormPage.openPage();
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    @Tag("practicFormTests")
    @Test
    void practicFormWithAllFieldsTest() throws InterruptedException {

        String firstName = randomUtils.getRandomFirstName();
        String lastName = randomUtils.getRandomLastname();
        String userEmail = randomUtils.getRandomEmail();
        String streetAddress = randomUtils.getRandomAddress();
        String phoneUser = randomUtils.getRandomPhone();
        String gender = randomUtils.getRandomGender();
        String hobby = randomUtils.getRandomHobby();
        String subject = randomUtils.getRandomSubject();
        String state = randomUtils.getRandomState();
        String city = randomUtils.getRandomCity(state);
        String month = randomUtils.getRandomMonth();
        String year = randomUtils.getRandomYear();
        String day = randomUtils.getRandomDay();


        practicalFormPage.setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(phoneUser)
                .setBirthDate(day, month, year)
                .setSubject(subject)
                .setHobbies(hobby)
                .uploadPicture("pes2.jpg")
                .setCurrentAddress(streetAddress)
                .setState(state)
                .setCity(city)
                .submitClick();

        practicalFormPage.checkResultForm("Student Name", firstName + " " + lastName)
                .checkResultForm("Gender", gender)
                .checkResultForm("Mobile", phoneUser)
                .checkResultForm("Student Email", userEmail)
                .checkResultForm("Date of Birth", day + " " + month + "," + year)
                .checkResultForm("Subjects", subject)
                .checkResultForm("Hobbies", hobby)
                .checkResultForm("Picture", "pes2.jpg")
                .checkResultForm("Address", streetAddress)
                .checkResultForm("State and City", state + " " + city);
    }

    @Tag("practicFormTests")
    @Test
    void practicFormWitheRequiredFieldsTest() {

        String firstName = randomUtils.getRandomFirstName();
        String lastName = randomUtils.getRandomLastname();
        String phoneUser = randomUtils.getRandomPhone();
        String gender = randomUtils.getRandomGender();

        practicalFormPage.setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phoneUser)
                .submitClick();

        practicalFormPage.checkResultForm("Student Name", firstName + " " + lastName)
                .checkResultForm("Gender", gender)
                .checkResultForm("Mobile", phoneUser);
    }

    @Tag("negative")
    @Test
    void practicFormWithoutFieldsTest() {
        practicalFormPage.submitClick();

        practicalFormPage.presenceOfModalWindow();
    }
}
