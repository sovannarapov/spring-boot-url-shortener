package com.sovannara.urlshortener.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
public class Response<T> {

    private boolean success;
    private int statusCode;
    private String message;
    private T data;
    private Object metadata;

    public Response(boolean success, int statusCode, String message, T data, Object metadata) {
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
        this.metadata = metadata;
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(true, HttpStatus.OK.value(), "Successfully", data, null);
    }

    public static <T> Response<T> success() {
        return new Response<>(true, HttpStatus.OK.value(), "Successfully", null, null);
    }

    public static <T> Response<T> error(Integer statusCode, String message) {
        return new Response<>(false, statusCode, message, null, null);
    }
}
