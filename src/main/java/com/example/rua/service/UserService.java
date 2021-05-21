package com.example.rua.service;

import com.example.rua.model.*;
import com.example.rua.repository.RoleRepository;
import com.example.rua.repository.SurveyRepository;
import com.example.rua.repository.UserRepository;
import com.example.rua.repository.WeeklyLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final WeeklyLogsRepository weeklyLogsRepository;
    private final SurveyRepository surveyRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, WeeklyLogsRepository weeklyLogsRepository, SurveyRepository surveyRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.weeklyLogsRepository = weeklyLogsRepository;
        this.surveyRepository = surveyRepository;
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

//    public Status setUserRoleByContactNumber(Users user) {
//       Users currentUser=userRepository.findUserByContactNumber(user.getContactNumber());
//        if(currentUser!=null){
//            currentUser.setRoleId(user.getRoleId());
//            userRepository.save(currentUser);
//            return Status.SUCCESS;
//        }
//       return Status.FAILURE;
//    }

    public Status setUserRoleByContactNumber(Users user,String contactNumber) {
        Users currentUser=userRepository.findUserByContactNumber(contactNumber);
        if(currentUser!=null){
            //user role has been defined yet
            if(currentUser.getRoleId()==null){
                currentUser.setRoleId(user.getRoleId());
                userRepository.save(currentUser);
                return Status.SUCCESS;
            }else{
                Integer originalRole=currentUser.getRoleId();
                Survey currentUserSurvey=null;
                //delete user record from survey table
                if(originalRole==1){
                    currentUserSurvey=surveyRepository.findUserByParentId(currentUser.getId());
                    if(currentUserSurvey!=null){
                        currentUserSurvey.setParentId(null);
                        currentUserSurvey.setParentsDesiredAudioCalls(null);
                        currentUserSurvey.setParentsDesiredVideoCalls(null);
                        currentUserSurvey.setParentsDesiredTexts(null);
                        currentUserSurvey.setParentsDesiredNoCallDays(null);
                        surveyRepository.save(currentUserSurvey);
                    }
                }else if(originalRole==2){
                    currentUserSurvey=surveyRepository.findUserByStudentId(currentUser.getId());
                    if(currentUserSurvey!=null) {
                        currentUserSurvey.setStudentId(null);
                        currentUserSurvey.setStudentsDesiredAudioCalls(null);
                        currentUserSurvey.setStudentsDesiredVideoCalls(null);
                        currentUserSurvey.setStudentsDesiredTexts(null);
                        currentUserSurvey.setStudentsDesiredNoCallDays(null);
                        currentUserSurvey.setGrades(false);
                        currentUserSurvey.setDating(false);
                        currentUserSurvey.setFood(false);
                        currentUserSurvey.setMoney(false);
                        currentUserSurvey.setJob(false);
                        currentUserSurvey.setHealth(false);
                        surveyRepository.save(currentUserSurvey);
                    }
                }

                //delete user record from weekly_logs table
                weeklyLogsRepository.deleteWeeklyLogsByContactNumber(contactNumber);

                //user role has been updated
                currentUser.setRoleId(user.getRoleId());
                userRepository.save(currentUser);
                return Status.SUCCESS;
            }

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

    public Status updateUserProfileByContactNumber(Users user, String contactNumber) {
        Users user1=userRepository.findUserByContactNumber(contactNumber);

        if (user1 != null) {
            String newName=null;
            String newContactNumber=null;
            String newPassword=null;

          if(user.getName()!=null){
              newName = user.getName();
              if(!newName.isEmpty() && newName!=null){
                  user1.setName(newName);
              }
          }
          if(user.getContactNumber()!=null){
              newContactNumber=user.getContactNumber();

              if(!newContactNumber.isEmpty() &&  newContactNumber!=null){
                  //Verify that contact number should not exist already
                  Users duplicateUser=userRepository.findUserByContactNumber(newContactNumber);
                  if(duplicateUser!=null){
                      return Status.FAILURE;
                  }
                  user1.setContactNumber(newContactNumber);
              }
          }
          if(user.getPassword()!=null){
              newPassword=user.getPassword();
              if(!newPassword.isEmpty() && newPassword!=null){
                  user1.setPassword(newPassword);
              }

          }
             userRepository.save(user1);
            return Status.SUCCESS;
        }
        return Status.FAILURE;
    }
}


