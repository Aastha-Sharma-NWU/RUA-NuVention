package com.example.rua.service;

import com.example.rua.model.SmsRequest;

public interface SmsSender {

    void sendSms(SmsRequest smsRequest);
}
