package com.tvinh.test1;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Info_auction {

    @Test
    public void Test01(){
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String access_token = loginTest.getAccessToken();

        AuctionCreateTest auctionCreateTest = new AuctionCreateTest();
        int id = auctionCreateTest.getID();

        Response res = given().
                            header("Authorization", "bearer" + access_token).
                            contentType(ContentType.JSON).
                        with().
                            pathParam("auctionId", id).
                        when().
                            get("/auctions/info/{auctionId}");
        res.then().statusCode(200);

        System.out.println(res.getBody().asString());
        JsonPath jpath = res.jsonPath();
        assertEquals(jpath.getInt("code"), 1000);

    }

    @Test
    public void Test02(){
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        AuctionCreateTest auctionCreateTest = new AuctionCreateTest();
        int id = auctionCreateTest.getID();

        Response res = given().
                contentType(ContentType.JSON).
                with().
                pathParam("auctionId", id).
                when().
                get("/auctions/info/{auctionId}");
        res.then().statusCode(200);

        System.out.println(res.getBody().asString());
        JsonPath jpath = res.jsonPath();
        assertEquals(jpath.getInt("code"), 1004);
    }
    @Test
    public void Test03(){
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String access_token = loginTest.getAccessToken();

        Response res = given().
                header("Authorization", "bearer" + access_token).
                contentType(ContentType.JSON).
                with().
                pathParam("auctionId", "123").
                when().
                get("/auctions/info/{auctionId}");
        res.then().statusCode(200);

        System.out.println(res.getBody().asString());
        JsonPath jpath = res.jsonPath();
        assertEquals(jpath.getInt("code"), 1000);

    }

    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { Info_auction.class });
        testng.addListener(tla);
        testng.run();
    }
}
