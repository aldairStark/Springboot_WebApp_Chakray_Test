package com.aldair.exam.springboot.webapp.springboot_web.Models;

public class Address {
private Long Id;
private String Name;
private String Street;
private String Country_Code; 

public Address(){}

    public Address(Long Id,String Name, String Street,String Country_Code){
                this.Id=Id;
                this.Name = Name;
                this.Street = Street;
                this.Country_Code = Country_Code;
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getStreet() {
        return this.Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getCountry_Code() {
        return this.Country_Code;
    }

    public void setCountryCode(String Country_Code) {
        this.Country_Code = Country_Code;
    }

}


