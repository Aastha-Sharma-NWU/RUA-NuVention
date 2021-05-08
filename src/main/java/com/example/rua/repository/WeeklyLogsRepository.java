package com.example.rua.repository;

import com.example.rua.model.Roles;
import com.example.rua.model.WeeklyLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeeklyLogsRepository extends JpaRepository<WeeklyLogs,Long> {

    WeeklyLogs findWeeklyLogsByContactNumber(String contactNUmber);
}