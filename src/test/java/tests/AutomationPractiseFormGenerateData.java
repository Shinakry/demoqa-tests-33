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
    static void openBrowserBeforeAll() {
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
    void allFormTest(){

        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = faker.internet().safeEmailAddress();
        userNumber = faker.phoneNumber().subscriberNumber(10);
        currentAddress = faker.address().fullAddress();


        dayOfBirth = RandomUtil.getRandomDay();
        monthOfBirth = RandomUtil.getRandomMonth();
        yearOfBirth = RandomUtil.getRandomYear();

        registrationPage.openPage()
            .setFirstName(firstName)
            .setLastName(lastName)
            .setEmail(email)
            .setGender("Other")
            .setUserNumber(userNumber)
            .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
            .setSubjects("Math")
            .setHobbies("Sports")
            .setPicture("photo_2024-01-11_13-55-58.jpg")
            .setCurrentAddress(currentAddress)
            .setStateAndCity("NCR", "Delhi");

        registrationPage.submitButtonClick();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                        .checkResult("Student Email", email)
                        .checkResult("Gender", "Other")
                        .checkResult("Mobile", userNumber)
                        .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                        .checkResult("Subjects", "Math")
                        .checkResult("Hobbies", "Sports")
                        .checkResult("Picture", "photo_2024-01-11_13-55-58.jpg")
                        .checkResult("Address", currentAddress)
                        .checkResult("State and City", "NCR Delhi");
    }

    @Test
    void minFormTest() {

        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Pampushkin")
                .setGender("Other")
                .setUserNumber("8912251475");

        registrationPage.submitButtonClick();

        registrationPage.checkResult("Student Name", "Alex Pampushkin")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "8912251475");

    }

    @Test
    void negativeEmptyFormTest(){
        registrationPage.openPage()
                .submitButtonClick()
                .userFormValidate();
    }
}
