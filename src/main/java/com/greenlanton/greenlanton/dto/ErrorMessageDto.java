package com.greenlanton.greenlanton.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessageDto {

    private String success;
    private String errorMessage;

    public ErrorMessageDto(String success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }
}
