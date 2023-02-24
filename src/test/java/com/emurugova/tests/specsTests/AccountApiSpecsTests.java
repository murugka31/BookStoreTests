package com.emurugova.tests.specsTests;

import com.emurugova.tests.TestBase;
import org.junit.jupiter.api.Test;

import static com.emurugova.specs.Specs.*;
import static io.restassured.RestAssured.given;

public class AccountApiSpecsTests extends TestBase {

    @Test
    void authorizedWithTemplateTest() {
        String data = "{\"userName\": \""+userName+"\", \"password\": \""+password+"\"}";

        given()
                .spec(accountRequest)
                .body(data)
                .when()
                .post("/Account/v1/GenerateToken")
                .then()
                .spec(accountResponse);
    }

    @Test
    void generateTokenWithSchemaTest() {
        String data = "{\"userName\": \""+userName+"\", \"password\": \""+password+"\"}";

        given()
                .spec(accountRequest)
                .body(data)
                .when()
                .post("/Account/v1/GenerateToken")
                .then()
                .log().body()
                .spec(accountResponse);
    }
}