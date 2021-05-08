package com.example.rua.service;

import com.example.rua.model.Roles;
import com.example.rua.model.Users;
import com.example.rua.model.WeeklyLogs;
import com.example.rua.repository.RoleRepository;
import com.example.rua.repository.UserRepository;
import com.example.rua.repository.WeeklyLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void setUserWeeklyLogsByContactNumber(WeeklyLogs weekLogs,String contactNumber) {
        WeeklyLogs logs=weeklyLogsRepository.findWeeklyLogsByContactNumber(contactNumber);
        if(logs==null){
            weeklyLogsRepository.save(weekLogs);
        }else{
            logs.setContactNumber(contactNumber);
            logs.setAudioCalls(logs.getAudioCalls()+weekLogs.getAudioCalls());
            logs.setVideoCalls(logs.getVideoCalls()+weekLogs.getVideoCalls());
            logs.setTextMessages(logs.getTextMessages()+weekLogs.getTextMessages());
            weeklyLogsRepository.save(logs);
        }
    }

    public WeeklyLogs getUserWeeklyLogsByContactNumber(String contactNumber) {
        LocalDate localDate = LocalDate.now();

        WeeklyLogs weeklyLogs=weeklyLogsRepository.findWeeklyLogsByContactNumber(contactNumber);
        if(weeklyLogs==null){
            return new WeeklyLogs();
        }else{
            return weeklyLogs;
        }
   }

    public static Date getWeekStartDate() {
        Calendar calendar = Calendar.getInstance();
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DATE, -1);
        }
        return calendar.getTime();
    }

    public static Date getWeekEndDate() {
        Calendar calendar = Calendar.getInstance();
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DATE, 1);
        }
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }
}


/*
private LocalDate weekStartDate;
    private LocalDate weekEndDate;
    private Integer audioCalls;
    private Integer videoCalls;
    private Integer textMessages;
 */