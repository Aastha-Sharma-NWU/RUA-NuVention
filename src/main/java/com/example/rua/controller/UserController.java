package com.example.rua.controller;

import com.example.rua.model.Status;
import com.example.rua.model.Users;
import com.example.rua.model.WeeklyLogs;
import com.example.rua.repository.UserRepository;
import com.example.rua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


import java.util.List;

@RestController
@RequestMapping(path="/rua/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<Users> getUsers(){
        return userService.getUsers();

    }


    @PostMapping("/login")
    public Status loginUser(@Valid @RequestBody Users user) {
        Users userObj = userRepository.findUserByContactNumber(user.getContactNumber());
        if(null!=userObj){
            userObj.setLoggedIn(true);
            userRepository.save(userObj);
            return Status.SUCCESS;
        }
        return Status.FAILURE;
    }


    @PostMapping("/logout")
    public Status logUserOut(@Valid @RequestBody Users user) {
        Users userObj = userRepository.findUserByContactNumber(user.getContactNumber());
        if(null!=userObj){
            userObj.setLoggedIn(false);
            userRepository.save(userObj);
            return Status.SUCCESS;
        }
        return Status.FAILURE;
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
    public WeeklyLogs getUserWeeklyLogsByContactNumber(@PathVariable String contactNumber){
        return userService.getUserWeeklyLogsByContactNumber(contactNumber);
    }

    @PostMapping("/setUserWeeklyLogs/{contactNumber}")
    public void setUserWeeklyLogsByContactNumber(@RequestBody WeeklyLogs weekLogs, @PathVariable String contactNumber){
         userService.setUserWeeklyLogsByContactNumber(weekLogs,contactNumber);
    }

}
