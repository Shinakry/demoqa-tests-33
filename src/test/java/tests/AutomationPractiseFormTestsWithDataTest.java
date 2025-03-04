package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPractiseFormTestsWithDataTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void allFormTest(){
        String nameStudent = new String("testFirstName");
        String lastNameStudent = new String("testLastName");

        Faker faker = new Faker(new Locale("ru"));

        String name = faker.name().fullName(); // Miss Samanta Schmidt
        String firstName = faker.name().firstName(); // Emory
        String lastName = faker.name().lastName(); // Barton

        String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue(nameStudent);
        $("#lastName").setValue(lastNameStudent);
        $("#userEmail").setValue("testUserEmail@test.ru");
        $(byText("Other")).click();
        $(".mr-sm-2.form-control#userNumber").setValue("8912251475");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("3");
        $(".react-datepicker__year-select").selectOptionByValue("1939");
        $(".react-datepicker__day--012").click();
        $(".subjects-auto-complete__control").click();
        $("#subjectsInput").setValue("m");
        $("#react-select-2-option-1").click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("photo_2024-01-11_13-55-58.jpg");
        $("#currentAddress").setValue("currentAddressTest");
        $("#state").scrollTo().click();
        $("#react-select-3-option-3").click();
        $("#city").click();
        $("#react-select-4-option-0").click();

        $("#submit").click();

        $(".modal-content").shouldHave(text("testFirstName testLastName")).parent().shouldHave(text(nameStudent + (" ") + lastNameStudent));;
        $(".modal-content").shouldHave(text("Student Email")).parent().shouldHave(text("testUserEmail@test.ru"));;
        $(".modal-content").shouldHave(text("Gender")).parent().shouldHave(text("Other"));;
        $(".modal-content").shouldHave(text("Mobile")).parent().shouldHave(text("8912251475"));;
        $(".modal-content").shouldHave(text("Date of Birth")).parent().shouldHave(text("12 April,1939"));;
        $(".modal-content").shouldHave(text("Subjects")).parent().shouldHave(text("Chemistry"));;
        $(".modal-content").shouldHave(text("Hobbies")).parent().shouldHave(text("Sports, Reading, Music"));;
        $(".modal-content").shouldHave(text("Picture")).parent().shouldHave(text("photo_2024-01-11_13-55-58.jpg"));;
        $(".modal-content").shouldHave(text("Address")).parent().shouldHave(text("currentAddressTest"));;
        $(".modal-content").shouldHave(text("State and City")).parent().shouldHave(text("Rajasthan Jaipur"));;
    }
}
