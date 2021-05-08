package com.example.rua.repository;

import com.example.rua.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    //Select * from users where contactNumber=?
    //@Query("SELECT s FROM Users s WHERE s.contactNumber=?1")
    Users findUserByContactNumber(String contactNumber);


}
