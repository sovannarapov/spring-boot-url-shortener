package com.sovannara.urlshortener.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Value("${application.base-url}")
    private String baseUrl;

    @Value("${application.prefix}")
    private String prefix;

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getPrefix() {
        return prefix;
    }

}
