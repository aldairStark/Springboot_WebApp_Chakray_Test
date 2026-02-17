package com.aldair.exam.springboot.webapp.springboot_web.Models.Dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequestDto {
@NotBlank(message="TaxId es Obligatorio")
private String taxtId;
@NotBlank(message = "password es obligatoria")
private String password;

    public String getTaxtId() {
        return this.taxtId;
    }

    public void setTaxtId(String taxtId) {
        this.taxtId = taxtId;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
