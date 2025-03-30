package com.sovannara.urlshortener.utils;

import java.net.URI;

public class UrlValidator {

    public static boolean isValid(String url) {
        try {
            new URI(url);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
