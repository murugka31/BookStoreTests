package com.emurugova.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/config.properties"})
public interface MainConfig extends Config {

    String baseUrl();
    String userName();
    String password();
}
