package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genterWrapper = $("#genterWrapper"),
            userNumberInput = $(".mr-sm-2.form-control#userNumber"),
            calendarComponentChoose = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit"),
            userFormInput = $("#userForm");

    CalendarComponent calendarComponent = new CalendarComponent();


    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage removeAdBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genterWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarComponentChoose.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String hobby) {
        hobbiesInput.$(byText(hobby)).click();

        return this;
    }

    public RegistrationPage setPicture(String path) {
        pictureInput.uploadFromClasspath(path);

        return this;
    }

    public RegistrationPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);

        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateInput.scrollTo().click();
        stateInput.$(byText(state)).click();
        cityInput.click();
        cityInput.$(byText(city)).click();

        return this;
    }

    public RegistrationPage submitButtonClick() {
        submitButton.click();

        return this;
    }

    public RegistrationPage userFormValidate() {
        userFormInput.shouldHave(attribute("class", "was-validated"));

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        $(".modal-content").shouldHave(text(key)).parent()
                .shouldHave(text(value));

        return this;
    }
}
