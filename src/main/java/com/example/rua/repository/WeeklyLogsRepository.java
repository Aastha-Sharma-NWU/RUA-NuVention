package com.example.rua.repository;

import com.example.rua.model.WeeklyLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface WeeklyLogsRepository extends JpaRepository<WeeklyLogs,Long> {

    WeeklyLogs findWeeklyLogsByContactNumber(String contactNUmber);

     void deleteWeeklyLogsByContactNumber(String contactNumber);
}