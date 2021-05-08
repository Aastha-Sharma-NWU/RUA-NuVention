package com.example.rua.service;

import com.example.rua.model.Roles;
import com.example.rua.model.Survey;
import com.example.rua.model.SurveyDTO;
import com.example.rua.model.Users;
import com.example.rua.repository.RoleRepository;
import com.example.rua.repository.SurveyRepository;
import com.example.rua.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SurveyService {

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
        Integer roleId=user.getRoleId();
        if(roleId==1){
            Long parentId=surveyRepository.findUserIdByParentId(user.getId());
            if(null!=parentId)
                return true;
            else return false;
        }else {
            if (roleId == 2) {
                Long studentId = surveyRepository.findUserIdByStudentId(user.getId());
                if (null != studentId)
                    return true;

                else return false;
            }
        }
        return false;
    }

    public void AddUserSurvey(SurveyDTO survey, String contactNumber) {
        Users user=userRepository.findUserByContactNumber(contactNumber);
        Integer roleId=user.getRoleId();
        if(roleId==1){
            Users student=userRepository.findUserByContactNumber(survey.getStudentContactNumber());
            Long studentId=student.getId();
            Survey parentSurvey=surveyRepository.findUserByStudentId(studentId);
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
        }else{
            Users parent=userRepository.findUserByContactNumber(survey.getParentContactNumber());
            Long parentId=parent.getId();
            Survey studentSurvey=surveyRepository.findUserByParentId(parentId);
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
        }

    }



}
