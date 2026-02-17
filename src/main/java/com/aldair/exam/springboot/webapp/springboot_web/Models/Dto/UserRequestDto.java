package com.aldair.exam.springboot.webapp.springboot_web.Models.Dto;
import com.aldair.exam.springboot.webapp.springboot_web.Models.User;
import com.aldair.exam.springboot.webapp.springboot_web.Utils.ValidacionPhone;
import com.aldair.exam.springboot.webapp.springboot_web.Utils.ValidacionRFC;
import com.aldair.exam.springboot.webapp.springboot_web.Models.Address;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

public class UserRequestDto {
    @NotBlank(message= "Email es obligatorio")
    @Email(message = "Formato de email incorrecto")
    private String email;
        @NotBlank(message= "Nombre es obligatorio")
    private String name;
        @ValidacionPhone
        @NotBlank(message= "Telefono es obligatorio")
    private String phone;
        @NotBlank(message= "Password es obligatorio")
    private String password;
        @ValidacionRFC
        @NotBlank(message= "TaxId es obligatorio")
    private String tax_id;

    private List<Address> addresses;

    public UserRequestDto(){}

    public String getEmail() { return email;}
    public String getName() { return name; }
    public String getPhone() {return phone;}
    public String getPassword() { return password;}
    public String getTax_Id() {return tax_id;}   
    public List<Address> getAddresses() {return addresses;}
    
    public void setEmail(String email) {
        this.email = email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setTax_Id(String tax_id) {
        this.tax_id = tax_id;
    }
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
