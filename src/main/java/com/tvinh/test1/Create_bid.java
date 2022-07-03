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
        baseURI = "https://auction-app3.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String ACCESS_TOKEN = loginTest.getAccessToken();

        Response res = given().
                            header("Authorization", "bearer" + ACCESS_TOKEN).
                            contentType(JSON).
                        with().
                            pathParam("auctionId", 1).
                            queryParam("price", 1).
                            queryParam("bid_last_id", "1234").
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

