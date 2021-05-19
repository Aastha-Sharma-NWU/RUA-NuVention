package com.example.rua.service;

import com.example.rua.model.SmsRequest;
import com.example.rua.model.Survey;
import com.example.rua.model.Users;
import com.example.rua.model.WeeklyLogs;
import com.example.rua.repository.SurveyRepository;
import com.example.rua.repository.UserRepository;
import com.example.rua.repository.WeeklyLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final WeeklyLogsRepository weeklyLogsRepository;
    private final UserRepository userRepository;
    private final SurveyRepository surveyRepository;
    private SmsRequest smsRequest;
    @Autowired
    public TwilioSmsSender twilioSmsSender;


    @Autowired
    public NotificationService(WeeklyLogsRepository weeklyLogsRepository, UserRepository userRepository, SurveyRepository surveyRepository) {
        this.weeklyLogsRepository = weeklyLogsRepository;
        this.userRepository = userRepository;
        this.surveyRepository = surveyRepository;
    }

    /*
    2242240001 parent
    parents audio call 14
    text 20
    student call 10
    texts 15
    max call 14+10/2 :12
    max texts 20+15/2 :17
    * */

    //notification for parents
    public void sendNotifictionsToParents(){
        List<WeeklyLogs> listOfWeeklyLogs= weeklyLogsRepository.findAll();
        Integer roleId=0;
        Integer actualCallsDoneByParent=0;
        Integer parentsDesiredAudioCalls=0;
        Integer parentsDesiredTexts=0;
        Integer studentsDesiredTexts=0;
        Long studentId=null;
        Users user=null;
        for(WeeklyLogs logs:listOfWeeklyLogs){
            String contactNumber=logs.getContactNumber();
            if(contactNumber!=null){
                user=userRepository.findUserByContactNumber(contactNumber);
            }
            if(user!=null){
              roleId=user.getRoleId();
            }
            if(roleId==1){

                //Notification to parents if they are calling too much
               actualCallsDoneByParent=logs.getAudioCalls();
               Survey parentSurvey=surveyRepository.findUserByParentId(user.getId());
               if(parentSurvey!=null){
                   parentsDesiredAudioCalls=parentSurvey.getParentsDesiredAudioCalls();
                   parentsDesiredTexts=parentSurvey.getParentsDesiredTexts();
                   studentId=parentSurvey.getStudentId();
               }

                Survey studentSurvey=null;
                Integer studentsDesiredAudioCalls=0;
                if(studentId!=null){
                    studentSurvey=surveyRepository.findUserByStudentId(studentId);
                    studentsDesiredAudioCalls=studentSurvey.getStudentsDesiredAudioCalls();
                    studentsDesiredTexts=studentSurvey.getStudentsDesiredTexts();
                }

               if(actualCallsDoneByParent>(parentsDesiredAudioCalls+studentsDesiredAudioCalls)/2){
                   smsRequest=new SmsRequest();
                   smsRequest.setContactNumber("8479043585");
                   smsRequest.setMessage("Hey "+user.getName()+", you are starting to verge into helicopter parent territory," +
                           "give your child some space and don't call too much");
                   System.out.println("Inside sendNotifictionsToParents");
                  // twilioSmsSender.sendSms(smsRequest);
               }


                //Notification to parents if they are texting too much
                Integer actualTextsDoneByParent=logs.getTextMessages();
                if(actualTextsDoneByParent>(parentsDesiredTexts+studentsDesiredTexts)/2){
                    smsRequest.setContactNumber("8479043585");
                    smsRequest.setMessage("Hey "+user.getName()+", you are starting to verge into helicopter parent territory," +
                            "give your child a day to respond and don't text too much");
                    //twilioSmsSender.sendSms(smsRequest);
                }

            }else{

            }
        }
    }

}
