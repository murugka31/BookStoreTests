package com.emurugova.tests;

import com.emurugova.TestBase;
import org.junit.jupiter.api.Test;

import static com.emurugova.filters.CustomLogFilter.customLogFilter;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class BookStoreApiTests extends TestBase {

    @Test
    void getBooksListTestWithNoLogs() {
       given()
               .get("/BookStore/v1/Books")
               .then()
               .body("books", hasSize(greaterThan(0)));
    }

    @Test
    void getBooksListWithAllLogs() {
        given()
                .filter(customLogFilter().withCustomTemplates())
                .log().all()
                .get("/BookStore/v1/Books")
                .then()
                .log().all()
                .body("books", hasSize(greaterThan(0)));
    }

    @Test
    void getBooksListWithSomeLogs() {
        given()
                .filter(customLogFilter().withCustomTemplates())
                .log().uri()
                .log().body()
                .get("/BookStore/v1/Books")
                .then()
                .log().body()
                .body("books", hasSize(greaterThan(0)));
    }

}