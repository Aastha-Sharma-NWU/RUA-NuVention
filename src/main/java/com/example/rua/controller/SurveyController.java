package com.example.rua.controller;

import com.example.rua.model.Status;
import com.example.rua.model.Survey;
import com.example.rua.model.SurveyDTO;
import com.example.rua.model.Users;
import com.example.rua.service.SurveyService;
import com.example.rua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/rua/api/survey")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SurveyController {

    private final SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }


    @GetMapping(path="/isUserSurveyFilled/{contactNumber}")
    public boolean isSurveyFilledByUser(@PathVariable String contactNumber ){
        return surveyService.isSurveyFilledByUser(contactNumber);

    }

    @PostMapping(path="/fillUserSurvey/{contactNumber}")
    public Status AddUserSurvey(@RequestBody SurveyDTO survey, @PathVariable String contactNumber) throws IllegalAccessException {
        return surveyService.AddUserSurvey(survey,contactNumber);
    }

//    @PutMapping(path="/updateUserSurvey/{contactNumber}")
//    public Status updateUserSurvey(@RequestBody SurveyDTO survey, @PathVariable String contactNumber) throws IllegalAccessException {
//        return surveyService.AddUserSurvey(survey,contactNumber);
//    }

    @GetMapping(path="/getCommunicationPreferences/{contactNumber}")
    public SurveyDTO getCommunicationPreferences(@PathVariable String contactNumber){
        return surveyService.getCommunicationPreferences(contactNumber);
    }

    @GetMapping(path="/getSuggestedPlan/{contactNumber}")
    public SurveyDTO getSuggestedPlan(@PathVariable String contactNumber){
        return surveyService.getSuggestedPlan(contactNumber);
    }

}
