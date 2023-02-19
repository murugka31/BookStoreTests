package com.emurugova.tests;

import com.emurugova.TestBase;
import org.junit.jupiter.api.Test;

import static com.emurugova.filters.CustomLogFilter.customLogFilter;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class AccountApiTests extends TestBase {

    @Test
    void authorizedWithTemplateTest() {
        String data = "{\"userName\": \""+userName+"\", \"password\": \""+password+"\"}";

        given()
                .filter(customLogFilter().withCustomTemplates())
                .contentType("application/json")
                .accept("application/json")
                .body(data)
                .when()
                .log().uri()
                .log().body()
                .post("/Account/v1/GenerateToken")
                .then()
                .log().body()
                .body("status", is("Success"))
                .body("result", is("User authorized successfully."));
    }

    @Test
    void generateTokenWithSchemaTest() {
        String data = "{\"userName\": \""+userName+"\", \"password\": \""+password+"\"}";

        given()
                .filter(customLogFilter().withCustomTemplates())
                .contentType("application/json")
                .accept("application/json")
                .body(data)
                .when()
                .log().uri()
                .log().body()
                .post("/Account/v1/GenerateToken")
                .then()
                .log().body()
                .body("status", is("Success"))
                .body("result", is("User authorized successfully."));
    }
}