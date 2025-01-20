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
        $(byText("Other")).click(); //пол
        $(".mr-sm-2.form-control#userNumber").setValue("8912251475"); //номер телефона
        $("#dateOfBirthInput").click(); //дата рождения
        $(".react-datepicker__month-select").selectOptionByValue("3"); //выбор месяца для др
        $(".react-datepicker__year-select").selectOptionByValue("1939"); //выбор года для др
        $(".react-datepicker__day--012").click(); //выбор даты для др
        $(".subjects-auto-complete__control").click(); //выбор предметов
        $("#subjectsInput").setValue("m"); //символ/слово, которое вводим
        $("#react-select-2-option-1").click(); //порядковый номер предмета, который выбираем
        $(byText("Sports")).click(); //выбор хобби
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(uploadFile); //загрузка картинки
        $("#currentAddress").setValue("currentAddressTest"); //заполнение формы с адресом
        $("#state").scrollTo().click(); //скролл до элемента Штат и клик
        $("#react-select-3-option-3").click(); //порядковый номер из выподающего списка по штатам
        $("#city").click(); //раскрытие списка по городам
        $("#react-select-4-option-0").click(); //выбор города из выпадающего списка


    }
}
