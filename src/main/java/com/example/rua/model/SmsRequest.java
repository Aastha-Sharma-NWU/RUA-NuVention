package com.example.rua.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

//@Component
public class SmsRequest {

    //@NotBlank
    private String contactNumber; //destination phone number

    //@NotBlank
    private String message;

    /*
    public SmsRequest(@JsonProperty("contactNumber") String contactNumber,
                      @JsonProperty("message") String message) {
        this.contactNumber = contactNumber;
        this.message = message;
    }
*/
    public SmsRequest(String contactNumber,
                      String message) {
        this.contactNumber = contactNumber;
        this.message = message;
    }
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "SmsRequest{" +
                "contactNumber='" + contactNumber + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
