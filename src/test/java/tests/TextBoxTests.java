package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Shinkary");
        $("#userEmail").setValue("test@test.ru");
        $("#currentAddress").setValue("Current Address");
        $("#permanentAddress").setValue("Permanent Address");
        $("#submit").click();

        $("#output #name").shouldHave(text("Shinkary"));
        $("#output #email").shouldHave(text("test@test.ru"));
        $("#output #currentAddress").shouldHave(text("Current Address"));
        $("#output #permanentAddress").shouldHave(text("Permanent Address"));

    }
}