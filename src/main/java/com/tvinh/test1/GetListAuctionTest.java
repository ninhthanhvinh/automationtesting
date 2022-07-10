package com.tvinh.test1;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class GetListAuctionTest {
    @Test
    public void Test01(){

        baseURI = "https://auctions-app-2.herokuapp.com/api";

        Response res = given().
                            contentType(ContentType.JSON).
                        with().
                            pathParam("auctionId", "1").
                            queryParam("index", "1").
                            queryParam("count", "2").
                        when().
                            get("/auctions/{auctionId}");
        res.then().statusCode(200);
        System.out.println(res.getBody().asString());
    }

    @Test
    public void Test02(){

        baseURI = "https://auctions-app-2.herokuapp.com/api";

        Response res = given().
                contentType(ContentType.JSON).
                with().
                pathParam("auctionId", "2").
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/auctions/{auctionId}");
        res.then().statusCode(200);
        System.out.println(res.getBody().asString());
    }

    @Test
    public void Test03(){

        baseURI = "https://auctions-app-2.herokuapp.com/api";

        Response res = given().
                contentType(ContentType.JSON).
                with().
                pathParam("auctionId", "3").
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/auctions/{auctionId}");
        res.then().statusCode(200);
        System.out.println(res.getBody().asString());
    }
    @Test
    public void Test04(){

        baseURI = "https://auctions-app-2.herokuapp.com/api";

        Response res = given().
                contentType(ContentType.JSON).
                with().
                pathParam("auctionId", "4").
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/auctions/{auctionId}");
        res.then().statusCode(200);
        System.out.println(res.getBody().asString());
    }
    @Test
    public void Test05(){

        baseURI = "https://auctions-app-2.herokuapp.com/api";

        Response res = given().
                contentType(ContentType.JSON).
                with().
                pathParam("auctionId", "5").
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/auctions/{auctionId}");
        res.then().statusCode(200);
        System.out.println(res.getBody().asString());
    }
    @Test
    public void Test06(){

        baseURI = "https://auctions-app-2.herokuapp.com/api";

        Response res = given().
                contentType(ContentType.JSON).
                with().
                pathParam("auctionId", "6").
                queryParam("index", "1").
                queryParam("count", "2").
                when().
                get("/auctions/{auctionId}");
        res.then().statusCode(200);
        System.out.println(res.getBody().asString());
    }

    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { GetListAuctionTest.class });
        testng.addListener(tla);
        testng.run();
    }

}
