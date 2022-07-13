package com.tvinh.test1;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

import java.util.LinkedHashMap;

import io.restassured.http.ContentType;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_slider {
    @Test
    public void Test01() {

        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        Response res = given().contentType(ContentType.JSON).
                        when().get("/slider");
        res.then().statusCode(200);

        System.out.println(res.getBody().asString());

        JsonPath jpath = res.jsonPath();
        assertEquals(jpath.getInt("code"), 1000);
    }

    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { Get_slider.class });
        testng.addListener(tla);
        testng.run();
    }

}
