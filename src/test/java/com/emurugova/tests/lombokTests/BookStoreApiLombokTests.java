package com.emurugova.tests.lombokTests;

import com.emurugova.lombok.BooksData;
import com.emurugova.specs.Specs;
import com.emurugova.tests.TestBase;
import org.junit.jupiter.api.Test;

import static com.emurugova.specs.Specs.booksResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookStoreApiLombokTests extends TestBase {

    @Test
    void getFromBookListTest() {
        BooksData booksData =  Specs.booksRequest
                .when()
                .get("/BookStore/v1/Books")
                .then()
                .spec(booksResponse)
                .extract().as(BooksData.class);

        assertEquals("9781449325862", booksData.getBooks().get(0).getIsbn());
        assertEquals("Git Pocket Guide", booksData.getBooks().get(0).getTitle());
        assertEquals("Richard E. Silverman", booksData.getBooks().get(0).getAuthor());
        assertEquals("2020-06-04T08:48:39.000Z", booksData.getBooks().get(0).getPublishDate());
        assertEquals(234, booksData.getBooks().get(0).getPages());
    }

    @Test
    void getCertainBookTest() {
        BooksData booksData =  Specs.booksRequest
                .when()
                .get("/BookStore/v1/"+"Book?ISBN=9781449325862")
                .then()
                .spec(booksResponse)
                .extract().as(BooksData.class);

        assertEquals("9781449325862", booksData.getIsbn());
        assertEquals("Git Pocket Guide", booksData.getTitle());
        assertEquals("Richard E. Silverman", booksData.getAuthor());
        assertEquals("2020-06-04T08:48:39.000Z", booksData.getPublishDate());
        assertEquals(234, booksData.getPages());
    }
}
