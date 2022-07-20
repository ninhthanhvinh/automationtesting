package com.tvinh.test1;

import static io.restassured.RestAssured.baseURI;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_news {
    private final String JSON = "application/json";

    @Test
    public void Test01() {
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String ACCESS_TOKEN = loginTest.getAccessToken();

        Response res = given().header("Authorization", "bearer" + ACCESS_TOKEN).
                contentType(JSON).
                with().
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/news");
        res.then().statusCode(200);

        JsonPath jpath = res.jsonPath();
        LinkedHashMap<String, String> data = jpath.get("data");
        System.out.println(jpath.getInt("code"));
        System.out.println(data);

        AssertJUnit.assertNotNull(res);
    }

    @Test
    public void Test02() {
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String ACCESS_TOKEN = loginTest.getAccessToken();

        Response res = given().header("Authorization", "bearer" + ACCESS_TOKEN).
                contentType(JSON).
                with().
                queryParam("index", "2").
                queryParam("count", "3").
                when().
                get("/news");
        res.then().statusCode(200);

        JsonPath jpath = res.jsonPath();
        LinkedHashMap<String, String> data = jpath.get("data");
        System.out.println(jpath.getInt("code"));
        System.out.println(data);

        AssertJUnit.assertNotNull(res);
    }
    @Test
    public void Test03() {
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String ACCESS_TOKEN = loginTest.getAccessToken();

        Response res = given().header("Authorization", "bearer" + ACCESS_TOKEN).
                contentType(JSON).
                with().
                queryParam("index", "").
                queryParam("count", "").
                when().
                get("/news");
        res.then().statusCode(200);

        JsonPath jpath = res.jsonPath();
        LinkedHashMap<String, String> data = jpath.get("data");
        System.out.println(jpath.getInt("code"));
        System.out.println(data);

        AssertJUnit.assertNotNull(res);
    }
    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { Get_news.class });
        testng.addListener(tla);
        testng.run();
    }

}
