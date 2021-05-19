package com.example.rua.controller;

import com.example.rua.model.SmsRequest;
import com.example.rua.service.TwilioSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/rua/api/sms")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SmsController {

    private final TwilioSmsService twilioSmsService;

    @Autowired
    public SmsController(TwilioSmsService twilioSmsService) {

        this.twilioSmsService = twilioSmsService;
    }

    @PostMapping
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest){
        twilioSmsService.sendSms(smsRequest);
    }
}
