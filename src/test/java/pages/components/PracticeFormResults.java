package pages.components;

import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormResults {
    public void verifyModalAppears(){
        $(".modal-content").should(appear);
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
    }
    public void verifyResult(String key, String value){
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }
}
