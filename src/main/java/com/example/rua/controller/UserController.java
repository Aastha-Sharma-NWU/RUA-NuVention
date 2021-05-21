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
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    private final UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();

    }

    @PostMapping("/register")
    public Status registerNewUser(@RequestBody Users user) throws IllegalAccessException {
        return userService.registerNewUser(user);
    }

    @PostMapping("/login")
    public Status loginUser(@Valid @RequestBody Users user) {
        Users userObj = userRepository.findUserByContactNumber(user.getContactNumber());
        if(null!=userObj ){
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


    @GetMapping("/getUserRoleByContactNumber/{contactNumber}")
    public String getUserRoleByContactNumber(@PathVariable String contactNumber){
        return userService.getUserRoleByContactNumber(contactNumber);
    }

    @PutMapping("/setUserRoleByContactNumber/{contactNumber}")
    public Status setUserRoleByContactNumber(@RequestBody Users user,@PathVariable String contactNumber) {
        return userService.setUserRoleByContactNumber(user,contactNumber);
    }

    @GetMapping("/getUserWeeklyLogs/{contactNumber}")
    public WeeklyLogs getUserWeeklyLogsByContactNumber(@PathVariable String contactNumber){
        return userService.getUserWeeklyLogsByContactNumber(contactNumber);
    }

    @PostMapping("/setUserWeeklyLogs/{contactNumber}")
    public Status setUserWeeklyLogsByContactNumber(@RequestBody WeeklyLogs weekLogs, @PathVariable String contactNumber){
         return userService.setUserWeeklyLogsByContactNumber(weekLogs,contactNumber);
    }

    @PutMapping("/updateUserProfile/{contactNumber}")
     public Status updateUserProfile(@RequestBody Users user,@PathVariable String contactNumber){
        return userService.updateUserProfileByContactNumber(user,contactNumber);
    }

}
