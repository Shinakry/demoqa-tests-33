package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import com.github.javafaker.Faker;
import utils.RandomUtil;

import java.util.Locale;

public class AutomationPractiseFormGenerateData {

    @BeforeAll
    static void configBrowserBeforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = false;
    }

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker(new Locale("en"));
    String firstName, lastName, email, gender,
            userNumber, dayOfBirth, monthOfBirth, yearOfBirth,
            subjects, hobbies, pictures,
            currentAddress, state, city;

    @Test
    void fullFieldsFillerTest() {

        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = faker.internet().safeEmailAddress();
        userNumber = faker.phoneNumber().subscriberNumber(10);
        currentAddress = faker.address().fullAddress();


        dayOfBirth = RandomUtil.getRandomDay();
        monthOfBirth = RandomUtil.getRandomMonth();
        yearOfBirth = RandomUtil.getRandomYear();
        gender = RandomUtil.getRandomGender();
        hobbies = RandomUtil.getRandomHobbie();

        subjects = "Math";
        pictures = "photo_2024-01-11_13-55-58.jpg";
        state = "NCR";
        city = "Delhi";


        registrationPage.openPage()
                .removeAdBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(pictures)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city);

        registrationPage.submitButtonClick();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", pictures)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void minFormTest() {

        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userNumber = faker.phoneNumber().subscriberNumber(10);

        gender = RandomUtil.getRandomGender();

        registrationPage.openPage()
                .removeAdBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber);

        registrationPage.submitButtonClick();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber);

    }

    @Test
    void negativeEmptyFormTest() {
        registrationPage.openPage()
                .removeAdBanner()
                .submitButtonClick()
                .userFormValidate();
    }
}
