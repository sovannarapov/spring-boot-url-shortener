package com.sovannara.urlshortener.repositories;

import com.sovannara.urlshortener.entities.ShortenedUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UrlRepository extends JpaRepository<ShortenedUrl, UUID> {

    boolean existsByCode(String code);

    Optional<ShortenedUrl> findByCode(String code);

}
