package com.tvinh.test1;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class GetListAuctionsByStatusTest {
    @Test
    public void TestCase01(){
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        Response response = given().
                contentType(ContentType.JSON).
                with().
                pathParam("status", "1").
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/auctions/listAuctionsByStatus/{status}");
        System.out.println(response.getBody().asString());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getInt("code"), 1000);
    }
    @Test
    public void TestCase02(){
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        Response response = given().
                contentType(ContentType.JSON).
                with().
                pathParam("status", "2").
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/auctions/listAuctionsByStatus/{status}");
        System.out.println(response.getBody().asString());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getInt("code"), 1000);
    }
    @Test
    public void TestCase03(){
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        Response response = given().
                contentType(ContentType.JSON).
                with().
                pathParam("status", "3").
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/auctions/listAuctionsByStatus/{status}");
        System.out.println(response.getBody().asString());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getInt("code"), 1000);
    }
    @Test
    public void TestCase04(){
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        Response response = given().
                contentType(ContentType.JSON).
                with().
                pathParam("status", "4").
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/auctions/listAuctionsByStatus/{status}");
        System.out.println(response.getBody().asString());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getInt("code"), 1000);
    }
    @Test
    public void TestCase05(){
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        Response response = given().
                contentType(ContentType.JSON).
                with().
                pathParam("status", "5").
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/auctions/listAuctionsByStatus/{status}");
        System.out.println(response.getBody().asString());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getInt("code"), 1000);
    }
    @Test
    public void TestCase06(){
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        Response response = given().
                contentType(ContentType.JSON).
                with().
                pathParam("status", "6").
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/auctions/listAuctionsByStatus/{status}");
        System.out.println(response.getBody().asString());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getInt("code"), 1000);
    }

    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { GetListAuctionsByStatusTest.class });
        testng.addListener(tla);
        testng.run();
    }
}
