package com.tvinh.test1;

import static io.restassured.RestAssured.baseURI;
import static org.testng.Assert.assertEquals;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Search {
    Map<String, Object> map = new HashMap<String, Object>();
    private static final String JSON = "application/json";

    @Test
    public void Test01() {
        JSONObject request = new JSONObject();

        baseURI = "https://auction-app3.herokuapp.com/api";

        Response response = given().
                accept(JSON).
                queryParam("index", "1").
                queryParam("key", "car").
                when().
                get("/search");

        response.then().statusCode(200);

        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        assertEquals(jpath.getInt("code"), 9998);
    }

    @Test
    public void Test02() {
        JSONObject request = new JSONObject();

        baseURI = "https://auction-app3.herokuapp.com/api";

        Response response = given().
                accept(JSON).
                queryParam("index", "2").
                queryParam("key", "car").
                when().
                get("/search");

        response.then().statusCode(200);
        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        assertEquals(jpath.getInt("code"), 9998);
    }

    @Test
    public void Test03() {
        JSONObject request = new JSONObject();

        baseURI = "https://auction-app3.herokuapp.com/api";

        Response response = given().
                accept(JSON).
                queryParam("index", "3").
                queryParam("key", "car").
                when().
                get("/search");

        response.then().statusCode(200);

        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        assertEquals(jpath.getInt("code"), 9998);
    }

    @Test
    public void Test04() {
        JSONObject request = new JSONObject();

        baseURI = "https://auction-app3.herokuapp.com/api";

        Response response = given().
                accept(JSON).
                queryParam("index", "4").
                queryParam("key", "car").
                when().
                get("/search");

        response.then().statusCode(200);

        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        assertEquals(jpath.getInt("code"), 9998);
    }

    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { Search.class });
        testng.addListener(tla);
        testng.run();
    }
}