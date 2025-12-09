package tests;

import org.example.api.BookingApi;
import org.example.models.BookingRequest;
import org.example.utils.TestDataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class CreateBookingTest extends BaseTest {

    Logger logger = Logger.getLogger(CreateBookingTest.class.getName());
    @Test(groups = {"booking", "smoke"," regression"})
    public void testCreateBooking() {
        logger.info("Starting testCreateBooking test case");
        BookingApi api = new BookingApi();
        BookingRequest payload = TestDataGenerator.generateBookingData();
        int bookingId = api.createBooking(payload);
        Assert.assertTrue(bookingId > 0, "Booking ID should be greater than zero");
    }

    @Test(groups = {"booking"," regression"})
    void testCreateMultipleBookings() {
        logger.info("Starting testCreateMultipleBookings test case");
        BookingApi api = new BookingApi();
        for (int i = 0; i < 5; i++) {
            BookingRequest payload = TestDataGenerator.generateBookingData();
            int bookingId = api.createBooking(payload);
            Assert.assertTrue(bookingId > 0, "Booking ID should be greater than zero for booking " + (i + 1));
        }
    }

    @Test(groups = {"booking"," regression"})
    void testCreateBookingWithInvalidData() {
        logger.info("Starting testCreateBookingWithInvalidData test case");
        BookingApi api = new BookingApi();
        BookingRequest payload = TestDataGenerator.generateBookingData();
        payload.setTotalprice(-100); // Invalid total price
        try {
            int bookingId = api.createBooking(payload);
            Assert.fail("Booking creation should have failed with invalid data");
        } catch (Exception e) {
            Assert.assertTrue(true, "Booking creation failed as expected with invalid data");
        }
    }
}
