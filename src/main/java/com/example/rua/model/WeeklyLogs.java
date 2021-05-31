package com.example.rua.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class WeeklyLogs {
    @Id
    @SequenceGenerator(
            name="weeklyLogs_sequence",
            sequenceName = "weeklyLogs_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator ="weeklyLogs_sequence"
    )
    private Long id;
    private String contactNumber;
    private LocalDate weekStartDate;
    private LocalDate weekEndDate;
    private Integer audioCalls;
    private Integer videoCalls;
    private Integer textMessages;
    private boolean isOffLimitRespected;
    private boolean isHappy;
    private LocalDate lastCallDate;


    public WeeklyLogs() {
    }

    public WeeklyLogs(Long id, String contactNumber, LocalDate weekStartDate, LocalDate weekEndDate, Integer audioCalls, Integer videoCalls, Integer textMessages, boolean isOffLimitRespected, boolean isHappy, LocalDate lastCallDate) {
        this.id = id;
        this.contactNumber = contactNumber;
        this.weekStartDate = weekStartDate;
        this.weekEndDate = weekEndDate;
        this.audioCalls = audioCalls;
        this.videoCalls = videoCalls;
        this.textMessages = textMessages;
        this.isOffLimitRespected = isOffLimitRespected;
        this.isHappy = isHappy;
        this.lastCallDate = lastCallDate;
    }

    public WeeklyLogs(String contactNumber, LocalDate weekStartDate, LocalDate weekEndDate, Integer audioCalls, Integer videoCalls, Integer textMessages, boolean isOffLimitRespected, boolean isHappy, LocalDate lastCallDate) {
        this.contactNumber = contactNumber;
        this.weekStartDate = weekStartDate;
        this.weekEndDate = weekEndDate;
        this.audioCalls = audioCalls;
        this.videoCalls = videoCalls;
        this.textMessages = textMessages;
        this.isOffLimitRespected = isOffLimitRespected;
        this.isHappy = isHappy;
        this.lastCallDate = lastCallDate;
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

    public boolean getIsOffLimitRespected() {
        return isOffLimitRespected;
    }

    public void setIsOffLimitRespected(boolean offLimitRespected) {
        isOffLimitRespected = offLimitRespected;
    }

    public boolean getIsHappy() {
        return isHappy;
    }

    public void setIsHappy(boolean happy) {
        isHappy = happy;
    }

    public boolean isOffLimitRespected() {
        return isOffLimitRespected;
    }

    public void setOffLimitRespected(boolean offLimitRespected) {
        isOffLimitRespected = offLimitRespected;
    }

    public boolean isHappy() {
        return isHappy;
    }

    public void setHappy(boolean happy) {
        isHappy = happy;
    }

    public LocalDate getLastCallDate() {
        return lastCallDate;
    }

    public void setLastCallDate(LocalDate lastCallDate) {
        this.lastCallDate = lastCallDate;
    }
}
