package com.aldair.exam.springboot.webapp.springboot_web.Models.Dto;

public class UpdateResponseDto {

     private String timestamp;
 private String message;
 private String taxId;
public UserResponseDto userResponse;

    public UpdateResponseDto(String timestamp, String message, String taxId, UserResponseDto userResponse) {
        this.timestamp = timestamp;
        this.message = message;
        this.taxId = taxId;
        this.userResponse = userResponse;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getMessage() {
        return this.message;
    }

    public String getTaxId() {
        return this.taxId;
    }

    public UserResponseDto getUserResponse() {
        return this.userResponse;
    }
}
