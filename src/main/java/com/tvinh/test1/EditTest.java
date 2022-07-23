package com.tvinh.test1;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class EditTest {

    Map<String, Object> map = new HashMap<String, Object>();

    private final String JSON = "application/json";

    @Test
    public void TestCase01() {

        JSONObject request = new JSONObject();

        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();

        String ACCESS_TOKEN = loginTest.getAccessToken();

        String mail = RandomStringUtils.randomAlphabetic(10);
        request.put("email", "vinh123a@gmail.com");
        request.put("password", "123456");
        request.put("re_pass", "123456");
        request.put("address", null);
        request.put("name", "MyName");
        request.put("phone", "09090909090");
        request.put("avatar", null);

        Response response = given().
                header("Authorization","Bearer" + ACCESS_TOKEN).
                contentType(JSON).
                body(request.toJSONString()).
                when().
                post("/edit");

        System.out.println(response.getBody().asString());

        response.then().statusCode(200);

        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1000);

    }

    @Test
    public void TestCase02() {

        JSONObject request = new JSONObject();

        baseURI = AutomationTesting.baseuri;

        LoginTest loginTest = new LoginTest();


        request.put("email", "vinh123a@gmail.com");
        request.put("password", "123456");
        request.put("re_pass", "123456");
        request.put("address", "MyAddress");
        request.put("name", "MyName");
        request.put("phone", "09090909090");
        request.put("avatar", null);

        Response response = given().
                contentType(JSON).
                body(request.toJSONString()).
                when().
                post("/edit");

        System.out.println(response.getBody().asString());

        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1000);

    }

    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { EditTest.class });
        testng.addListener(tla);
        testng.run();
    }
}
