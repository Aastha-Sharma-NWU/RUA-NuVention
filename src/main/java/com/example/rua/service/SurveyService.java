package com.example.rua.service;

import com.example.rua.model.*;
import com.example.rua.repository.RoleRepository;
import com.example.rua.repository.SurveyRepository;
import com.example.rua.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class
SurveyService {

    private final SurveyRepository surveyRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserService userService;

    @Autowired
    public SurveyService(SurveyRepository surveyRepository, UserRepository userRepository, RoleRepository roleRepository, UserService userService) {
        this.surveyRepository = surveyRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userService = userService;
    }




//    public boolean isSurveyFilledByUser(String contactNumber){
//        Users user=userRepository.findUserByContactNumber(contactNumber);
//        if(user==null)
//            return false;
//        Integer roleId=user.getRoleId();
//        if(roleId==1){
//            Survey userSurvey=surveyRepository.findUserByParentId(user.getId());
//            if(userSurvey!=null){
//                return true;
//            }
//            else {
//                return false;
//            }
//        }else {
//            if (roleId == 2) {
//                Survey userSurvey=surveyRepository.findUserByStudentId(user.getId());
//                if(userSurvey!=null){
//                    return true;
//                }
//                else{
//                    return false;
//                }
//            }
//        }
//        return false;
//    }
public Response isSurveyFilledByUser(String contactNumber){
    Response response=new Response();
    Users user=userRepository.findUserByContactNumber(contactNumber);
    if(user==null){
        response.setStatus("Success");
        response.setMessage("User does not exists");
        response.setSurveyCompleted(false);
        return response;
    }

    Integer roleId=user.getRoleId();
    if(roleId==1){
        Survey userSurvey=surveyRepository.findUserByParentId(user.getId());
        if(userSurvey!=null){
            response.setStatus("Success");
            response.setMessage("User survey has been filled");
            response.setSurveyCompleted(true);
            return response;
        }
        else {
            response.setStatus("Success");
            response.setMessage("User survey has not been filled yet");
            response.setSurveyCompleted(false);
            return response;
        }
    }else {
        if (roleId == 2) {
            Survey userSurvey=surveyRepository.findUserByStudentId(user.getId());
            if(userSurvey!=null){
                response.setStatus("Success");
                response.setMessage("User survey has been filled");
                response.setSurveyCompleted(true);
                return response;
            }
            else{
                response.setStatus("Success");
                response.setMessage("User survey has not been filled yet");
                response.setSurveyCompleted(false);
                return response;
            }
        }
    }
    response.setStatus("Success");
    response.setMessage("User survey has not been filled yet");
    response.setSurveyCompleted(false);
    return response;
}


/////check user survey filled or not
        public boolean isSurveyFilled(String contactNumber){
        Users user=userRepository.findUserByContactNumber(contactNumber);
        if(user==null)
            return false;
        String role=userService.getUserRole(user.getContactNumber());
        if(role==null)
            return false;
        Integer roleId=user.getRoleId();
        if(roleId==1){
            Survey userSurvey=surveyRepository.findUserByParentId(user.getId());
            if(userSurvey!=null){
                return true;
            }
            else {
                return false;
            }
        }else {
            if (roleId == 2) {
                Survey userSurvey=surveyRepository.findUserByStudentId(user.getId());
                if(userSurvey!=null){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }


//    public Status AddUserSurvey(SurveyDTO survey, String contactNumber) {
//        Users user=userRepository.findUserByContactNumber(contactNumber);
//        Integer roleId=user.getRoleId();
//        Survey parentSurvey=null;
//        Long studentId = null;
//        Survey studentSurvey=null;
//        Long parentId=null;
//        if(roleId==1){
//            Users student=userRepository.findUserByContactNumber(survey.getStudentContactNumber());
//            if(student!=null){
//                studentId=student.getId();
//                parentSurvey=surveyRepository.findUserByStudentId(studentId);
//            }
//
//            if(parentSurvey==null) {
//                parentSurvey = new Survey();
//            }
//            parentSurvey.setParentId(user.getId());
//            parentSurvey.setStudentId(studentId);
//            parentSurvey.setParentsDesiredAudioCalls(survey.getParentsDesiredAudioCalls());
//            parentSurvey.setParentsDesiredVideoCalls(survey.getParentsDesiredVideoCalls());
//            parentSurvey.setParentsDesiredTexts(survey.getParentsDesiredTexts());
//            parentSurvey.setParentsDesiredNoCallDays(survey.getParentsDesiredNoCallDays());
//            surveyRepository.save(parentSurvey);
//            return Status.SUCCESS;
//        }else{
//            Users parent=userRepository.findUserByContactNumber(survey.getParentContactNumber());
//            if(parent!=null){
//                parentId=parent.getId();
//                studentSurvey=surveyRepository.findUserByParentId(parentId);
//            }
//
//            if(studentSurvey==null) {
//                studentSurvey = new Survey();
//            }
//            studentSurvey.setStudentId(user.getId());
//            studentSurvey.setParentId(parentId);
//            studentSurvey.setStudentsDesiredAudioCalls(survey.getStudentsDesiredAudioCalls());
//            studentSurvey.setStudentsDesiredVideoCalls(survey.getStudentsDesiredVideoCalls());
//            studentSurvey.setStudentsDesiredTexts(survey.getStudentsDesiredTexts());
//            studentSurvey.setStudentsDesiredNoCallDays(survey.getStudentsDesiredNoCallDays());
//            surveyRepository.save(studentSurvey);
//            return Status.SUCCESS;
//        }
//
//    }

  //---------------old version--------
//    public Status AddUserSurvey(SurveyDTO survey, String contactNumber) {
//        Users user=userRepository.findUserByContactNumber(contactNumber);
//        Integer roleId=user.getRoleId();
//        Survey parentSurvey=null;
//        Long studentId = null;
//        Survey studentSurvey=null;
//        Long parentId=null;
//        if(roleId==1){
//            Users student=userRepository.findUserByContactNumber(survey.getStudentContactNumber());
//            if(student!=null){
//                studentId=student.getId();
//                parentSurvey=surveyRepository.findUserByStudentId(studentId);
//            }
//
//            if(parentSurvey==null) {
//                parentSurvey = new Survey();
//            }
//            parentSurvey.setParentId(user.getId());
//            parentSurvey.setStudentId(studentId);
//            parentSurvey.setParentsDesiredAudioCalls(survey.getParentsDesiredAudioCalls());
//            parentSurvey.setParentsDesiredVideoCalls(survey.getParentsDesiredVideoCalls());
//            parentSurvey.setParentsDesiredTexts(survey.getParentsDesiredTexts());
//            parentSurvey.setParentsDesiredNoCallDays(survey.getParentsDesiredNoCallDays());
//            surveyRepository.save(parentSurvey);
//            return Status.SUCCESS;
//        }else{
//            Users parent=userRepository.findUserByContactNumber(survey.getParentContactNumber());
//            if(parent!=null){
//                parentId=parent.getId();
//                studentSurvey=surveyRepository.findUserByParentId(parentId);
//            }
//
//            if(studentSurvey==null) {
//                studentSurvey = new Survey();
//            }
//            studentSurvey.setStudentId(user.getId());
//            studentSurvey.setParentId(parentId);
//            studentSurvey.setStudentsDesiredAudioCalls(survey.getStudentsDesiredAudioCalls());
//            studentSurvey.setStudentsDesiredVideoCalls(survey.getStudentsDesiredVideoCalls());
//            studentSurvey.setStudentsDesiredTexts(survey.getStudentsDesiredTexts());
//            studentSurvey.setStudentsDesiredNoCallDays(survey.getStudentsDesiredNoCallDays());
//            studentSurvey.setGrades(survey.isGrades());
//            studentSurvey.setDating(survey.isDating());
//            studentSurvey.setFood(survey.isFood());
//            studentSurvey.setMoney(survey.isMoney());
//            studentSurvey.setJob(survey.isJob());
//            studentSurvey.setHealth(survey.isHealth());
//            surveyRepository.save(studentSurvey);
//            return Status.SUCCESS;
//        }
//
//    }
  public Response AddUserSurvey(SurveyDTO survey, String contactNumber) {
        Response response= new Response();
      Users user=userRepository.findUserByContactNumber(contactNumber);
      if(user==null){
          response.setStatus("Failure");
          response.setMessage("User does not exists");
          return response;
      }
      Integer roleId=user.getRoleId();
      Survey parentSurvey=null;
      Long studentId = null;
      Survey studentSurvey=null;
      Long parentId=null;
      Survey parentsChildSurvey=null;
      Survey studentsParentSurvey=null;
      if(roleId==1){


          //check if his survey already exists
          parentSurvey=surveyRepository.findUserByParentId(user.getId());
          //if not check if his child has already filled survey
          if(parentSurvey==null){
              Users student=userRepository.findUserByContactNumber(survey.getStudentContactNumber());
              if(student!=null){
                  studentId=student.getId();
                  parentsChildSurvey=surveyRepository.findUserByStudentId(studentId);
                  if(parentsChildSurvey!=null){
                      parentSurvey=parentsChildSurvey;
                  }
             }
          }
         //if neither of parent's or his/her child's survey exists then create new survey
          if(parentSurvey==null) {
              parentSurvey = new Survey();
          }
          parentSurvey.setParentId(user.getId());
          //parentSurvey.setStudentId(studentId);
          parentSurvey.setParentsDesiredAudioCalls(survey.getParentsDesiredAudioCalls());
          parentSurvey.setParentsDesiredVideoCalls(survey.getParentsDesiredVideoCalls());
          parentSurvey.setParentsDesiredTexts(survey.getParentsDesiredTexts());
          parentSurvey.setParentsDesiredNoCallDays(survey.getParentsDesiredNoCallDays());
          surveyRepository.save(parentSurvey);
          response.setStatus("Success");
          response.setMessage("User survey has been filled");
          return response;

      }else{
          //check if his survey already exists
          studentSurvey=surveyRepository.findUserByStudentId(user.getId());
          if(studentSurvey==null){

              Users parent=userRepository.findUserByContactNumber(survey.getParentContactNumber());
              if(parent!=null){
                  parentId=parent.getId();
                  //if not check if his parent has already filled survey
                  studentsParentSurvey=surveyRepository.findUserByParentId(parentId);
                  if(studentsParentSurvey!=null){
                      studentSurvey=studentsParentSurvey;
                  }
              }
          }
          //if neither of parent's or his/her child's survey exists then create new survey
          if(studentSurvey==null) {
              studentSurvey = new Survey();
          }
          studentSurvey.setStudentId(user.getId());
          //studentSurvey.setParentId(parentId);
          studentSurvey.setStudentsDesiredAudioCalls(survey.getStudentsDesiredAudioCalls());
          studentSurvey.setStudentsDesiredVideoCalls(survey.getStudentsDesiredVideoCalls());
          studentSurvey.setStudentsDesiredTexts(survey.getStudentsDesiredTexts());
          studentSurvey.setStudentsDesiredNoCallDays(survey.getStudentsDesiredNoCallDays());
          studentSurvey.setGrades(survey.isGrades());
          studentSurvey.setDating(survey.isDating());
          studentSurvey.setFood(survey.isFood());
          studentSurvey.setMoney(survey.isMoney());
          studentSurvey.setJob(survey.isJob());
          studentSurvey.setHealth(survey.isHealth());
          surveyRepository.save(studentSurvey);
          response.setStatus("Success");
          response.setMessage("User survey has been filled");
          return response;
      }

  }

    public SurveyDTO getCommunicationPreferences(String contactNumber) {
        SurveyDTO communicationPrefences=new SurveyDTO();
        Survey currentSurvey=null;
        Long currentUserId=null;
        Users currentUser=userRepository.findUserByContactNumber(contactNumber);
          if(currentUser!=null){
              int currentUserRole=currentUser.getRoleId();
              currentUserId=currentUser.getId();
              if(currentUserRole==1){
                  //fetches survey data on basis of parent id
                  currentSurvey= surveyRepository.findUserByParentId(currentUserId);
              }else{
                  //fetches survey data on basis of student id
                  currentSurvey= surveyRepository.findUserByStudentId(currentUserId);
              }
              //setting parent's communication prefences
              communicationPrefences.setParentsDesiredAudioCalls(currentSurvey.getParentsDesiredAudioCalls());
              communicationPrefences.setParentsDesiredVideoCalls(currentSurvey.getParentsDesiredVideoCalls());
              communicationPrefences.setParentsDesiredTexts(currentSurvey.getParentsDesiredTexts());
              communicationPrefences.setParentsDesiredNoCallDays(currentSurvey.getParentsDesiredNoCallDays());

             //setting student's communication preferences
              communicationPrefences.setStudentsDesiredAudioCalls(currentSurvey.getStudentsDesiredAudioCalls());
              communicationPrefences.setStudentsDesiredVideoCalls(currentSurvey.getStudentsDesiredVideoCalls());
              communicationPrefences.setStudentsDesiredTexts(currentSurvey.getStudentsDesiredTexts());
              communicationPrefences.setStudentsDesiredNoCallDays(currentSurvey.getStudentsDesiredNoCallDays());
              communicationPrefences.setGrades(currentSurvey.isGrades());
              communicationPrefences.setDating(currentSurvey.isDating());
              communicationPrefences.setFood(currentSurvey.isFood());
              communicationPrefences.setMoney(currentSurvey.isMoney());
              communicationPrefences.setJob(currentSurvey.isJob());
              communicationPrefences.setHealth(currentSurvey.isHealth());
          }

        return communicationPrefences;
    }

    public SurveyDTO getSuggestedPlan(String contactNumber) {
        SurveyDTO currentPlan=new SurveyDTO();
        String message=null;
        Users currentUser=userRepository.findUserByContactNumber(contactNumber);
        Survey currentUserSurveyData=null;
        if(currentUser!=null){
            Integer currentUserRoleId= currentUser.getRoleId();
            if(currentUserRoleId==1){
                currentUserSurveyData=surveyRepository.findUserByParentId(currentUser.getId());
            }else{
                currentUserSurveyData=surveyRepository.findUserByStudentId(currentUser.getId());
            }
        }

        Integer pAudioCalls=null;
        pAudioCalls=currentUserSurveyData.getParentsDesiredAudioCalls()==null?0:currentUserSurveyData.getParentsDesiredAudioCalls();
        Integer pVideoCalls=null;
        pVideoCalls=currentUserSurveyData.getParentsDesiredVideoCalls()==null?0:currentUserSurveyData.getParentsDesiredVideoCalls();
        Integer pTexts=null;
        pTexts=currentUserSurveyData.getParentsDesiredTexts()==null?0:currentUserSurveyData.getParentsDesiredTexts();

        Integer sAudioCalls=null;
        sAudioCalls=currentUserSurveyData.getStudentsDesiredAudioCalls()==null?0:currentUserSurveyData.getStudentsDesiredAudioCalls();
        Integer sVideoCalls=null;
        sVideoCalls=currentUserSurveyData.getStudentsDesiredVideoCalls()==null?0:currentUserSurveyData.getStudentsDesiredVideoCalls();
        Integer sTexts=null;
        sTexts=currentUserSurveyData.getStudentsDesiredTexts()==null?0:currentUserSurveyData.getStudentsDesiredTexts();


//        Integer audioCalls=(pAudioCalls+ sAudioCalls)/2;
//        Integer videoCalls=(pVideoCalls+ sVideoCalls)/2;
//        Integer textMessages=(pTexts+ sTexts)/2;
        Integer audioCalls=0;
        Integer videoCalls=0;
        Integer textMessages=0;
        //if parent has not filled survey yet
        if(pAudioCalls==0 && pVideoCalls==0 && pTexts==0){
            audioCalls= sAudioCalls;
            videoCalls= sVideoCalls;
            textMessages =sTexts;
            message="Current plan is based on survey filled by Student.Parent has not filled survey yet." +
                    "Plan will be updated once both of you fill the survey";
        }  // if student has not filled survey yet
        else if(sAudioCalls==0 && sVideoCalls==0 && sTexts==0){
            audioCalls = pAudioCalls;
            videoCalls = pVideoCalls;
            textMessages = pTexts;
            message="Current plan is based on survey filled by Parent.Student has not filled survey yet." +
                    "Plan will be updated once both of you fill the survey";
        } // if both have filled survey
        else{
            audioCalls=(pAudioCalls+ sAudioCalls)/2;
            videoCalls=(pVideoCalls+ sVideoCalls)/2;
            textMessages=(pTexts + sTexts)/2;
            message="Plan is based on average of values filled by Parent and Student in the survey";


        }

        //save planned values  in Survey table
        currentUserSurveyData.setPlannedAudioCalls(audioCalls);
        currentUserSurveyData.setPlannedVideoCalls(videoCalls);
        currentUserSurveyData.setPlannedTextMessages(textMessages);
        surveyRepository.save(currentUserSurveyData);

        // set return planned values in currentPlan
        currentPlan.setPlannedAudioCalls(audioCalls);
        currentPlan.setPlannedVideoCalls(videoCalls);
        currentPlan.setPlannedTextMessages(textMessages);
        currentPlan.setGrades(currentUserSurveyData.isGrades());
        currentPlan.setDating(currentUserSurveyData.isDating());
        currentPlan.setFood(currentUserSurveyData.isFood());
        currentPlan.setMoney(currentUserSurveyData.isMoney());
        currentPlan.setJob(currentUserSurveyData.isJob());
        currentPlan.setHealth(currentUserSurveyData.isHealth());
        currentPlan.setMessage(message);

        return currentPlan;
    }


//    public Status updateUserSurvey(SurveyDTO survey, String contactNumber) {
//        Users currentUser=userRepository.findUserByContactNumber(contactNumber);
//        Integer roleId=0;
//        Survey currentUserSurvey=null;
//        Long currentStudentId=null;
//        Long currentParentId=null;
//
//        if(currentUser!=null){
//            roleId=currentUser.getRoleId();
//        }
//
//        if(roleId==1){
//            String newChildPhoneNumber=null;
//            Integer newParentsDesiredAudioCalls=0;
//            Integer newParentsDesiredVideoCalls=0;
//            Integer newParentsDesiredTexts=0;
//            Integer newParentsDesiredNoCallDays=0;
//            currentParentId=currentUser.getId();
//            currentUserSurvey=surveyRepository.findUserByParentId(currentParentId);
//            //update phone number of child
//            if(!survey.getStudentContactNumber().isEmpty()){
//                newChildPhoneNumber=survey.getStudentContactNumber();
//              ///////////////////
//            }
//            if(survey.getParentsDesiredAudioCalls())
//
//        }
//        else if(roleId==2){
//            currentStudentId=currentUser.getId();
//            currentUserSurvey=surveyRepository.findUserByStudentId(currentStudentId);
//        }
//        else{
//            return Status.FAILURE;
//        }
//       return Status.FAILURE;
//    }
}
