package org.jsonplaceholder;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class JsonDemoApi {

    @Test
    public void getAlbums() {

        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
        Response response = given().
                header("Accept", "application/json").
                when().get("/albums");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
    }
   @Test
    public void getPhotos() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
        given().
                header("Accept", "application/json").
                when().get("/photos").
                then().statusCode(200).
                body("[0].userID" , equalTo(1) );

    }

    @Test
    public void getTodos() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
        Response response = given().
                header("Accept" , "application/json").
                when().get("/todos");
                System.out.println(response.statusCode());
                System.out.println(response.asString());
//                then().statusCode(200).
//                body("[0]", equalTo(1));
    }

    @Test
    public void getUsers() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
        given().
                header("Accept" , "application/json").
                when().get("/users").
                then().
                log().all().
                statusCode(200).
                body("[0].userID", equalTo(1));
    }
}



