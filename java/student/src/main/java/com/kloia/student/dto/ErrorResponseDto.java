package com.kloia.student.dto;

import lombok.Data;

import java.util.List;

@Data
public class ErrorResponseDto {

    public ErrorResponseDto(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }

    private String message;
    private List<String> details;

}

