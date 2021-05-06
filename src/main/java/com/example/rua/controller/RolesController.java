package com.example.rua.controller;


import com.example.rua.model.Roles;
import com.example.rua.model.Users;
import com.example.rua.service.RoleService;
import com.example.rua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/rua/api/roles")
public class RolesController {

    private final RoleService roleService;

    @Autowired
    public RolesController(RoleService roleService) {
        this.roleService = roleService;
    }


    @GetMapping
    public List<Roles> getRoles(){
        return roleService.getRoles();

    }

    @PostMapping
    public void addNewRoles(@RequestBody Roles role) throws IllegalAccessException {
        roleService.addNewRole(role);
    }
}
