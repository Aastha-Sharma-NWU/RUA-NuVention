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

import java.util.ArrayList;
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
    public void sendNotifictionsToUsers(){
        List<WeeklyLogs> listOfWeeklyLogs= weeklyLogsRepository.findAll();
//        List<WeeklyLogs> listOfWeeklyLogs=new ArrayList<>();
//        listOfWeeklyLogs.add(weeklyLogsRepository.findWeeklyLogsByContactNumber("9999999999"));
//        Integer roleId=0;
//        Integer actualCallsDoneByParent=0;
//        Integer parentsDesiredAudioCalls=0;
//        Integer parentsDesiredTexts=0;
//        Integer studentsDesiredTexts=0;
//        Long studentId=null;
//        Users user=null;
        for(WeeklyLogs logs:listOfWeeklyLogs){
            Integer roleId=0;
            Integer actualCallsDoneByParent=0;
            Integer actualTextsDoneByParent=0;
            Integer parentsDesiredAudioCalls=0;
            Integer parentsDesiredTexts=0;


            Integer actualCallsDoneByStudent=0;
            Integer actualTextsDoneByStudent=0;
            Integer studentsDesiredAudioCalls=0;
            Integer studentsDesiredTexts=0;
            Long studentId=null;
            Long parentId=null;
            Users user=null;

            String contactNumber=logs.getContactNumber();
            if(contactNumber!=null){
                user=userRepository.findUserByContactNumber(contactNumber);
            }
            if(user!=null){
              roleId=user.getRoleId();
            }
            if(roleId==1){

               actualCallsDoneByParent=logs.getAudioCalls();
               Survey parentSurvey=surveyRepository.findUserByParentId(user.getId());
               if(parentSurvey!=null){
                   parentsDesiredAudioCalls=parentSurvey.getParentsDesiredAudioCalls()==null?0:parentSurvey.getParentsDesiredAudioCalls();
                   parentsDesiredTexts=parentSurvey.getParentsDesiredTexts()==null?0:parentSurvey.getParentsDesiredTexts();
                   studentId=parentSurvey.getStudentId();
               }

                Survey studentSurvey=null;
                //Integer studentsDesiredAudioCalls=0;
                if(studentId!=null){
                    studentSurvey=surveyRepository.findUserByStudentId(studentId);
                    studentsDesiredAudioCalls=studentSurvey.getStudentsDesiredAudioCalls()==null?0:studentSurvey.getStudentsDesiredAudioCalls();
                    studentsDesiredTexts=studentSurvey.getStudentsDesiredTexts()==null?0:studentSurvey.getStudentsDesiredTexts();
                }

                //--------------------notification to parents start--------------//

                    //Notification to parents if they are calling too much
                    if(actualCallsDoneByParent>(parentsDesiredAudioCalls+studentsDesiredAudioCalls)/2){
                        smsRequest=new SmsRequest();
                        //smsRequest.setContactNumber("8479043585");
                        smsRequest.setContactNumber(contactNumber);
                        smsRequest.setMessage("Hey "+user.getName()+", you are starting to verge into helicopter parent territory," +
                                "give your child some space and don't call too much");
                        System.out.println("Inside send NotifictionsToParents");
                        twilioSmsSender.sendSms(smsRequest);
                    }


                    //Notification to parents if they are texting too much
                    actualTextsDoneByParent=logs.getTextMessages();
                    if(actualTextsDoneByParent>(parentsDesiredTexts+studentsDesiredTexts)/2){
                        //smsRequest.setContactNumber("8479043585");
                        smsRequest.setContactNumber(contactNumber);
                        smsRequest.setMessage("Hey "+user.getName()+", you are starting to verge into helicopter parent territory," +
                                "give your child a day to respond and don't text too much");
                        twilioSmsSender.sendSms(smsRequest);
                    }

                //--------------------notification to parents end--------------//


            }
           else if(roleId==2){

                actualCallsDoneByStudent=logs.getAudioCalls();
                Survey studentSurvey=surveyRepository.findUserByStudentId(user.getId());
                if(studentSurvey!=null){
                    studentsDesiredAudioCalls=studentSurvey.getStudentsDesiredAudioCalls()==null?0:studentSurvey.getStudentsDesiredAudioCalls();
                    studentsDesiredTexts=studentSurvey.getStudentsDesiredTexts()==null?0:studentSurvey.getStudentsDesiredTexts();
                    parentId=studentSurvey.getParentId();
                }

                Survey parentSurvey=null;
                //Integer studentsDesiredAudioCalls=0;
                if(parentId!=null){
                    parentSurvey=surveyRepository.findUserByParentId(parentId);
                    parentsDesiredAudioCalls=parentSurvey.getParentsDesiredAudioCalls()==null?0:parentSurvey.getParentsDesiredAudioCalls();
                    parentsDesiredTexts=parentSurvey.getParentsDesiredTexts()==null?0:parentSurvey.getParentsDesiredTexts();
                }


                //--------------------notification to students start--------------//

                    //Notification to students if they are calling too less
                    if(actualCallsDoneByStudent<(studentsDesiredAudioCalls+parentsDesiredAudioCalls)/2){
                        smsRequest=new SmsRequest();
                        //smsRequest.setContactNumber("8479043585");
                        smsRequest.setContactNumber(contactNumber);
                        smsRequest.setMessage("Hey "+user.getName()+", you are calling your parents too less" +
                                "why dont take out some time to make a quick call to your parents");
                        System.out.println("Inside send Notifictions To Students");
                        twilioSmsSender.sendSms(smsRequest);
                    }


                    //Notification to parents if they are texting too much
                    actualTextsDoneByStudent=logs.getTextMessages();
                    if(actualTextsDoneByStudent<(parentsDesiredTexts+studentsDesiredTexts)/2){
                        //smsRequest.setContactNumber("8479043585");
                        smsRequest.setContactNumber(contactNumber);
                        smsRequest.setMessage("Hey "+user.getName()+", you are texting your parents too less" +
                                " why dont take out some time to send a quick text to your parents");
                        twilioSmsSender.sendSms(smsRequest);
                    }


                //--------------------notification to students end--------------//

           }
        }
    }

}
