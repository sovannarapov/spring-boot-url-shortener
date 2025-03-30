package com.sovannara.urlshortener.services;

import com.sovannara.urlshortener.entities.ShortenedUrl;

import java.util.Optional;

public interface UrlService {

    boolean existsByCode(String code);

    Optional<ShortenedUrl> findByCode(String code);

    ShortenedUrl save(ShortenedUrl shortenedUrl);

}
