package com.tvinh.test1;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class EditAuctionTest {
    @Test
    public void TestCase01(){

        //baseURI = AutomationTesting.baseuri;
        baseURI = "https://auctions-app-2.herokuapp.com/api";


        LocalDateTime today = LocalDateTime.now();
        LocalDateTime startDay = today.plusDays(1);
        LocalDateTime endDay = today.plusDays(3);
        String startString = startDay.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String endString = endDay.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String randomString = RandomStringUtils.randomAlphanumeric(10);

        JSONObject request = new JSONObject();
        request.put("category_id", 1);
        request.put("start_date", startString);
        request.put("end_date", endString);
        request.put("title_ni", "day la title " + randomString);

        LoginTest loginTest = new LoginTest();
        String accessToken = "bearer" + loginTest.getAccessToken();

        Response response = given().
                header("Authorization", accessToken).
                contentType(ContentType.JSON).
                with().
                pathParam("auctionID","255").
                body(request.toJSONString()).
                when().
                post("/auctions/edit/{auctionID}");
        System.out.println(response.getBody().asString());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getInt("code"), 1000);
    }
}
