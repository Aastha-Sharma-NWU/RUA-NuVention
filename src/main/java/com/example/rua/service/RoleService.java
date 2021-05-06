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
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Roles> getRoles(){
        return roleRepository.findAll();
    }

    public void addNewRole(Roles role) throws IllegalAccessException {
        Optional<Roles> findRoleByName=roleRepository.findRoleByName(role.getName());
        if(findRoleByName.isPresent()){
            throw new IllegalAccessException("Role already exists");
            //System.out.println("User with this phone number already exists");
        }
        roleRepository.save(role);
    }
}
