package com.tvinh.test1;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class UploadStatusTest {
    @Test
    public void Test01(){

        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        Response response = given().
                                contentType(ContentType.JSON).
                            when().
                                get("/auctions/update/status");
        assertEquals(response.jsonPath().getInt("code"), 1000);
    }
    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { UploadStatusTest.class });
        testng.addListener(tla);
        testng.run();
    }
}