package com.emurugova.tests.specsTests;

import com.emurugova.tests.TestBase;
import org.junit.jupiter.api.Test;

import static com.emurugova.specs.Specs.booksRequest;
import static com.emurugova.specs.Specs.booksResponse;
import static io.restassured.RestAssured.given;

public class BookStoreApiSpecsTests extends TestBase {

    @Test
    void getBooksListTest() {
        given()
                .spec(booksRequest)
                .when()
                .get("/BookStore/v1/Books")
                .then()
                .spec(booksResponse);
    }
}