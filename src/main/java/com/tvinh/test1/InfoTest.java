package com.tvinh.test1;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class InfoTest {

    @Test
    public void Test01(){

        baseURI = "https://auctions-app-2.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String accessToken = "bearer" + loginTest.getAccessToken();

        Response response = given().
                            header("Authorization", accessToken).
                            contentType(ContentType.JSON).
                            when().
                            get("/info");
        System.out.println(response.getBody().asPrettyString());
        assertEquals(response.jsonPath().getInt("code"), 1000);
    }

    @Test
    public void Test02(){

        baseURI = "https://auctions-app-2.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String accessToken = "bearer" + loginTest.getAccessToken();

        Response response = given().
                contentType(ContentType.JSON).
                when().
                get("/info");
        System.out.println(response.getBody().asPrettyString());
        assertEquals(response.jsonPath().getInt("code"), 1004);
        System.out.println("Đăng nhập không thành công");
    }
}
