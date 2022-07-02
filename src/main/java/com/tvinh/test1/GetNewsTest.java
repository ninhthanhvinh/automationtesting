package com.tvinh.test1;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetNewsTest {
    String ACCESS_TOKEN = LoginTest.ACCESS_TOKEN;

    private final String JSON = "application/json";

    @Test
    public void Test01() {
        baseURI = "https://auction-app3.herokuapp.com/api";


        Response res = given().accept(JSON).
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/news");

        AssertJUnit.assertNotNull(res);
    }

    @Test
    public void Test02() {
        baseURI = "https://auction-app3.herokuapp.com/api";


        Response res = given().accept(JSON).
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/news");

        AssertJUnit.assertNotNull(res);
    }

    @Test
    public void Test03() {
        baseURI = "https://auction-app3.herokuapp.com/api";


        Response res = given().accept(JSON).
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/news");

        AssertJUnit.assertNotNull(res);
    }

    @Test
    public void Test04() {
        baseURI = "https://auction-app3.herokuapp.com/api";


        Response res = given().accept(JSON).
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/news");

        AssertJUnit.assertNotNull(res);
    }

    @Test
    public void Test05() {
        baseURI = "https://auction-app3.herokuapp.com/api";


        Response res = given().accept(JSON).
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/news");

        AssertJUnit.assertNotNull(res);
    }
    @Test
    public void Test06() {
            baseURI = "https://auction-app3.herokuapp.com/api";


            Response res = given().accept(JSON).
                    queryParam("index", "1").
                    queryParam("count", "2").
                    when().
                    get("/news");

            AssertJUnit.assertNotNull(res);
    }
}