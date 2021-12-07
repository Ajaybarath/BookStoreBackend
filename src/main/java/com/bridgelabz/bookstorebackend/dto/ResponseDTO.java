package com.bridgelabz.bookstorebackend.dto;

import lombok.Data;

public @Data
class ResponseDTO {

    String message;
    Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}