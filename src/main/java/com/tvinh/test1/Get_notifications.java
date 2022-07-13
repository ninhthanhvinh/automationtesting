package com.tvinh.test1;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_notifications {
    private final String JSON = "application/json";

    @Test
    public void Test01() {
        JSONObject request = new JSONObject();

        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String ACCESS_TOKEN = loginTest.getAccessToken();

        Response res = given().header("Authorization", "bearer" + ACCESS_TOKEN).
                contentType(JSON).
                queryParam("index", "1").
                queryParam("count", "2").
                when().get("/notifications");
        res.then().statusCode(200);

        JsonPath jpath = res.jsonPath();
        LinkedHashMap<String, String> data = jpath.get("data");
        System.out.println(data);

    }

    @Test
    public void Test02() {
        JSONObject request = new JSONObject();

        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String ACCESS_TOKEN = loginTest.getAccessToken();

        Response res = given().header("Authorization", "bearer" + ACCESS_TOKEN).
                contentType(JSON).
                queryParam("index", "114120000").
                queryParam("count", "200004234").
                when().get("/notifications");
        res.then().statusCode(200);

        JsonPath jpath = res.jsonPath();
        LinkedHashMap<String, String> data = jpath.get("data");
        System.out.println(data);

    }

    @Test
    public void Test03() {
        JSONObject request = new JSONObject();

        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String ACCESS_TOKEN = loginTest.getAccessToken();

        AuctionCreateTest auctionCreateTest = new AuctionCreateTest();
        int id = auctionCreateTest.getID();

        Response res = given().header("Authorization", "bearer" + ACCESS_TOKEN).
                contentType(JSON).
                queryParam("index", id).
                queryParam("count", id*id).
                when().get("/notifications");
        res.then().statusCode(200);

        JsonPath jpath = res.jsonPath();
        LinkedHashMap<String, String> data = jpath.get("data");
        System.out.println(data);

    }
    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { Get_notifications.class });
        testng.addListener(tla);
        testng.run();
    }

}
