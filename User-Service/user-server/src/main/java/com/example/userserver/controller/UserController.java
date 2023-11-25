package com.example.userserver.controller;

import com.example.userserver.dto.UserDTO;
import com.example.userserver.service.UserService;
import com.example.userserver.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(params = {"username", "password"})
    public boolean addUser(String username, String password){
        UserDTO dto = new UserDTO(username, password);
        userService.addUser(dto);
        return true;
    }

    @GetMapping
    public ResponseUtil getAllUser(){
        return new ResponseUtil("Ok","Successfully Loaded", null);
    }

}