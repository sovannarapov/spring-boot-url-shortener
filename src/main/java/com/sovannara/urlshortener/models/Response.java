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
    private String statusCode;
    private String message;
    private T data;

    public Response(boolean success, String statusCode, String message, T data) {
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(true, HttpStatus.OK.toString(), "Successfully", data);
    }

    public static <T> Response<T> success() {
        return new Response<>(true, HttpStatus.OK.toString(), "Successfully", null);
    }

    public static <T> Response<T> error(String statusCode, String message) {
        return new Response<>(false, statusCode, message, null);
    }
}
