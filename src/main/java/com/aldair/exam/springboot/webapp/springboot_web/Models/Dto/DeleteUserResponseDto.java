package com.aldair.exam.springboot.webapp.springboot_web.Models.Dto;

public class DeleteUserResponseDto {
 private String timestamp;
 private String message;
 private String taxId;
public UserResponseDto userResponse;


    public DeleteUserResponseDto(String timestamp, String message, String taxId, UserResponseDto userResponse) {
        this.timestamp = timestamp;
        this.message = message;
        this.taxId = taxId;
        this.userResponse = userResponse;
    }
    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTaxId() {
        return this.taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public UserResponseDto getUserResponse() {
        return this.userResponse;
    }

    public void setUserResponse(UserResponseDto userResponse) {
        this.userResponse = userResponse;
    }

}
