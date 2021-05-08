package com.example.rua.model;

import java.time.LocalDate;

public class Communication {

    private Long id;
    private String contactNumber;
    private LocalDate weekStartDate;
    private LocalDate weekEndDate;
    private Integer audioCalls;
    private Integer videoCalls;
    private Integer textMessages;

    public Communication() {
    }

    public Communication(Long id, String contactNumber, LocalDate weekStartDate, LocalDate weekEndDate, Integer audioCalls, Integer videoCalls, Integer textMessages) {
        this.id = id;
        this.contactNumber = contactNumber;
        this.weekStartDate = weekStartDate;
        this.weekEndDate = weekEndDate;
        this.audioCalls = audioCalls;
        this.videoCalls = videoCalls;
        this.textMessages = textMessages;
    }

    public Communication(String contactNumber, LocalDate weekStartDate, LocalDate weekEndDate, Integer audioCalls, Integer videoCalls, Integer textMessages) {
        this.contactNumber = contactNumber;
        this.weekStartDate = weekStartDate;
        this.weekEndDate = weekEndDate;
        this.audioCalls = audioCalls;
        this.videoCalls = videoCalls;
        this.textMessages = textMessages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public LocalDate getWeekStartDate() {
        return weekStartDate;
    }

    public void setWeekStartDate(LocalDate weekStartDate) {
        this.weekStartDate = weekStartDate;
    }

    public LocalDate getWeekEndDate() {
        return weekEndDate;
    }

    public void setWeekEndDate(LocalDate weekEndDate) {
        this.weekEndDate = weekEndDate;
    }

    public Integer getAudioCalls() {
        return audioCalls;
    }

    public void setAudioCalls(Integer audioCalls) {
        this.audioCalls = audioCalls;
    }

    public Integer getVideoCalls() {
        return videoCalls;
    }

    public void setVideoCalls(Integer videoCalls) {
        this.videoCalls = videoCalls;
    }

    public Integer getTextMessages() {
        return textMessages;
    }

    public void setTextMessages(Integer textMessages) {
        this.textMessages = textMessages;
    }
}
