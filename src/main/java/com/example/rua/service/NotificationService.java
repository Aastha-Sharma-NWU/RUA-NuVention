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
import java.time.temporal.ChronoUnit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
       // List<WeeklyLogs> listOfWeeklyLogs=new ArrayList<>();
       // listOfWeeklyLogs.add(weeklyLogsRepository.findWeeklyLogsByContactNumber("2246054914"));

        boolean enableNotifcation=true;
        for(WeeklyLogs logs:listOfWeeklyLogs){

            Integer roleId=0;
            Integer actualCallsDoneByParent=0;
            Integer actualTextsDoneByParent=0;
            Integer parentsDesiredAudioCalls=0;
            Integer parentsDesiredTexts=0;
            Integer parentMaxNoCallDays=0;


            Integer actualCallsDoneByStudent=0;
            Integer actualTextsDoneByStudent=0;
            Integer studentsDesiredAudioCalls=0;
            Integer studentsDesiredTexts=0;
            Integer studentMaxNoCallDays=0;
            boolean offlimitRespected=true;
            Long studentId=null;
            Long parentId=null;
            Users user=null;


            LocalDate lastCallDate=null;
            Integer daysSinceLastCall=0;

            String contactNumber=logs.getContactNumber();
            if(contactNumber!=null){
                user=userRepository.findUserByContactNumber(contactNumber);
            }
            if(user!=null){
              roleId=user.getRoleId();
            }
            if(roleId==1 && enableNotifcation==true){

               actualCallsDoneByParent=logs.getAudioCalls();
               Survey parentSurvey=surveyRepository.findUserByParentId(user.getId());
               if(parentSurvey!=null){
                   parentsDesiredAudioCalls=parentSurvey.getParentsDesiredAudioCalls()==null?0:parentSurvey.getParentsDesiredAudioCalls();
                   parentsDesiredTexts=parentSurvey.getParentsDesiredTexts()==null?0:parentSurvey.getParentsDesiredTexts();
                   studentId=parentSurvey.getStudentId();
               }

                Survey studentSurvey=null;
                if(studentId!=null){
                    studentSurvey=surveyRepository.findUserByStudentId(studentId);
                    studentsDesiredAudioCalls=studentSurvey.getStudentsDesiredAudioCalls()==null?0:studentSurvey.getStudentsDesiredAudioCalls();
                    studentsDesiredTexts=studentSurvey.getStudentsDesiredTexts()==null?0:studentSurvey.getStudentsDesiredTexts();
                    Optional<Users> oStudent=userRepository.findById(studentId);
                    String studentContactNumber=oStudent.get().getContactNumber();
                    WeeklyLogs studentLogs=weeklyLogsRepository.findWeeklyLogsByContactNumber(studentContactNumber);
                    if(studentLogs!=null){
                        offlimitRespected= studentLogs.getIsOffLimitRespected();
                    }

                }

                //--------------------notification to parents start--------------//

                    //Notification to parents if they are calling too much
                    if(actualCallsDoneByParent>(parentsDesiredAudioCalls+studentsDesiredAudioCalls)/2){
                        smsRequest=new SmsRequest();
                        smsRequest.setContactNumber(contactNumber);
                        smsRequest.setMessage("Hey "+user.getName()+", you are starting to verge into helicopter parent territory," +
                                "give your child some space and don't call too much");
                        System.out.println("Inside send NotifictionsToParents");
                        twilioSmsSender.sendSms(smsRequest);
                    }


                    //Notification to parents if they are texting too much
                    actualTextsDoneByParent=logs.getTextMessages();
                    if(actualTextsDoneByParent>(parentsDesiredTexts+studentsDesiredTexts)/2){
                        smsRequest=new SmsRequest();
                        smsRequest.setContactNumber(contactNumber);
                        smsRequest.setMessage("Hey "+user.getName()+", you are starting to verge into helicopter parent territory," +
                                "give your child a day to respond and don't text too much");
                        twilioSmsSender.sendSms(smsRequest);
                    }

                //Notification to parents if they are not respecting offlimits topics
                if(offlimitRespected==false){
                    smsRequest=new SmsRequest();
                    smsRequest.setContactNumber(contactNumber);
                    smsRequest.setMessage("Hey "+user.getName()+", your child has indicated that you have been discussing about topics they prefer not to " +
                            " please respect this boundary in conversation with your child ");
                    twilioSmsSender.sendSms(smsRequest);
                }

                //--------------------notification to parents end--------------//


            }
           else if(roleId==2 && enableNotifcation==true){

                actualCallsDoneByStudent=logs.getAudioCalls();
                lastCallDate=logs.getLastCallDate();
                Survey studentSurvey=surveyRepository.findUserByStudentId(user.getId());
                if(studentSurvey!=null){
                    studentsDesiredAudioCalls=studentSurvey.getStudentsDesiredAudioCalls()==null?0:studentSurvey.getStudentsDesiredAudioCalls();
                    studentsDesiredTexts=studentSurvey.getStudentsDesiredTexts()==null?0:studentSurvey.getStudentsDesiredTexts();
                    studentMaxNoCallDays=studentSurvey.getStudentsDesiredNoCallDays()==null?0:studentSurvey.getStudentsDesiredNoCallDays();
                    parentId=studentSurvey.getParentId();

                }

                Survey parentSurvey=null;
                if(parentId!=null){
                    parentSurvey=surveyRepository.findUserByParentId(parentId);
                    parentsDesiredAudioCalls=parentSurvey.getParentsDesiredAudioCalls()==null?0:parentSurvey.getParentsDesiredAudioCalls();
                    parentsDesiredTexts=parentSurvey.getParentsDesiredTexts()==null?0:parentSurvey.getParentsDesiredTexts();
                    parentMaxNoCallDays=parentSurvey.getParentsDesiredNoCallDays()==null?0:parentSurvey.getParentsDesiredNoCallDays();
                }


                //--------------------notification to students start--------------//

                //Notification to students if they has not called since last x days
                     if(lastCallDate!=null){
                         LocalDate currentDate=LocalDate.now();
                         daysSinceLastCall= Math.toIntExact(ChronoUnit.DAYS.between(lastCallDate, currentDate));
                         if(daysSinceLastCall>=((parentMaxNoCallDays+studentMaxNoCallDays))/2){
                             smsRequest=new SmsRequest();
                             smsRequest.setContactNumber(contactNumber);
                             smsRequest.setMessage("Hey "+user.getName()+", you have not called home in " + 
                                             daysSinceLastCall+
                                     "why dont take out some time to make a quick call to your parents");
                             System.out.println("Inside send Notifictions To Students");
                             System.out.println("Hey "+user.getName()+", you have not called home in " +
                                     daysSinceLastCall+
                                     " days , why dont take out some time to make a quick call to your parents");
                             twilioSmsSender.sendSms(smsRequest);

                         }
                     }

                    //Notification to students if they are calling too less
//                    if(actualCallsDoneByStudent<(studentsDesiredAudioCalls+parentsDesiredAudioCalls)/2){
//                        smsRequest=new SmsRequest();
//                        //smsRequest.setContactNumber("8479043585");
//                        smsRequest.setContactNumber(contactNumber);
//                        smsRequest.setMessage("Hey "+user.getName()+", you are calling your parents too less" +
//                                "why dont take out some time to make a quick call to your parents");
//                        System.out.println("Inside send Notifictions To Students");
//                        twilioSmsSender.sendSms(smsRequest);
//                    }

                    //Notification to parents if they are texting too less
                    actualTextsDoneByStudent=logs.getTextMessages();
                    if(actualTextsDoneByStudent<(parentsDesiredTexts+studentsDesiredTexts)/2){
                        smsRequest=new SmsRequest();
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
