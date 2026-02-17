package com.aldair.exam.springboot.webapp.springboot_web.Models.Dto;

public class LoginResponseDto {
 private String timestamp;
 private String message;
 private String taxId;
 private String tokenAuth;

    public String getTimestamp() {
        return this.timestamp;
    }
    public String getMessage() {
        return this.message;
    }
    public String getTaxId() {
        return this.taxId;
    }
    public String getTokenAuth() {
        return this.tokenAuth;
    }
    public LoginResponseDto(String timestamp, String message, String taxId, String tokenAuth) {
        this.timestamp = timestamp;
        this.message = message;
        this.taxId = taxId;
        this.tokenAuth = tokenAuth;
    }

}
