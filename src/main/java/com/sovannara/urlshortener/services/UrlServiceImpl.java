package com.sovannara.urlshortener.services;

import com.sovannara.urlshortener.entities.ShortenedUrl;
import com.sovannara.urlshortener.repositories.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {

    private final UrlRepository _repository;

    @Override
    public boolean existsByCode(String code) {
        return _repository.existsByCode(code);
    }

    @Override
    public Optional<ShortenedUrl> findByCode(String code) {
        return _repository.findByCode(code);
    }

    @Override
    public void save(ShortenedUrl shortenedUrl) {
        _repository.save(shortenedUrl);
    }

}
