package com.sovannara.urlshortener.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
public class ApiResponse<T> {

    private boolean success;
    private String statusCode;
    private String message;
    private T data;

    public ApiResponse(boolean success, String statusCode, String message, T data) {
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, HttpStatus.OK.toString(), "Successfully", data);
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(true, HttpStatus.OK.toString(), "Successfully", null);
    }

    public static <T> ApiResponse<T> error(String statusCode, String message) {
        return new ApiResponse<>(false, statusCode, message, null);
    }
}
