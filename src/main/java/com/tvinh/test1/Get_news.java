package com.tvinh.test1;

import static io.restassured.RestAssured.baseURI;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_news {
    String ACCESS_TOKEN = LoginTest.ACCESS_TOKEN;
    Map<String, Object> map = new HashMap<String, Object>();
    private final String JSON = "application/json";

    @Test
    public void Test01() {
        baseURI = "https://auction-app3.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String ACCESS_TOKEN = loginTest.getAccessToken();

        Response res = given().header("Authorization", "bearer" + ACCESS_TOKEN).
                contentType(JSON).
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/news");
        res.then().statusCode(200);

        JsonPath jpath = res.jsonPath();
        LinkedHashMap<String, String> data = jpath.get("data");
        System.out.println(data);

        AssertJUnit.assertNotNull(res);
    }

    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { Get_news.class });
        testng.addListener(tla);
        testng.run();
    }

}
