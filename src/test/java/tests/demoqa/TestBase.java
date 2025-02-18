package tests.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.PracticeFormPage;

public class TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "3024x1964";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
