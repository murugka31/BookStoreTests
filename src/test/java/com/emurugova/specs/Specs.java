package com.emurugova.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.emurugova.filters.CustomLogFilter.customLogFilter;
import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.containsString;

public class Specs {

    public static RequestSpecification accountRequest = with ()
            .filter(customLogFilter().withCustomTemplates())
            .contentType("application/json")
            .accept("application/json")
            .log().uri()
            .log().body();

    public static RequestSpecification booksRequest = with ()
            .filter(customLogFilter().withCustomTemplates())
            .contentType("application/json")
            .log().uri()
            .log().body();

    public static ResponseSpecification accountResponse  = new ResponseSpecBuilder()
            .log(LogDetail.BODY)
            .expectStatusCode(200)
            .expectBody(containsString("success"))
            .expectBody(containsString("User authorized successfully."))
            .build();

    public static ResponseSpecification booksResponse  = new ResponseSpecBuilder()
            .log(LogDetail.BODY)
            .expectStatusCode(200)
            .build();
}
