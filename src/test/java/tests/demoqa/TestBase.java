package tests.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.PracticeFormPage;

public class TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    TestData testData;
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "3024x1964";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @BeforeEach
    void beforeEach(){
       testData = new TestData();
    }
}
