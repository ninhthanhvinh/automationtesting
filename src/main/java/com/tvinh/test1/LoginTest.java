package com.tvinh.test1;

import com.tvinh.test1.AutomationTesting;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class LoginTest {

    public static String ACCESS_TOKEN;

    private final String JSON = "application/json";


    @Test
    public void Test01() {

        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject request = new JSONObject();

        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        //request.put("email", "ninhvinhdeptrai@gmail.com");
        //request.put("password", "vinhdeptrai");

        Response response = given().contentType(JSON).
                //body(request.toJSONString()).
                with().
                queryParam("email", "ninhvinhdeptrai1@gmail.com").
                queryParam("password", "vinhdeptrai1").
                when().
                post("/login");
        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1002);
        if(code != 1002) System.out.println("Test01 fail");
    }
    @Test
    public void Test02() {

        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject request = new JSONObject();

        baseURI = AutomationTesting.baseuri;

        request.put("email", "");
        request.put("password", "");

        Response response = given().contentType(JSON).
                body(request.toJSONString()).
                when().
                post("/login");
        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1001);
        if(code != 1001) System.out.println("Test02 fail");
    }

    @Test
    public void Test03() {

        Map<String, String> map = new HashMap<String, String>();

        JSONObject request = new JSONObject();

        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        request.put("email", "admin@gmail.com");
        request.put("password", "123456");

        Response response = given().contentType(JSON).
                body(request.toJSONString()).
                when().
                post("/login");
        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1002);
        if(code != 1002) System.out.println("Test03 fail");
    }

    @Test
    public void Test04() {

        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject request = new JSONObject();

        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        //request.put("email", "ninhvinhdeptrai@gmail.com");
        //request.put("password", "vinhdeptrai");

        Response response = given().contentType(JSON).
                //body(request.toJSONString()).
                        with().
                queryParam("email", "thanh12345@gmail.com").
                queryParam("password", "123456").
                when().
                post("/login");
        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1000);
        if(code != 1000) System.out.println("Test04 fail");
    }
    @Test
    public void Test05() {

        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject request = new JSONObject();

        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        request.put("email", "");
        request.put("password", "123456");

        Response response = given().contentType(JSON).
                body(request.toJSONString()).
                when().
                post("/login");
        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1001);
        if(code != 1001) System.out.println("Test05 fail");
    }

    @Test
    public void Test06() {

        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject request = new JSONObject();

        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        request.put("email", "thanh12345gmail.com");
        request.put("password", "");

        Response response = given().contentType(JSON).
                body(request.toJSONString()).
                when().
                post("/login");
        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1001);
        if(code != 1001) System.out.println("Test06 fail");
    }

    @Test
    public void Test07() {

        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject request = new JSONObject();

        //baseURI = AutomationTesting.baseuri;
         baseURI = "https://auctions-app-2.herokuapp.com/api";

        request.put("email", "nvh@gmail.com");
        request.put("password", "123456");

        Response response = given().contentType(JSON).
                body(request.toJSONString()).
                when().
                post("/login");
        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1000);
        if(code != 1002) System.out.println("Test07 fail");
    }

    @Test
    public void Test08() {

        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject request = new JSONObject();

        baseURI = AutomationTesting.baseuri;

        Random random = new Random();
        String over255 = RandomStringUtils.randomAlphabetic(255);

        request.put("email", over255 + "@nvh.com");
        request.put("password", "");

        Response response = given().contentType(JSON).
                body(request.toJSONString()).
                when().
                post("/login");
        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1001);
        if(code != 1001) System.out.println("Test08 fail");
    }

    @Test
    public void Test09() {

        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject request = new JSONObject();

        baseURI = AutomationTesting.baseuri;

        Random random = new Random();
        String over255 = RandomStringUtils.randomAlphabetic(255);

        request.put("email", over255 + "@nvh.com");
        request.put("password", over255 +"132");

        Response response = given().contentType(JSON).
                body(request.toJSONString()).
                when().
                post("/login");
        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1001);
        if(code != 1001) System.out.println("Test09 fail");
    }

    @Test
    public void Test10() {

        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject request = new JSONObject();

        baseURI = AutomationTesting.baseuri;

        Random random = new Random();
        String over255 = RandomStringUtils.randomAlphabetic(255);

        request.put("email", "vinhnt67@gmail.com");
        request.put("password", "12345678");

        Response response = given().contentType(JSON).
                body(request.toJSONString()).
                when().
                post("/login");
        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1000);
        if(code != 1000) System.out.println("Test10 fail");
    }

    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { LoginTest.class });
        testng.addListener(tla);
        testng.run();
    }


    public String getAccessToken(){
        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject request = new JSONObject();

        baseURI = AutomationTesting.baseuri;
        //baseURI = "https://auctions-app-2.herokuapp.com/api";

        request.put("email", "vinhnt67@gmail.com");
        request.put("password", "12345678");

        Response response = given().contentType(JSON).
                body(request.toJSONString()).
                when().
                post("/login");

        JsonPath jp = response.jsonPath();
        LinkedHashMap<String, Object> data = jp.get("data");

        return data.get("access_token").toString();
    }
}


