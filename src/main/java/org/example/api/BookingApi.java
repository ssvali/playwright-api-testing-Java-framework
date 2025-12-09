package org.example.api;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.qameta.allure.Step;
import org.example.Constants;
import org.example.core.BaseApi;
import org.example.core.TokenManager;
import org.example.models.BookingRequest;
import org.example.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookingApi extends BaseApi {
    protected final Logger logger = LoggerFactory.getLogger(BookingApi.class);

    @Step("Create a new booking")
     public int createBooking(BookingRequest payload) {
        var response = post(Constants.BOOKING_ENDPOINT, JsonUtils.toJson(payload));
        String jsonBody = response.text();
        logger.info("Create Booking Response Body: {}", jsonBody);
        JsonObject obj = JsonParser.parseString(jsonBody).getAsJsonObject();
        return obj.get("bookingid").getAsInt();
    }

    @Step("Get booking with ID: {id}")
    public String getBooking(int id) {
        return get(Constants.BOOKING_ENDPOINT + "/" + id).text();
    }

    public int updateBooking(int id, BookingRequest requestBody) {
        var token = TokenManager.getToken();
        return put(Constants.BOOKING_ENDPOINT + "/" + id, JsonUtils.toJson(requestBody)).status();
    }

    public int deleteBooking(int id) {
        var token = TokenManager.getToken();
        return delete(Constants.BOOKING_ENDPOINT + "/" + + id).status();
    }
}

