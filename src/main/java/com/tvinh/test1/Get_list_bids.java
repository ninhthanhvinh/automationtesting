package com.tvinh.test1;

import static io.restassured.RestAssured.baseURI;
import static org.testng.Assert.assertEquals;
import static io.restassured.RestAssured.*;

import java.util.LinkedHashMap;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_list_bids {

    private final String JSON = "application/json";

    @Test
    public void Test01() {

        baseURI = "https://auction-app3.herokuapp.com/api";

        AuctionCreateTest auctionCreateTest = new AuctionCreateTest();
        int id = auctionCreateTest.getID();

        Response res = given().
                contentType(ContentType.JSON).
                with().
                pathParam("auctionId", id).
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/bids/{auctionId}");
        res.then().statusCode(200);

        JsonPath jpath = res.jsonPath();
        LinkedHashMap<String, String> data = jpath.get("data");
        System.out.println(data);

        assertEquals(jpath.getInt("code"), 1000);
    }

    @Test
    public void Test02() {

        baseURI = "https://auction-app3.herokuapp.com/api";

        AuctionCreateTest auctionCreateTest = new AuctionCreateTest();
        int id = auctionCreateTest.getID();

        Response res = given().
                contentType(ContentType.JSON).
                with().
                pathParam("auctionId", id).
                queryParam("index", "1000").
                queryParam("count", "2000").
                when().
                get("/bids/{auctionId}");
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

