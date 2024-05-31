package com.example.demo.controllers;

import com.example.demo.models.UserModel;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("get-first-name")
    public String getFirstName(){
        return "Milos";
    }

    @GetMapping("get-first-name-list")
    public List<String> getFirstNameList(){
        return List.of("Milos", "Janko");
    }

    @PostMapping("create-user")
    public boolean createUser(String firstName, String lastName){
        return true;
    }

    @PostMapping("create-user-body")
    public ResponseEntity<?> createUserBody(@RequestBody @Valid UserModel UserModel, BindingResult result){
        if (result.hasErrors()){
            return new ResponseEntity<>("Neuspesno registrovan!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<UserModel>(UserModel, HttpStatus.CREATED);
    }
}
