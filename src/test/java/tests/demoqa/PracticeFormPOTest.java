package tests.demoqa;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormPOTest extends TestBase {

    @Test
    void successfulSearchTest() {

        practiceFormPage.openPage()
                .setFirstName(testData.getFirstName())
                .setLastName(testData.getLastName())
                .setEmail(testData.getEmail())
                .setGender("Female")
                .setPhone(testData.getPhoneNumber())
                .setBirthDate("13", "November", "1998")
                .setSubjects("en")
                .setHobbies("Sports")
                .setPicture("img/cat.jpg")
                .setAddress(testData.getStreetAddress())
                .setStateAndCity("NCR","Noida")
                .selectSubmit();



        practiceFormPage.verifyResultsModalAppears()
                .verifyResult("Student Name", testData.getFirstName() + " " + testData.getLastName())
                .verifyResult("Student Email", testData.getEmail())
                .verifyResult("Gender", "Female")
                .verifyResult("Mobile", testData.getPhoneNumber())
                .verifyResult("Date of Birth", "13 November,1998")
                .verifyResult("Subjects", "English")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "cat.jpg")
                .verifyResult("Address", testData.getStreetAddress())
                .verifyResult("State and City", "NCR Noida");
    }
}
