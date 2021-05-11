package com.example.rua.service;

import com.example.rua.model.*;
import com.example.rua.repository.RoleRepository;
import com.example.rua.repository.SurveyRepository;
import com.example.rua.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class
SurveyService {

    private final SurveyRepository surveyRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public SurveyService(SurveyRepository surveyRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.surveyRepository = surveyRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public boolean isSurveyFilledByUser(String contactNumber){
        Users user=userRepository.findUserByContactNumber(contactNumber);
        if(user==null)
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

    public Status AddUserSurvey(SurveyDTO survey, String contactNumber) {
        Users user=userRepository.findUserByContactNumber(contactNumber);
        Integer roleId=user.getRoleId();
        Survey parentSurvey=null;
        Long studentId = null;
        Survey studentSurvey=null;
        Long parentId=null;
        if(roleId==1){
            Users student=userRepository.findUserByContactNumber(survey.getStudentContactNumber());
            if(student!=null){
                studentId=student.getId();
                parentSurvey=surveyRepository.findUserByStudentId(studentId);
            }

            if(parentSurvey==null) {
                parentSurvey = new Survey();
            }
            parentSurvey.setParentId(user.getId());
            parentSurvey.setStudentId(studentId);
            parentSurvey.setParentsDesiredAudioCalls(survey.getParentsDesiredAudioCalls());
            parentSurvey.setParentsDesiredVideoCalls(survey.getParentsDesiredVideoCalls());
            parentSurvey.setParentsDesiredTexts(survey.getParentsDesiredTexts());
            parentSurvey.setParentsDesiredNoCallDays(survey.getParentsDesiredNoCallDays());
            surveyRepository.save(parentSurvey);
            return Status.SUCCESS;
        }else{
            Users parent=userRepository.findUserByContactNumber(survey.getParentContactNumber());
            if(parent!=null){
                parentId=parent.getId();
                studentSurvey=surveyRepository.findUserByParentId(parentId);
            }

            if(studentSurvey==null) {
                studentSurvey = new Survey();
            }
            studentSurvey.setStudentId(user.getId());
            studentSurvey.setParentId(parentId);
            studentSurvey.setStudentsDesiredAudioCalls(survey.getStudentsDesiredAudioCalls());
            studentSurvey.setStudentsDesiredVideoCalls(survey.getStudentsDesiredVideoCalls());
            studentSurvey.setStudentsDesiredTexts(survey.getStudentsDesiredTexts());
            studentSurvey.setStudentsDesiredNoCallDays(survey.getStudentsDesiredNoCallDays());
            surveyRepository.save(studentSurvey);
            return Status.SUCCESS;
        }

    }


}
