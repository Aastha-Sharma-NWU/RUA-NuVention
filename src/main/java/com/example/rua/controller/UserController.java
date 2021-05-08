package com.example.rua.controller;

import com.example.rua.model.Communication;
import com.example.rua.model.Users;
import com.example.rua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/rua/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<Users> getUsers(){
        return userService.getUsers();

    }

    @PostMapping
    public void registerNewUser(@RequestBody Users user) throws IllegalAccessException {
        userService.registerNewUser(user);
    }

    @GetMapping("/getUserRoleByContactNumber/{contactNumber}")
    public String getUserRoleByContactNumber(@PathVariable String contactNumber){
        return userService.getUserRoleByContactNumber(contactNumber);
    }

    @PostMapping("/setUserRoleByContactNumber")
    public void setUserRoleByContactNumber(@RequestBody Users user) {

        userService.setUserRoleByContactNumber(user);
    }

    @GetMapping("/getUserWeeklyLogs/{contactNumber}")
    public Communication getUserWeeklyLogsByContactNumber(@PathVariable String contactNumber){
        return userService.getUserWeeklyLogsByContactNumber(contactNumber);
    }


}
