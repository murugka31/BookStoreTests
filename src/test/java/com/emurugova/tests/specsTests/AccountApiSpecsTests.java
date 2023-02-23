package com.emurugova.tests.specsTests;

import com.emurugova.TestBase;
import org.junit.jupiter.api.Test;

import static com.emurugova.specs.Specs.requestSpecification;
import static com.emurugova.specs.Specs.responseSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class AccountApiSpecsTests extends TestBase {

    @Test
    void authorizedWithTemplateTest() {
        String data = "{\"userName\": \""+userName+"\", \"password\": \""+password+"\"}";

        given()
                .spec(requestSpecification)
                .body(data)
                .when()
                .post("/Account/v1/GenerateToken")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void generateTokenWithSchemaTest() {
        String data = "{\"userName\": \""+userName+"\", \"password\": \""+password+"\"}";

        given()
                .spec(requestSpecification)
                .body(data)
                .when()
                .post("/Account/v1/GenerateToken")
                .then()
                .log().body()
                .spec(responseSpecification);
    }
}