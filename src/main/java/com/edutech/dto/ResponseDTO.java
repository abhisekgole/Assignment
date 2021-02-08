package com.edutech.dto;

import lombok.Data;

@Data
public class ResponseDTO<T> {

    private boolean status;
    private String message;
    private T data;

    public void setSuccessResponse(T data, String message) {
        this.status = true;
        this.data = data;
        this.message = message != null ? message : "";
    }

    public void setFailureResponse(String message) {
        this.status = false;
        this.data = null;
        this.message = message;
    }

}
