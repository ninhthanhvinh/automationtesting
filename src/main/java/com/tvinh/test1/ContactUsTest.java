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
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ContactUsTest {
    Map<String, Object> map = new HashMap<String, Object>();
    @Test
    public void Test01(){
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";
        JSONObject req = new JSONObject();

        req.put("name", "vinh");
        req.put("phone", "090");
        req.put("email", "ninhthanhvinh@gmail.com");
        req.put("content", "Test thôi");
        req.put("file", null);
        req.put("report_type", "2");


        Response res = given().
                            contentType(ContentType.JSON).
                            body(req.toJSONString()).
                        when().
                            post("/contactUs");

        System.out.println(res.getBody().asString());

        JsonPath jpath = res.jsonPath();
        assertEquals(jpath.getInt("code"), 1000);
    }

    @Test
    public void Test02(){
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";
        JSONObject req = new JSONObject();

        req.put("name", "hien");
        req.put("phone", "0975");
        req.put("email", "");
        req.put("content", "Test hộ");
        req.put("file", null);
        req.put("report_type", "2");


        Response res = given().
                contentType(ContentType.JSON).
                body(req.toJSONString()).
                when().
                post("/contactUs");

        System.out.println(res.getBody().asString());

        JsonPath jpath = res.jsonPath();
        assertEquals(jpath.getInt("code"), 1001);
    }

    @Test
    public void Test03(){
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";
        JSONObject req = new JSONObject();

        req.put("name", "hien");
        req.put("phone", "01234567890123456789012345678901234567890123456789012345678901234567890123456789");
        req.put("email", "nguyenvanhien@gmail.com");
        req.put("content", "Test hộ");
        req.put("file", null);
        req.put("report_type", "2");


        Response res = given().
                contentType(ContentType.JSON).
                body(req.toJSONString()).
                when().
                post("/contactUs");

        System.out.println(res.getBody().asString());

        JsonPath jpath = res.jsonPath();
        assertEquals(jpath.getInt("code"), 1001);
    }

    @Test
    public void Test04(){
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";
        JSONObject req = new JSONObject();

        req.put("name", "vinh");
        req.put("phone", "090");
        req.put("email", "ninhthanhvinh@gmail.com");
        req.put("content", "Test thôi");
        req.put("file", null);
        req.put("report_type", "4");


        Response res = given().
                contentType(ContentType.JSON).
                body(req.toJSONString()).
                when().
                post("/contactUs");

        System.out.println(res.getBody().asString());

        JsonPath jpath = res.jsonPath();
        assertEquals(jpath.getInt("code"), 1000);
    }

    @Test
    public void Test05(){
        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";
        JSONObject req = new JSONObject();

        req.put("name", "vinh");
        req.put("phone", "090");
        req.put("email", "ninhthanhvinh@gmail.com");
        req.put("content", "");
        req.put("file", null);
        req.put("report_type", "2");


        Response res = given().
                contentType(ContentType.JSON).
                body(req.toJSONString()).
                when().
                post("/contactUs");

        System.out.println(res.getBody().asString());

        JsonPath jpath = res.jsonPath();
        assertEquals(jpath.getInt("code"), 1000);
    }

    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { ContactUsTest.class });
        testng.addListener(tla);
        testng.run();
    }
}
