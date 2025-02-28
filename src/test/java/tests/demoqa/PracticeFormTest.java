package tests.demoqa;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class PracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "3024x1964";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successfulSearchTest() {

        Faker faker = new Faker();

        String firstName = faker.name().firstName(); // Miss Samanta Schmidt
        String lastName = faker.name().lastName(); // Emory


        String email = "Shteinbah@mail.ru";
        String phoneNumber = "8911456256";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Practice Form"));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__day--013").click();
        $("#subjectsInput").setValue("en").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/cat.jpg");
        $("#currentAddress").setValue("СПБ,ул.Планерная д.2 кв.36");
        $("#state").scrollIntoView(true).click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $(".modal-content").should(appear);
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(
                text(firstName),
                text(lastName),
                text(email),
                text("Female"),
                text(phoneNumber),
                text("13 November,1998"),
                text("English"),
                text("Sports"),
                text("cat.jpg"),
                text("СПБ,ул.Планерная д.2 кв.36"),
                text("NCR Noida")
        );
    }
}
