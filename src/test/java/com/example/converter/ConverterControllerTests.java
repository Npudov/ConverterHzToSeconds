package com.example.converter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ConverterControllerTests {

    @BeforeAll
    public static void setup() throws Exception {
        RestAssured.port = 8080;
    }

    @Test
    public void getRequestHzToTime() {
        Response response = given()
                .contentType(ContentType.JSON)
                .param("frequency", 1000)
                .when()
                .get("/HzToTime")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("0.001", response.getBody().asString());
    }

    @Test
    public void getRequestTimeToHz() {
        Response response = given()
                .contentType(ContentType.JSON)
                .param("time", 500)
                .when()
                .get("/TimeToHz")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("0.002", response.getBody().asString());
    }

    @Test
    public void getErrorRequestHzToTime() {
        Response response = given()
                .contentType(ContentType.JSON)
                .param("frequency", 0)
                .when()
                .get("/HzToTime")
                .then()
                .extract().response();

        Assertions.assertEquals(400, response.statusCode());
        Assertions.assertEquals("Invalid Data!", response.getBody().asString());
    }
}
