package com.tvinh.test1;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class AuctionCreateTest {

    Map<String, Object> map = new HashMap<String, Object>();
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
                            body(request.toJSONString()).
                            when().
                            post("/auctions/create");
        System.out.println(response.getBody().asString());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getInt("code"), 1000);
    }


    public int getID(){

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
                body(request.toJSONString()).
                when().
                post("/auctions/create");
        JsonPath jsonPath = response.jsonPath();
        LinkedHashMap<String, Object> data = jsonPath.get("data");
        return (int) data.get("auction_id");
    }
    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { AuctionCreateTest.class });
        testng.addListener(tla);
        testng.run();
    }

}
