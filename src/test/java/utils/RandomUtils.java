package utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    Faker faker = new Faker(new Locale("en-GB"));

    public String getRandomFirstName() {

        return faker.name().firstName();
    }

    public String getRandomLastname() {

        return faker.name().lastName();
    }

    public String getRandomEmail() {

        return faker.internet().emailAddress();
    }

    public String getRandomAddress() {

        return faker.address().streetAddress();
    }

    public String getRandomPhone() {

        return faker.phoneNumber().subscriberNumber(10);

    }

    public String getRandomGender() {

        return faker.options().option("Male", "Female", "Other");
    }

    public String getRandomHobby() {

        return faker.options().option("Sports", "Reading", "Music");
    }

    public String getRandomSubject() {

        return faker.options().option("Hindi",
                "English", "Maths", "Physics", "Chemistry", "Biology",
                "Computer Science", "Commerce", "Accounting", "Economics",
                "Arts", "Social Studies", "History", "Civics");
    }

    public String getRandomState() {

        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public String getRandomCity(String state) {
        return switch (state) {

            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }

    public String getRandomYear() {

        return String.format("%s", faker.number().numberBetween(1900, 2100));
    }

    public String getRandomDay() {

        return String.format("%s", faker.number().numberBetween(10, 28));
    }

    public int getRandomInt(int min, int max) {

        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public String getRandomMonth() {

        return faker.options().option("January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October",
                "November", "December");
    }
}