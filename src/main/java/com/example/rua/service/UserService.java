package com.example.rua.service;

import com.example.rua.model.Users;
import com.example.rua.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getUsers(){
       return userRepository.findAll();
    }

    public void registerNewUser(Users user) throws IllegalAccessException {
        Optional<Users> userByContactNumber=userRepository.findUserByContactNumber(user.getContactNumber());
        if(userByContactNumber.isPresent()){
            throw new IllegalAccessException("User with this phone number already exists");
            //System.out.println("User with this phone number already exists");
        }
        userRepository.save(user);
    }
}
