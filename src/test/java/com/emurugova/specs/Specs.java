package com.emurugova.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.emurugova.filters.CustomLogFilter.customLogFilter;
import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.containsString;

public class Specs {

    public static RequestSpecification requestSpecification = with ()
            .filter(customLogFilter().withCustomTemplates())
            .contentType("application/json")
            .accept("application/json")
            .log().uri()
            .log().body();

    public static ResponseSpecification responseSpecification  = new ResponseSpecBuilder()
            .log(LogDetail.BODY)
            .expectStatusCode(200)
            .expectBody(containsString("success"))
            .expectBody(containsString("User authorized successfully."))
            .build();
}
