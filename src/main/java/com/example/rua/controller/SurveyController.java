package com.example.rua.controller;

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
    public void AddUserSurvey(@RequestBody SurveyDTO survey, @PathVariable String contactNumber) throws IllegalAccessException {
        surveyService.AddUserSurvey(survey,contactNumber);
    }

}
