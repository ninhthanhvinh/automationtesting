package com.tvinh.test1;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class GetListAuctionTest {
    Map<String, Object> map = new HashMap<String, Object>();
    private final String JSON = "application/json";

    @Test
    public void Test01(){

        baseURI = "https://auctions-app-2.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String ACCESS_TOKEN = loginTest.getAccessToken();

        Response res = given().
                            //header("Authorization", "bearer" + ACCESS_TOKEN).
                            contentType(ContentType.JSON).
                        with().
                            queryParam("index", "1").
                            queryParam("count", "2").
                        when().
                            get("/auctions");
        //res.then().statusCode(200);
/*
        JsonPath jpath = res.jsonPath();
        LinkedHashMap<String, String> data = jpath.get("data");
        System.out.println(data);
*/
        System.out.println(res.getBody().toString());
    }

    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { GetListAuctionTest.class });
        testng.addListener(tla);
        testng.run();
    }

}
