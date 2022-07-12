package com.tvinh.test1;

import static io.restassured.RestAssured.baseURI;
import static org.testng.Assert.assertEquals;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Create_bid {
    Map<String, Object> map = new HashMap<String, Object>();

    private final String JSON = "application/json";

    @Test
    public void Test01() {
        baseURI = "https://auctions-app-2.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String ACCESS_TOKEN = loginTest.getAccessToken();

        AuctionCreateTest auctionCreateTest = new AuctionCreateTest();
        int id = auctionCreateTest.getID();

        Response res = given().
                            header("Authorization", "bearer" + ACCESS_TOKEN).
                            contentType(JSON).
                        with().
                            pathParam("auctionId", id).
                            queryParam("price", 111000000).
                            queryParam("bid_last_id", "1234").
                        when().
                            post("/bids/create/{auctionId}");

        res.then().statusCode(200);
        System.out.println(res.getBody().asString());

        JsonPath jpath = res.jsonPath();
        assertEquals(jpath.getInt("code"), 1008);

    }

    @Test
    public void Test02() {
//        baseURI = AutomationTesting.baseuri;
        baseURI = "https://auction-app3.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String ACCESS_TOKEN = loginTest.getAccessToken();

        AuctionCreateTest auctionCreateTest = new AuctionCreateTest();
        int id = auctionCreateTest.getID();

        Response res = given().
                header("Authorization", "bearer" + ACCESS_TOKEN).
                contentType(JSON).
                with().
                pathParam("auctionId", id).
                queryParam("price", 1).
                queryParam("bid_last_id", "1235").
                when().
                post("/bids/create/{auctionId}");

        res.then().statusCode(200);
        System.out.println(res.getBody().asString());

        JsonPath jpath = res.jsonPath();
        assertEquals(jpath.getInt("code"), 1001);

    }
    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { Create_bid.class });
        testng.addListener(tla);
        testng.run();
    }

}

