package com.aldair.exam.springboot.webapp.springboot_web.Models.Dto;
import com.aldair.exam.springboot.webapp.springboot_web.Models.User;
import com.aldair.exam.springboot.webapp.springboot_web.Models.Address;
import java.util.List;

import java.util.UUID;

public class UserResponseDto {
    private UUID Id;
    private String Email;
    private String Name;
    private String Phone;
    private String Tax_Id;
    private String Created_at;
    private List<Address> addresses;





    public UserResponseDto(){}
    public UserResponseDto(UUID Id, String Email, String Name, String Phone, String Tax_Id, String Created_at, List<Address> addresses) {
        this.Id = Id;
        this.Email = Email;
        this.Name = Name;
        this.Phone = Phone;
        this.Tax_Id = Tax_Id;
        this.Created_at = Created_at;
        this.addresses = addresses;
    }

    public UUID getId() { return Id;}
    public String getEmail() {return Email;}
    public String getName() {return Name;}
    public String getPhone() { return Phone;}
    public String getTax_Id() { return Tax_Id;}
    public String getCreated_at() {return Created_at;}
    public List<Address> getAddresses() { return addresses;}

}
