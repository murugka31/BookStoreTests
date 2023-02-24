package com.emurugova.tests.groovyTests;

import com.emurugova.tests.TestBase;
import org.junit.jupiter.api.Test;

import static com.emurugova.specs.Specs.booksRequest;
import static com.emurugova.specs.Specs.booksResponse;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

public class BookStoreApiGroovyTests extends TestBase {

    @Test
    void getBookListTest() {
            given()
                    .spec(booksRequest)
                    .when()
                    .get("/BookStore/v1/Books")
                    .then()
                    .spec(booksResponse)
                    .body("books.findAll{it.isbn =~/97814.*?/}.isbn.flatten()",
                            hasItem("9781449325862"));
        }
}