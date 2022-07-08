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

    @Test
    public void Test02(){
        //baseURI = AutomationTesting.baseuri;
        baseURI = "https://auctions-app-2.herokuapp.com/api";
        JSONObject req = new JSONObject();

        req.put("name", "vinh");
        req.put("phone", "090");
        req.put("email", "ninhthanhvinh@gmail.com");
        req.put("content", "Test thôi");
        req.put("file", null);
        req.put("report_type", "4");


        Response res = given().contentType(ContentType.JSON).body(req.toJSONString()).when().post("/contactUs");

        System.out.println(res.getBody().asString());

        JsonPath jpath = res.jsonPath();
        assertNotEquals(jpath.getInt("code"), 1000);
    }
    @Test
    public void Test03(){
        //baseURI = AutomationTesting.baseuri;
        baseURI = "https://auctions-app-2.herokuapp.com/api";
        JSONObject req = new JSONObject();

        req.put("name", "vinh");
        req.put("phone", "090");
        req.put("email", "");
        req.put("content", "Test thôi");
        req.put("file", null);
        req.put("report_type", "3");


        Response res = given().contentType(ContentType.JSON).body(req.toJSONString()).when().post("/contactUs");

        System.out.println(res.getBody().asString());

        JsonPath jpath = res.jsonPath();
        assertNotEquals(jpath.getInt("code"), 1000);
    }

    @Test
    public void Test04(){
        //baseURI = AutomationTesting.baseuri;
        baseURI = "https://auctions-app-2.herokuapp.com/api";
        JSONObject req = new JSONObject();

        req.put("name", "jasdfjlaslkdflajslfjasdfsấddlafjasldfjlajsdfjlkasdjfljasdlfjlasdjflkajsdlkfjsdlfjlasjdfljasdlfjasdlsadfdsfsgfadjlfjsdfjasldfjlasdjfljasdljflksdajfklsdjaflasdjfkljasdlfjsdlafjlasdjflsdajflasdjlfjasdlfjasdlfjasdlfjlsdajflsajdfljasdlfjasdlfjasdljflasdjflsdjflasjfsldjflsdajflasdjfasdlfjasdlfjasdlkfjfjasdlfjlasdjflasdjflasdjfldasjlfjasdlfjlasdjflsdajflsdajflsddfsafasldfjasfjadsfjkasdlfjadslfasdfartergdsfsafasfs");
        req.put("phone", "090");
        req.put("email", "ninhthanhvinh@gmail.com");
        req.put("content", "Test thôi");
        req.put("file", null);
        req.put("report_type", "1");


        Response res = given().contentType(ContentType.JSON).body(req.toJSONString()).when().post("/contactUs");

        System.out.println(res.getBody().asString());

        JsonPath jpath = res.jsonPath();
        assertNotEquals(jpath.getInt("code"), 1000);
    }

    @Test
    public void Test05(){
        //baseURI = AutomationTesting.baseuri;
        baseURI = "https://auctions-app-2.herokuapp.com/api";
        JSONObject req = new JSONObject();

        req.put("name", "vinh");
        req.put("phone", "09999999595959454549955595959595959595954545454545454545255255545454545484848484821848484484848485415154848555150");
        req.put("email", "ninhthanhvinh@gmail.com");
        req.put("content", "Test thôi");
        req.put("file", null);
        req.put("report_type", "1");


        Response res = given().contentType(ContentType.JSON).body(req.toJSONString()).when().post("/contactUs");

        System.out.println(res.getBody().asString());

        JsonPath jpath = res.jsonPath();
        assertNotEquals(jpath.getInt("code"), 1000);
    }
    @Test
    public void Test06 (){
        //baseURI = AutomationTesting.baseuri;
        baseURI = "https://auctions-app-2.herokuapp.com/api";
        JSONObject req = new JSONObject();

        req.put("name", "vinh");
        req.put("phone", "090");
        req.put("email", "123");
        req.put("content", "Test thôi");
        req.put("file", null);
        req.put("report_type", "1");


        Response res = given().contentType(ContentType.JSON).body(req.toJSONString()).when().post("/contactUs");

        System.out.println(res.getBody().asString());

        JsonPath jpath = res.jsonPath();
        assertNotEquals(jpath.getInt("code"), 1000);
    }

    @Test
    public void Test07(){
        //baseURI = AutomationTesting.baseuri;
        baseURI = "https://auctions-app-2.herokuapp.com/api";
        JSONObject req = new JSONObject();

        req.put("name", "vinh");
        req.put("phone", "090");
        req.put("email", "ninhthanhvinh@gmail.com");
        req.put("content", "");
        req.put("file", null);
        req.put("report_type", "2");


        Response res = given().contentType(ContentType.JSON).body(req.toJSONString()).when().post("/contactUs");

        System.out.println(res.getBody().asString());

        JsonPath jpath = res.jsonPath();
        assertNotEquals(jpath.getInt("code"), 1000);
    }
    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { ContactUsTest.class });
        testng.addListener(tla);
        testng.run();
    }
}
