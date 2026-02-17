package com.aldair.exam.springboot.webapp.springboot_web.controllers;


import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aldair.exam.springboot.webapp.springboot_web.Models.User;
import com.aldair.exam.springboot.webapp.springboot_web.Models.Dto.DeleteUserResponseDto;
import com.aldair.exam.springboot.webapp.springboot_web.Models.Dto.UpdateResponseDto;
import com.aldair.exam.springboot.webapp.springboot_web.Models.Dto.UpdateUserDto;
import com.aldair.exam.springboot.webapp.springboot_web.Models.Dto.UserRequestDto;
import com.aldair.exam.springboot.webapp.springboot_web.Models.Dto.UserResponseDto;
import com.aldair.exam.springboot.webapp.springboot_web.Servicios.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;
    public UserController(UserService service){
        this.service =service;
    }
  /*   @GetMapping("/users")
    public List<User> getUsers() {
        return service.getAllUsers();
    } */
    //==============================================
    // GET
    //==============================================
    @GetMapping
   /*  public List<User> getUsers(@RequestParam(required = false)String sortedBy) {
        return service.getUsers(sortedBy);
    } */
    public List<UserResponseDto> getUsers(@RequestParam(required = false)String sortedBy,@RequestParam(required = false)String filter) {
        return service.getUsers(sortedBy,filter);
    }
    /* @GetMapping("/details") 
    public String details(Model model){
        model.addAttribute("Title","Hola Mundo Spring Boot");
        model.addAttribute("Name","Jose Aldair");
        model.addAttribute("LastName","Nava Correa");

         return "details";
    }
    */ //=================================================
    //CREATE
     //=================================================
    @PostMapping
    public UserResponseDto CreateUser(@Valid @RequestBody UserRequestDto request) {
        //TODO: process POST request
        
        return service.CreateUser(request);
    }
    //=================================================
    //UPDATE
    //=================================================
    @PatchMapping("/{id}")
    public UpdateResponseDto updateUser(@PathVariable String id, @RequestBody UpdateUserDto request){

        System.out.println("ID: " + id);
        System.out.println("Request: " + request);
        String convert = id.toString().replace("{", "").replace("}", "").replace(" ", "");
        System.out.println("Convert: " + convert);
        System.out.println("Longitud: " + convert.length());
UUID uuid = UUID.fromString(convert);
System.out.println("UUID: " + uuid);

        return service.UpdateUser(uuid,request);
    }
     //=================================================
     //DELETE
      //=================================================
    @DeleteMapping("/{id}")
    public DeleteUserResponseDto deleteUsers(@PathVariable String id){

        System.out.println("ID: " + id);
       
        String convert = id.toString().replace("{", "").replace("}", "").replace(" ", "");
        System.out.println("Convert: " + convert);
        System.out.println("Longitud: " + convert.length());
UUID uuid = UUID.fromString(convert);
System.out.println("UUID: " + uuid);
            return service.DeleteUser(uuid);

    }
  /*    @GetMapping("/details") 
    public String details(Map<String,Object> model){
        model.put("Title","Hola Mundo Spring Boot");
        model.put("Name","Jose Aldair");
        model.put("LastName","Nava Correa");

         return "details";
    } */
 }
 
