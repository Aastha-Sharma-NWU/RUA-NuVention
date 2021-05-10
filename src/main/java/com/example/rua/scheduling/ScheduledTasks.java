package com.example.rua.scheduling;

import com.example.rua.model.SmsRequest;
import com.example.rua.service.TwilioSmsSender;
import com.example.rua.service.TwilioSmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Autowired
    private TwilioSmsSender twilioSmsSender;

    //@Autowired
    private SmsRequest smsRequest;



    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Scheduled(fixedRate = 30000)
    public void getHeadValue() {
        System.out.println("Inside Schedule Task");
//        smsRequest= new SmsRequest("8479043585","Call your parents");
//        twilioSmsSender.sendSms(smsRequest);
//        log.info("Value: {}", "Message send");
    }
}
