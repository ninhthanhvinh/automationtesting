package com.tvinh.test1;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class CreateItemTest {
    Map<String, Object> map = new HashMap<String, Object>();

    @Test
    public void TestCase01(){
        //baseURI = AutomationTesting.baseuri;
        baseURI = "https://auctions-app-2.herokuapp.com/api";

        JSONObject request = new JSONObject();
        request.put("name", "Hien dep trai vcl");
        request.put("starting_price", 1);
        request.put("brand_id", 5);
        request.put("description", "Hien sỉu dep trai, thanh ly gap");
        request.put("series", "13HCAW5861");
        request.put("images", null);

        LoginTest loginTest = new LoginTest();
        String accessToken = "bearer" + loginTest.getAccessToken();

        Response response = given().
                            header("Authorization", accessToken).
                            contentType(ContentType.JSON).
                            with().
                            pathParam("auctionId", "254").
                            with().
                            body(request.toJSONString()).
                            when().
                            post("/items/create/{auctionId}");
        System.out.println(response.getBody().asString());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getInt("code"),1000);
    }

    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { CreateItemTest.class });
        testng.addListener(tla);
        testng.run();
    }
}
