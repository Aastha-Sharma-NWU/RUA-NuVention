package com.example.rua.service;

import com.example.rua.model.Roles;
import com.example.rua.model.Users;
import com.example.rua.repository.RoleRepository;
import com.example.rua.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<Users> getUsers(){
       return userRepository.findAll();
    }

    public void registerNewUser(Users user) throws IllegalAccessException {
        Users userByContactNumber=userRepository.findUserByContactNumber(user.getContactNumber());
        if(userByContactNumber != null){
            throw new IllegalAccessException("User with this phone number already exists");
            //System.out.println("User with this phone number already exists");
        }
        userRepository.save(user);
    }

    public String getUserRoleByContactNumber(String contactNumber) {
        Users user=userRepository.findUserByContactNumber(contactNumber);
        System.out.println(user);
        if(user!=null && user.getRoleId() !=null){
         Optional<Roles> oRole = roleRepository.findById(user.getRoleId());
            return oRole.get().getName();
        }
        return "Student Roles not Defined";
    }

    public void setUserRoleByContactNumber(Users user) {
       Users user1=userRepository.findUserByContactNumber(user.getContactNumber());
        if(user1!=null){
            user1.setRoleId(user.getRoleId());
            userRepository.save(user1);
        }
    }
}
