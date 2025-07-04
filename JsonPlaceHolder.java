package org.jsonplaceholder;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class JsonPlaceHolder {

    @Test
    public void getPost() {

        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
        Response response=  given().
                header("Accept", "application/json").
                when().get("/posts");
        System.out.println(response.statusCode());
        System.out.println(response.asString());


    }

    @Test
    public void getPostVerification() {

        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
        given().
                header("Accept", "application/json").
                when().get("/posts").
                then().statusCode(200).
                body("[0].userId", equalTo(1));

    }
@Test
    public void getPostPostId_1(){
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
        given().
                pathParam("userId", 1).
                when().
                get("posts/{userId}").
                then().
                log().all().
                statusCode(200).
                body("userId" , equalTo(1));
}
}
