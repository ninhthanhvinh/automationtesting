package com.tvinh.test1;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class GetTotalLikeOfAuctionTest {
    @Test
    public void TestCase01(){
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";
        AuctionCreateTest auctionCreateTest = new AuctionCreateTest();
        int id = auctionCreateTest.getID();

        Response response = given().
                contentType(ContentType.JSON).
                with().
                pathParam("auctionId", id).
                when().get("/totalLikes/{auctionId}");
        System.out.println(response.getBody().asString());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getInt("code"), 1000);
        assertNotNull(jsonPath.getJsonObject("data"));
    }
    @Test
    public void TestCase02(){
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";
        AuctionCreateTest auctionCreateTest = new AuctionCreateTest();
        int id = auctionCreateTest.getID();

        Response response = given().
                contentType(ContentType.JSON).
                with().
                pathParam("auctionId", "1").
                when().get("/totalLikes/{auctionId}");
        System.out.println(response.getBody().asString());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getInt("code"), 1000);
        assertNotNull(jsonPath.getJsonObject("data"));
    }
    @Test
    public void TestCase03(){
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";
        AuctionCreateTest auctionCreateTest = new AuctionCreateTest();
        int id = auctionCreateTest.getID();

        Response response = given().
                contentType(ContentType.JSON).
                with().
                pathParam("auctionId", "123").
                when().get("/totalLikes/{auctionId}");
        System.out.println(response.getBody().asString());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getInt("code"), 1000);
        assertNotNull(jsonPath.getJsonObject("data"));
    }

    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { GetTotalLikeOfAuctionTest.class });
        testng.addListener(tla);
        testng.run();
    }
}
