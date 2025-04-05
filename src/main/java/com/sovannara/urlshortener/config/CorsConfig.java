package com.sovannara.urlshortener.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig {

    @Value("${cors.allowed-origins}")
    private List<String> allowedOrigins;

    @Value("${cors.allowed-methods}")
    private List<String> allowedMethods;

    @Value("${cors.allowed-headers}")
    private List<String> allowedHeaders;

    @Value("${cors.max-age}")
    private Long maxAge;

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // Allow specific origins instead of all
        config.setAllowedOrigins(allowedOrigins);

        // Allow specific HTTP methods
        config.setAllowedMethods(allowedMethods);

        // Allow specific headers
        config.setAllowedHeaders(allowedHeaders);

        // Allow credentials if needed
        config.setAllowCredentials(true);

        // How long the response to preflight requests can be cached
        config.setMaxAge(maxAge);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", config);

        return new CorsFilter(source);
    }
}
