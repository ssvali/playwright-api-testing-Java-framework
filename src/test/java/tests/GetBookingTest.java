package tests;

import org.example.api.BookingApi;
import org.example.utils.SchemaValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class GetBookingTest extends BaseTest{
    Logger logger = Logger.getLogger(GetBookingTest.class.getName());
    @Test(groups = {"booking", "regression"})
    void testGetBooking() throws Exception {
        BookingApi api = new BookingApi();
        String response = api.getBooking(1);
        SchemaValidator.validate(response, "schemas/booking_schema.json");
        Assert.assertTrue(response.contains("firstname"), "Firstname field missing in response");
    }

    @Test(groups = {"booking", "regression"})
    void testGetNonExistentBooking() {
        BookingApi api = new BookingApi();
        int nonExistentBookingId = 99999;
        String response = api.getBooking(nonExistentBookingId);
        logger.info("Response for non-existent booking ID" + response);
        Assert.assertTrue(response.isEmpty(), "Response should be empty for non-existent booking");
    }
}

