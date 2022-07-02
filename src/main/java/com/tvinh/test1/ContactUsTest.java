package com.tvinh.test1;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
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
        //baseURI = AutomationTesting.baseuri;
        baseURI = "https://auctions-app-2.herokuapp.com/api";
        JSONObject req = new JSONObject();

        req.put("name", "vinh");
        req.put("phone", "090");
        req.put("email", "ninhthanhvinh@gmail.com");
        req.put("content", "Test thôi");
        req.put("file", null);
        req.put("report_type", "2");


        Response res = given().contentType(ContentType.JSON).body(req.toJSONString()).when().post("/contactUs");

        System.out.println(res.getBody().asString());

        JsonPath jpath = res.jsonPath();
        assertEquals(jpath.getInt("code"), 1000);
    }
}
