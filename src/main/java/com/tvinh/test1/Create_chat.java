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

public class Create_chat {

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
                pathParam("userReceiveId", 1).
                when().
                post("chat/conversations/{userReceiveId}");
        res.then().statusCode(200);

        System.out.println(res.getBody().asString());
        JsonPath jpath = res.jsonPath();
        assertEquals(jpath.getInt("code"), 1000);

    }
    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { Create_chat.class });
        testng.addListener(tla);
        testng.run();
    }
}
