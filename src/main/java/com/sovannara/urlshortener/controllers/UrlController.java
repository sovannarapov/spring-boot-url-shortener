package com.sovannara.urlshortener.controllers;

import com.sovannara.urlshortener.config.ApplicationConfig;
import com.sovannara.urlshortener.dtos.CreateShortUrlRequest;
import com.sovannara.urlshortener.dtos.UrlResponse;
import com.sovannara.urlshortener.entities.ShortenedUrl;
import com.sovannara.urlshortener.exceptions.UrlNotFoundException;
import com.sovannara.urlshortener.models.ApiResponse;
import com.sovannara.urlshortener.services.UrlService;
import com.sovannara.urlshortener.services.UrlShorteningService;
import com.sovannara.urlshortener.utils.UrlValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.InvalidUrlException;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/url")
@RequiredArgsConstructor
public class UrlController {

    private final UrlService _service;
    private final UrlShorteningService _urlShorteningService;
    private final ApplicationConfig _config;

    @PostMapping("/create")
    public ApiResponse<UrlResponse> createShortUrl(@Validated @RequestBody CreateShortUrlRequest request) {
        if (!UrlValidator.isValid(request.getUrl())) {
            throw new InvalidUrlException("Invalid URL format");
        }

        String code = _urlShorteningService.generateUniqueCode();
        String shortUrl = String.format("%s%s/url/%s", _config.getBaseUrl(), _config.getPrefix(), code);

        ShortenedUrl shortenedUrl = ShortenedUrl.builder()
                .longUrl(request.getUrl())
                .shortUrl(shortUrl)
                .code(code)
                .createdOn(LocalDateTime.now())
                .build();

        _service.save(shortenedUrl);

        return ApiResponse.success(new UrlResponse(shortUrl));
    }

    @GetMapping("/{code}")
    public ResponseEntity<String> redirectToLongUrl(@PathVariable String code) {
        ShortenedUrl shortenedUrl = _service.findByCode(code)
                .orElseThrow(() -> new UrlNotFoundException("URL not found"));

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(shortenedUrl.getLongUrl()))
                .build();
    }

}
