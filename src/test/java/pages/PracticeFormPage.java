package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.PracticeFormResults;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PracticeFormPage {
    private final String TITLE_TEXT = "Practice Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private PracticeFormResults practiceFormResults = new PracticeFormResults();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            phoneInput = $("#userNumber");
    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    public PracticeFormPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }
    public PracticeFormPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }
    public PracticeFormPage setEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }
    public PracticeFormPage setGender(String value){
        genderInput.$(byText(value)).click();

        return this;
    }
    public PracticeFormPage setPhone(String value){
        phoneInput.setValue(value);

        return this;
    }
    public PracticeFormPage setBirthDate(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    public PracticeFormPage setSubjects(String value){
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }
    public PracticeFormPage setHobbies(String value){
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }
    public PracticeFormPage setPicture(String value){
        $("#uploadPicture").uploadFromClasspath(value);

        return this;
    }
    public PracticeFormPage setAddress(String value){
        $("#currentAddress").setValue(value);

        return this;
    }
    public PracticeFormPage setStateAndCity(String state, String city ){
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        return this;
    }
    public PracticeFormPage selectSubmit(){
        $("#submit").click();

        return this;
    }







    public PracticeFormPage verifyResultsModalAppears(){
        practiceFormResults.verifyModalAppears();

        return this;
    }
    public PracticeFormPage verifyResult(String key, String value){
        practiceFormResults.verifyResult(key, value);

        return this;
    }
}
