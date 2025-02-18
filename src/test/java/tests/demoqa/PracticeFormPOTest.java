package tests.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormPOTest extends TestBase {

    @Test
    void successfulSearchTest() {
        String firstName = "Viktoria";
        String lastName = "Shteinbah";
        String email = "Shteinbah@mail.ru";
        String phoneNumber = "8911456256";

        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender("Female")
                .setPhone(phoneNumber)
                .setBirthDate("13", "November", "1998")
                .setSubjects("en")
                .setHobbies("Sports")
                .setPicture("img/cat.jpg")
                .setAddress("СПБ,ул.Планерная д.2 кв.36")
                .setStateAndCity("NCR","Noida")
                .selectSubmit();



        practiceFormPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", "Female")
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", "13 November,1998")
                .verifyResult("Subjects", "English")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "cat.jpg")
                .verifyResult("Address", "СПБ,ул.Планерная д.2 кв.36")
                .verifyResult("State and City", "NCR Noida");
    }
}
