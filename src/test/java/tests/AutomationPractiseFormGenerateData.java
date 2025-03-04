package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class AutomationPractiseFormGenerateData {

    @BeforeAll
    static void openBrowserBeforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = false;
    }

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void allFormTest(){

        registrationPage.openPage()
            .setFirstName("Alex")
            .setLastName("Pampushkin")
            .setEmail("test@test.ru")
            .setGender("Other")
            .setUserNumber("8912251475")
            .setDateOfBirth("12", "July", "1939")
            .setSubjects("Math")
            .setHobbies("Sports")
            .setPicture("photo_2024-01-11_13-55-58.jpg")
            .setCurrentAddress("currentAddressTest")
            .setStateAndCity("NCR", "Delhi");

        registrationPage.submitButtonClick();

        registrationPage.checkResult("Student Name", "Alex Pampushkin")
                        .checkResult("Student Email", "test@test.ru")
                        .checkResult("Gender", "Other")
                        .checkResult("Mobile", "8912251475")
                        .checkResult("Date of Birth", "12 July,1939")
                        .checkResult("Subjects", "Math")
                        .checkResult("Hobbies", "Sports")
                        .checkResult("Picture", "photo_2024-01-11_13-55-58.jpg")
                        .checkResult("Address", "currentAddressTest")
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
