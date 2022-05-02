package com.greenlanton.greenlanton.dto;

import lombok.Getter;

@Getter
public class SignupRequestDto {
    private String username; // id
    private String password; // pw
    private String email; // 이메일
    private String nickname; // 닉네임
}
