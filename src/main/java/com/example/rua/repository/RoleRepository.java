package com.example.rua.repository;

import com.example.rua.model.Roles;
import com.example.rua.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Integer> {

    //Select * from roles where name=?
    @Query("SELECT s FROM Roles s WHERE s.name=?1")
    Optional<Roles> findRoleByName(String name);



}