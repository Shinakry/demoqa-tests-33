package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPractiseFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void allFormTest(){
        File uploadFile = new File("src/test/resources/photo_2024-01-11_13-55-58.jpg");

        open("/automation-practice-form");
        $("#firstName").setValue("testFirstName"); //заполнили имя
        $("#lastName").setValue("testLastName"); //заполнили фамилию
        $("#userEmail").setValue("testUserEmail@test.ru"); //заполнили фамилию
        $(byText("Other")).click();
        $(".mr-sm-2.form-control#userNumber").setValue("8912251475");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("3");
        $(".react-datepicker__year-select").selectOptionByValue("1939");
        $(".react-datepicker__day--012").click();
        $(".subjects-auto-complete__control").click();
        $("#subjectsInput").setValue("m");
        $("#react-select-2-option-1").click();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(uploadFile);
        $("#currentAddress").setValue("currentAddressTest");
        $("#state").scrollTo().click();
    }
}
