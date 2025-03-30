package com.sovannara.urlshortener.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "shortened_urls", indexes = {@Index(name = "idx_shortened_url_code", columnList = "code", unique = true)})
public class ShortenedUrl {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "long_url")
    private String longUrl;

    @Column(name = "short_url")
    private String shortUrl;

    @Column(unique = true, length = 7)
    private String code;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

}
