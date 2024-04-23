package com.bhe.config;

import org.aeonbits.owner.Config;
import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/api-config.properties"
})

public interface APIConfig extends Config {
    @Key("base_url")
    String apiBaseURL();

    @Key("token")
    String token();

    @Key("token2")
    String token2();

    @Key("Cookie")
    String cookie();

    @Key("Content-Type")
    String contentType();

    @Key("Content-Length")
    String contentLength();

    @Key("Host")
    String host();

    @Key("User-Agent")
    String userAgent();

    @Key("Accept-Encoding")
    String acceptEncod();

    @Key("Connection")
    String connection();

    @Key("Postman-Token")
    String postmanToken();

    @Key("Cache-Control")
    String cacheControl();

    @Key("Accept")
    String accept();

    @Key("grant_type")
    String grantType();

    @Key("client_id")
    String clientId();

    @Key("client_secret")
    String clientSec();

    @Key("username")
    String username();

    @Key("password")
    String password();

    @Key("secretToken")
    String secretToken();

    @DefaultValue("http://127.0.0.1:4723/")
    URL localAppiumServerUrl();
}
