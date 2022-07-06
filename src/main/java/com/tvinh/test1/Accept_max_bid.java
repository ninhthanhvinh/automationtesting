package com.tvinh.test1;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Accept_max_bid {

    Map<String, Object> map = new HashMap<String, Object>();
    private final String JSON = "application/json";

    @Test
    public void Test01(){
        baseURI = "https://auctions-app-2.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String ACCESS_TOKEN = loginTest.getAccessToken();

        Response res = given().
                            header("Authorization", "bearer" + ACCESS_TOKEN).
                            contentType(ContentType.JSON).
                        with().
                            pathParam("auctionId", 255).
                            queryParam("selling_info", "sell baby Vinh").
                        when().
                            post("/accept/{auctionId}");
        res.then().statusCode(200);
        System.out.println(res.getBody().asString());

        JsonPath jpath = res.jsonPath();
        assertEquals(jpath.getInt("code"), 1009);
    }

    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { Accept_max_bid.class });
        testng.addListener(tla);
        testng.run();
    }

}
