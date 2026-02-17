package com.aldair.exam.springboot.webapp.springboot_web.Models;

import java.security.PrivateKey;
import java.util.UUID;
import java.util.List;

public class User {

private UUID Id;
private String Email;
private String Name;
private String Phone;
private String Password;
private String Tax_Id;
private String Created_at;
private List<Address> addresses;


public User(){}
   public User(UUID Id, String Email, String Name, String Phone, String Password, String Tax_Id, String Created_at, List<Address> addresses) {
        this.Id = Id;
        this.Email = Email;
        this.Name = Name;
        this.Phone = Phone;
        this.Password = Password;
        this.Tax_Id = Tax_Id;
        this.Created_at = Created_at;
        this.addresses = addresses;
    }

    public UUID getId() {
        return this.Id;
    }

    public void setId(UUID Id) {
        this.Id = Id;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhone() {
        return this.Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getTax_Id() {
        return this.Tax_Id;
    }

    public void setTax_Id(String Tax_Id) {
        this.Tax_Id = Tax_Id;
    }

    public String getCreated_at() {
        return this.Created_at;
    }

    public void setCreated_at(String Created_at) {
        this.Created_at = Created_at;
    }

    public List<Address> getAddresses() {
        return this.addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }



   



}
