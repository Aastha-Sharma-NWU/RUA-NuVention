package com.example.rua.service;

import com.example.rua.configuration.TwilioConfiguration;
import com.example.rua.model.SmsRequest;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class TwilioSmsSender implements SmsSender{

    private static final Logger LOGGER= LoggerFactory.getLogger(TwilioSmsSender.class);

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        if(isPhoneNumberValid(smsRequest.getContactNumber())){
            PhoneNumber to=new PhoneNumber(smsRequest.getContactNumber());
            PhoneNumber from=new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message=smsRequest.getMessage();
            MessageCreator creator= Message.creator(to,from,message);
            creator.create();
            LOGGER.info("Send sms {} "+smsRequest);
        }else{
            throw new IllegalArgumentException(
                    "Phone Number ["+smsRequest.getContactNumber()+"] is not a valid number");
        }

    }

    private boolean isPhoneNumberValid(String contactNumber) {
       // Implement phone number validator
        return true;
    }
}
