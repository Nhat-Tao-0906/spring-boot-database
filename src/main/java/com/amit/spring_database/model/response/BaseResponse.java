package com.amit.spring_database.model.response;

import com.amit.spring_database.model.utils.ERROR;

import lombok.Data;

@Data
public class BaseResponse<T> {
    private int code;
    private String message;
    private T data;

    public BaseResponse(ERROR error) {
        this.code = error.getCode();
        this.message = error.getMessage();
    }

    public BaseResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse() {
        this.code = ERROR.SUCCESS.getCode();
        this.message = ERROR.SUCCESS.getMessage();
    }

}
