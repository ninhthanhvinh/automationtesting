package com.tvinh.test1;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertNotEquals;

import io.restassured.http.ContentType;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LogOutTest {
    @Test
    public void Test01() {

        //baseURI = AutomationTesting.baseuri;
        baseURI = "https://auctions-app-2.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String ACCESS_TOKEN = loginTest.getAccessToken();

        Response response = given().
                header("Authorization", "bearer" + ACCESS_TOKEN).
                contentType(ContentType.JSON).
                when().
                post("/logout");
        response.then().statusCode(200);
        //System.out.println(response.getBody().asString());
        /*JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        System.out.println(code);
        assertNotEquals(code, 1000);
*/
    }

    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { LogOutTest.class });
        testng.addListener(tla);
        testng.run();
    }

}
