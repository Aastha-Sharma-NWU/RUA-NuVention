package com.example.rua.repository;

import com.example.rua.model.Roles;
import com.example.rua.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SurveyRepository extends JpaRepository<Survey,Long> {

    //Check if survey data is filled by current user which can be a student or a parent
    //@Query("select s from Survey s " + "where (s.parentId= userId) "
    //        + "or (s.studentId=userId) ")

    Long findUserIdByParentId(Long parentId);
    Long findUserIdByStudentId(Long studentId);

    Survey findUserByParentId(Long parentId);
    Survey findUserByStudentId(Long studentId);

}