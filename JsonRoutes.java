package org.jsonplaceholder;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class JsonRoutes {

    @Test
    public void getPosts() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        Response response = given().
                header("Accept", "application/json").
                when().get("/posts");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
    }

    @Test
    public static void getPostPostId_1() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
        given().
                pathParam("userId", 1).
                when().
                get("posts/{userId}").
                then().
                log().all().
                statusCode(200).
                body("userId", equalTo(1));
    }

    @Test
    public void getPostPostId_1Comments() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
        given().
                pathParam("userId", 1).
                when().
                get("posts/{userId}/Comments").
                then().
                log().all().
                statusCode(200).
                body("[0].userId", equalTo(null));
    }

    @Test
    public void getCommentsQueryPostId_1() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
        given().
                header("Accept", "application/json").
                queryParam(("postId"), 0).
                when().
                get("/comments/{postId}").
                then().
                log().all().
                statusCode(200).
                body("[0].userId", equalTo(0));
    }

    @Test
    public static void putPostPostId_1() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
        given().
                header("Accept", "application/json").
                //pathParam("userId", 1).
                when().
                put("/posts/{postId}").
                then().
                log().all().
                statusCode(200).
                body("userId", equalTo(1));
    }
}

