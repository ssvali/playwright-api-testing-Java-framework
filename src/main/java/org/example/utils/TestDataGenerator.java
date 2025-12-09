package org.example.utils;

import io.qameta.allure.Step;
import net.datafaker.Faker;
import org.example.models.BookingDates;
import org.example.models.BookingRequest;

import java.time.LocalDate;

public class TestDataGenerator {

    private static final Faker faker = new Faker();

    @Step("Generate booking data")
    public static BookingRequest generateBookingData() {

        LocalDate checkin = LocalDate.now().plusDays(faker.number().numberBetween(1, 10));
        LocalDate checkout = checkin.plusDays(faker.number().numberBetween(1, 7));

        return new BookingRequest(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.number().numberBetween(50, 500),
                faker.random().nextBoolean(),
                new BookingDates(checkin.toString(), checkout.toString()),
                faker.options().option("Breakfast", "Lunch", "Dinner", "None")
        );
    }

}
