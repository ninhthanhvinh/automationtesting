package com.tvinh.test1;

import static io.restassured.RestAssured.baseURI;
import static org.testng.Assert.assertEquals;
import static io.restassured.RestAssured.*;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Search {
    private static final String JSON = "application/json";

    @Test
    public void Test01() {

        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        Response response = given().
                accept(JSON).
                queryParam("type", "1").
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

        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        Response response = given().
                accept(JSON).
                queryParam("type", "2").
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

        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        Response response = given().
                accept(JSON).
                queryParam("type", "3").
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

        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        Response response = given().
                accept(JSON).
                queryParam("type", "4").
                queryParam("key", "car").
                when().
                get("/search");

        response.then().statusCode(200);

        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        assertEquals(jpath.getInt("code"), 9998);
    }

    @Test
    public void Test05() {

        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        Response response = given().
                accept(JSON).
                queryParam("type", "5").
                queryParam("key", "car").
                when().
                get("/search");

        response.then().statusCode(200);

        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        assertEquals(jpath.getInt("code"), 9998);
    }

    @Test
    public void Test06() {

        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        Response response = given().
                accept(JSON).
                queryParam("type", "5").
                queryParam("key", "Thor").
                when().
                get("/search");

        response.then().statusCode(200);

        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        assertEquals(jpath.getInt("code"), 1000);
    }
    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { Search.class });
        testng.addListener(tla);
        testng.run();
    }
}