package com.tvinh.test1;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class GetDetailsAutionTest {
    @Test
    public void TestCase01(){
        //baseURI = AutomationTesting.baseuri;
        baseURI = "https://auctions-app-2.herokuapp.com/api";

        Response response = given().
                            contentType(ContentType.JSON).
                            pathParam("auctionId", "255").
                            when().get("/auctions/detail/{auctionId}");
        System.out.println(response.getBody().asString());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getInt("code"), 1000);
        assertNotNull(jsonPath.getJsonObject("data"));

    }
}
