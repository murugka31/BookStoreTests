package com.emurugova;

import com.emurugova.config.MainConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    public static MainConfig config = ConfigFactory.create(MainConfig.class);
    public String userName = config.userName();
    public String password = config.password();

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = config.baseUrl();
    }
}
