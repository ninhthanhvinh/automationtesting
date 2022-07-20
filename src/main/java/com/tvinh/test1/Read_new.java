package com.tvinh.test1;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Read_new {
    Map<String, Object> map = new HashMap<String, Object>();

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
                pathParam("newId", 1).
                when().
                get("/news/read/{newId}");
        res.then().statusCode(200);

        JsonPath jpath = res.jsonPath();
        LinkedHashMap<String, String> data = jpath.get("data");
        System.out.println(data);
        assertEquals(jpath.getInt("code"), 1000);
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
                pathParam("newId", 2).
                when().
                get("/news/read/{newId}");
        res.then().statusCode(200);

        JsonPath jpath = res.jsonPath();
        LinkedHashMap<String, String> data = jpath.get("data");
        System.out.println(data);
        assertEquals(jpath.getInt("code"), 1000);
    }
    @Test
    public void Test03() {
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String ACCESS_TOKEN = loginTest.getAccessToken();

        Response res = given().
                contentType(JSON).
                with().
                pathParam("newId", 1).
                when().
                get("/news/read/{newId}");
        res.then().statusCode(200);

        JsonPath jpath = res.jsonPath();
        LinkedHashMap<String, String> data = jpath.get("data");
        System.out.println(data);
        assertEquals(jpath.getInt("code"), 1000);
    }
    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { Read_new.class });
        testng.addListener(tla);
        testng.run();
    }
}
