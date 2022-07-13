package com.tvinh.test1;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertNotNull;

import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetNewsTest {
    String ACCESS_TOKEN = LoginTest.ACCESS_TOKEN;

    private final String JSON = "application/json";

    @Test
    public void Test01() {
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";


        Response res = given().accept(JSON).
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/news");
        System.out.println(res.getBody().asString());
        AssertJUnit.assertNotNull(res);
    }

    @Test
    public void Test02() {
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String accessToken = "bearer" + loginTest.getAccessToken();

        Response res = given().accept(JSON).
                header("Authorization", accessToken).
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/news");
        System.out.println(res.getBody().asString());
        JsonPath jsonPath = res.jsonPath();
        assertNotNull(jsonPath.getJsonObject("data"));
    }
}