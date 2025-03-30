package com.sovannara.urlshortener.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class UrlShorteningService {

    private static final int NumberOfCharsInShortLink = 7;
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private final Random _random = new Random();
    private final UrlServiceImpl _repository;

    public String generateUniqueCode() {
        String code;

        do {
            code = generateCode();
        } while (_repository.existsByCode(code));

        return code;
    }

    private String generateCode() {
        StringBuilder codeBuilder = new StringBuilder(NumberOfCharsInShortLink);

        for (int i = 0; i < NumberOfCharsInShortLink; i++) {
            int randomIndex = _random.nextInt(ALPHABET.length());
            codeBuilder.append(ALPHABET.charAt(randomIndex));
        }

        return codeBuilder.toString();
    }

}
