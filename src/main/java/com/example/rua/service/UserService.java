package com.example.rua.service;

import com.example.rua.model.Roles;
import com.example.rua.model.Status;
import com.example.rua.model.Users;
import com.example.rua.model.WeeklyLogs;
import com.example.rua.repository.RoleRepository;
import com.example.rua.repository.UserRepository;
import com.example.rua.repository.WeeklyLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final WeeklyLogsRepository weeklyLogsRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, WeeklyLogsRepository weeklyLogsRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.weeklyLogsRepository = weeklyLogsRepository;
    }

    public List<Users> getAllUsers(){
       return userRepository.findAll();
    }


    public Status registerNewUser(Users user) throws IllegalAccessException {
        Users userByContactNumber=userRepository.findUserByContactNumber(user.getContactNumber());
        if(userByContactNumber != null){
            return Status.FAILURE;
        }
        userRepository.save(user);
        return Status.SUCCESS;
    }

    public String getUserRoleByContactNumber(String contactNumber) {
        Users user=userRepository.findUserByContactNumber(contactNumber);
        System.out.println(user);
        if(user!=null && user.getRoleId() !=null){
         Optional<Roles> oRole = roleRepository.findById(user.getRoleId());
            return oRole.get().getName();
        }
        return user.getName()+" has not selected role yet";
    }

    public Status setUserRoleByContactNumber(Users user) {
       Users user1=userRepository.findUserByContactNumber(user.getContactNumber());
        if(user1!=null){
            user1.setRoleId(user.getRoleId());
            userRepository.save(user1);
            return Status.SUCCESS;
        }
       return Status.FAILURE;
    }

    public Status setUserWeeklyLogsByContactNumber(WeeklyLogs weekLogs,String contactNumber) {
        WeeklyLogs logs=weeklyLogsRepository.findWeeklyLogsByContactNumber(contactNumber);
        if(logs==null){
            //set weekStartDate and weekEndDate
            LocalDate today = LocalDate.now();
            LocalDate weekStartDate= findWeekStartDate(today);
            LocalDate weekEndDate=findWeekEndDate(today);
            weekLogs.setWeekStartDate(weekStartDate);
            weekLogs.setWeekEndDate(weekEndDate);
            weekLogs.setContactNumber(contactNumber);
            //save weekly logs
            weeklyLogsRepository.save(weekLogs);
            return Status.SUCCESS;
        }else{
            logs.setContactNumber(contactNumber);
//            logs.setAudioCalls(logs.getAudioCalls()+weekLogs.getAudioCalls());
//            logs.setVideoCalls(logs.getVideoCalls()+weekLogs.getVideoCalls());
//            logs.setTextMessages(logs.getTextMessages()+weekLogs.getTextMessages());
//            or
//            logs.setAudioCalls(logs.getAudioCalls()+1);
//            logs.setVideoCalls(logs.getVideoCalls()+1);
//            logs.setTextMessages(logs.getTextMessages()+1);
//            or
            logs.setAudioCalls(weekLogs.getAudioCalls());
            logs.setVideoCalls(weekLogs.getVideoCalls());
            logs.setTextMessages(weekLogs.getTextMessages());
            weeklyLogsRepository.save(logs);
            return Status.SUCCESS;
        }
    }

    public WeeklyLogs getUserWeeklyLogsByContactNumber(String contactNumber) {

        WeeklyLogs weeklyLogs=weeklyLogsRepository.findWeeklyLogsByContactNumber(contactNumber);
        if(weeklyLogs==null){
            weeklyLogs= new WeeklyLogs();
            LocalDate today = LocalDate.now();
            LocalDate weekStartDate= findWeekStartDate(today);
            LocalDate weekEndDate=findWeekEndDate(today);
            weeklyLogs.setWeekStartDate(weekStartDate);
            weeklyLogs.setWeekEndDate(weekEndDate);
            weeklyLogs.setContactNumber(contactNumber);
            weeklyLogs.setAudioCalls(0);
            weeklyLogs.setVideoCalls(0);
            weeklyLogs.setTextMessages(0);
            return weeklyLogs;
            //return new WeeklyLogs();
        }else{
            return weeklyLogs;
        }
   }

   public LocalDate findWeekStartDate(LocalDate today){
       LocalDate monday = today;
       while (monday.getDayOfWeek() != DayOfWeek.MONDAY)
       {
           monday = monday.minusDays(1);
       }
     return monday;
   }

    public LocalDate findWeekEndDate(LocalDate today){
        LocalDate sunday = today;
        while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY)
        {
            sunday = sunday.plusDays(1);
        }
      return sunday;
    }

}


