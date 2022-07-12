package com.tvinh.test1;

import io.restassured.http.ContentType;
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

public class ChangePassTest {
    Map<String, Object> map = new HashMap<String, Object>();

    @Test
    public void CaseTest1() {

        baseURI = "https://auctions-app-2.herokuapp.com/api";

        JSONObject request = new JSONObject();
        request.put("old_pass", "123456");
        request.put("new_pass", "12345678");
        request.put("re_pass", "12345678");

        LoginTest loginTest = new LoginTest();
        String accessToken = "bearer" + loginTest.getAccessToken();
        Response response = given().
                                header("Authorization", accessToken).
                                contentType(ContentType.JSON).
                            with().
                                body(request.toJSONString()).
                            when().
                                post("/changepass");
        System.out.println(response.getBody().asPrettyString());
        assertEquals(response.jsonPath().getInt("code"), 1000);

    }

    @Test
    public void CaseTest2() {

        baseURI = "https://auctions-app-2.herokuapp.com/api";

        JSONObject request = new JSONObject();
        request.put("old_pass", "12345678");
        request.put("new_pass", "123456");
        request.put("re_pass", "123456");

        LoginTest loginTest = new LoginTest();
        String accessToken = "bearer" + loginTest.getAccessToken();
        Response response = given().
                                header("Authorization", accessToken).
                                contentType(ContentType.JSON).
                            with().
                                body(request.toJSONString()).
                            when().
                                post("/changepass");
        System.out.println(response.getBody().asPrettyString());
        assertEquals(response.jsonPath().getInt("code"), 1001);

    }

    @Test
    public void CaseTest3() {

        baseURI = "https://auctions-app-2.herokuapp.com/api";

        JSONObject request = new JSONObject();
        request.put("old_pass", "12345678");
        request.put("new_pass", "");
        request.put("re_pass", "12345678");

        LoginTest loginTest = new LoginTest();
        String accessToken = "bearer" + loginTest.getAccessToken();
        Response response = given().
                                header("Authorization", accessToken).
                                contentType(ContentType.JSON).
                            with().
                                body(request.toJSONString()).
                            when().
                                post("/changepass");
        System.out.println(response.getBody().asPrettyString());
        assertEquals(response.jsonPath().getInt("code"), 1001);

    }

    @Test
    public void CaseTest4() {

        baseURI = "https://auctions-app-2.herokuapp.com/api";

        JSONObject request = new JSONObject();
        request.put("old_pass", "12345678");
        request.put("new_pass", "12345678");
        request.put("re_pass", "");

        LoginTest loginTest = new LoginTest();
        String accessToken = "bearer" + loginTest.getAccessToken();
        Response response = given().
                                header("Authorization", accessToken).
                                contentType(ContentType.JSON).
                            with().
                                body(request.toJSONString()).
                            when().
                                post("/changepass");
        System.out.println(response.getBody().asPrettyString());
        assertEquals(response.jsonPath().getInt("code"), 1001);

    }

    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { ChangePassTest.class });
        testng.addListener(tla);
        testng.run();
    }
}