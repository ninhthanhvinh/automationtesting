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

public class GetListAuctionsByUser {
    @Test
    public void TestCase01(){
        //baseURI = AutomationTesting.baseuri;
        baseURI = "https://auctions-app-2.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String accessToken = "bearer" + loginTest.getAccessToken();

        Response response = given().
                contentType(ContentType.JSON).with().
                header("Authorization", accessToken).
                pathParam("statusId", "1").
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/auctions/listAuctionsByUser/{statusId}");
        System.out.println(response.getBody().asString());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getInt("code"), 1000);

    }
    @Test
    public void TestCase02(){
        //baseURI = AutomationTesting.baseuri;
        baseURI = "https://auctions-app-2.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String accessToken = "bearer" + loginTest.getAccessToken();

        Response response = given().
                contentType(ContentType.JSON).with().
                header("Authorization", accessToken).
                pathParam("statusId", "2").
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/auctions/listAuctionsByUser/{statusId}");
        System.out.println(response.getBody().asString());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getInt("code"), 1000);

    }
    @Test
    public void TestCase03(){
        //baseURI = AutomationTesting.baseuri;
        baseURI = "https://auctions-app-2.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String accessToken = "bearer" + loginTest.getAccessToken();

        Response response = given().
                contentType(ContentType.JSON).with().
                header("Authorization", accessToken).
                pathParam("statusId", "3").
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/auctions/listAuctionsByUser/{statusId}");
        System.out.println(response.getBody().asString());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getInt("code"), 1000);

    }
    @Test
    public void TestCase04(){
        //baseURI = AutomationTesting.baseuri;
        baseURI = "https://auctions-app-2.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String accessToken = "bearer" + loginTest.getAccessToken();

        Response response = given().
                contentType(ContentType.JSON).with().
                header("Authorization", accessToken).
                pathParam("statusId", "4").
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/auctions/listAuctionsByUser/{statusId}");
        System.out.println(response.getBody().asString());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getInt("code"), 1000);

    }
    @Test
    public void TestCase05(){
        //baseURI = AutomationTesting.baseuri;
        baseURI = "https://auctions-app-2.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String accessToken = "bearer" + loginTest.getAccessToken();

        Response response = given().
                contentType(ContentType.JSON).with().
                header("Authorization", accessToken).
                pathParam("statusId", "5").
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/auctions/listAuctionsByUser/{statusId}");
        System.out.println(response.getBody().asString());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getInt("code"), 1000);

    }
    @Test
    public void TestCase06(){
        //baseURI = AutomationTesting.baseuri;
        baseURI = "https://auctions-app-2.herokuapp.com/api";


        Response response = given().
                contentType(ContentType.JSON).with().
                pathParam("statusId", "6").
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/auctions/listAuctionsByUser/{statusId}");
        System.out.println(response.getBody().asString());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getInt("code"), 1004);

    }

    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { GetListAuctionsByUser.class });
        testng.addListener(tla);
        testng.run();
    }
}
