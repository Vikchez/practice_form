package tests.demoqa;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    private Faker faker = new Faker(new Locale("en"));;
    private String firstName = faker.name().firstName(); //
    private String lastName = faker.name().lastName(); //
    private String email = faker.internet().emailAddress();

   private String streetAddress = faker.address().streetAddress();
   private String phoneNumber = faker.number().digits(10);

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
