package com.example.rua.model;

import javax.persistence.Entity;
import javax.persistence.Table;


public class SurveyDTO {

    private String studentContactNumber;
    private Integer parentsDesiredAudioCalls;
    private Integer parentsDesiredVideoCalls;
    private Integer parentsDesiredTexts;
    private Integer parentsDesiredNoCallDays;
    private String parentContactNumber;
    private Integer studentsDesiredAudioCalls;
    private Integer studentsDesiredVideoCalls;
    private Integer studentsDesiredTexts;
    private Integer studentsDesiredNoCallDays;
    private boolean grades;
    private boolean dating;
    private boolean food;
    private boolean money;
    private boolean job;
    private boolean health;
    private Integer plannedAudioCalls;
    private Integer plannedVideoCalls;
    private Integer plannedTextMessages;
    private String message;

    public SurveyDTO(){

    }

//    public SurveyDTO(String studentContactNumber, Integer parentsDesiredAudioCalls, Integer parentsDesiredVideoCalls, Integer parentsDesiredTexts, Integer parentsDesiredNoCallDays, String parentContactNumber, Integer studentsDesiredAudioCalls, Integer studentsDesiredVideoCalls, Integer studentsDesiredTexts, Integer studentsDesiredNoCallDays) {
//        this.studentContactNumber = studentContactNumber;
//        this.parentsDesiredAudioCalls = parentsDesiredAudioCalls;
//        this.parentsDesiredVideoCalls = parentsDesiredVideoCalls;
//        this.parentsDesiredTexts = parentsDesiredTexts;
//        this.parentsDesiredNoCallDays = parentsDesiredNoCallDays;
//        this.parentContactNumber = parentContactNumber;
//        this.studentsDesiredAudioCalls = studentsDesiredAudioCalls;
//        this.studentsDesiredVideoCalls = studentsDesiredVideoCalls;
//        this.studentsDesiredTexts = studentsDesiredTexts;
//        this.studentsDesiredNoCallDays = studentsDesiredNoCallDays;
//    }


    public SurveyDTO(String studentContactNumber, Integer parentsDesiredAudioCalls, Integer parentsDesiredVideoCalls, Integer parentsDesiredTexts, Integer parentsDesiredNoCallDays, String parentContactNumber, Integer studentsDesiredAudioCalls, Integer studentsDesiredVideoCalls, Integer studentsDesiredTexts, Integer studentsDesiredNoCallDays, boolean grades, boolean dating, boolean food, boolean money, boolean job, boolean health, Integer plannedAudioCalls, Integer plannedVideoCalls, Integer plannedTextMessages, String message) {
        this.studentContactNumber = studentContactNumber;
        this.parentsDesiredAudioCalls = parentsDesiredAudioCalls;
        this.parentsDesiredVideoCalls = parentsDesiredVideoCalls;
        this.parentsDesiredTexts = parentsDesiredTexts;
        this.parentsDesiredNoCallDays = parentsDesiredNoCallDays;
        this.parentContactNumber = parentContactNumber;
        this.studentsDesiredAudioCalls = studentsDesiredAudioCalls;
        this.studentsDesiredVideoCalls = studentsDesiredVideoCalls;
        this.studentsDesiredTexts = studentsDesiredTexts;
        this.studentsDesiredNoCallDays = studentsDesiredNoCallDays;
        this.grades = grades;
        this.dating = dating;
        this.food = food;
        this.money = money;
        this.job = job;
        this.health = health;
        this.plannedAudioCalls = plannedAudioCalls;
        this.plannedVideoCalls = plannedVideoCalls;
        this.plannedTextMessages = plannedTextMessages;
        this.message = message;
    }

    public String getStudentContactNumber() {
        return studentContactNumber;
    }

    public void setStudentContactNumber(String studentContactNumber) {
        this.studentContactNumber = studentContactNumber;
    }

    public Integer getParentsDesiredAudioCalls() {
        return parentsDesiredAudioCalls;
    }

    public void setParentsDesiredAudioCalls(Integer parentsDesiredAudioCalls) {
        this.parentsDesiredAudioCalls = parentsDesiredAudioCalls;
    }

    public Integer getParentsDesiredVideoCalls() {
        return parentsDesiredVideoCalls;
    }

    public void setParentsDesiredVideoCalls(Integer parentsDesiredVideoCalls) {
        this.parentsDesiredVideoCalls = parentsDesiredVideoCalls;
    }

    public Integer getParentsDesiredTexts() {
        return parentsDesiredTexts;
    }

    public void setParentsDesiredTexts(Integer parentsDesiredTexts) {
        this.parentsDesiredTexts = parentsDesiredTexts;
    }

    public Integer getParentsDesiredNoCallDays() {
        return parentsDesiredNoCallDays;
    }

    public void setParentsDesiredNoCallDays(Integer parentsDesiredNoCallDays) {
        this.parentsDesiredNoCallDays = parentsDesiredNoCallDays;
    }

    public String getParentContactNumber() {
        return parentContactNumber;
    }

    public void setParentContactNumber(String parentContactNumber) {
        this.parentContactNumber = parentContactNumber;
    }

    public Integer getStudentsDesiredAudioCalls() {
        return studentsDesiredAudioCalls;
    }

    public void setStudentsDesiredAudioCalls(Integer studentsDesiredAudioCalls) {
        this.studentsDesiredAudioCalls = studentsDesiredAudioCalls;
    }

    public Integer getStudentsDesiredVideoCalls() {
        return studentsDesiredVideoCalls;
    }

    public void setStudentsDesiredVideoCalls(Integer studentsDesiredVideoCalls) {
        this.studentsDesiredVideoCalls = studentsDesiredVideoCalls;
    }

    public Integer getStudentsDesiredTexts() {
        return studentsDesiredTexts;
    }

    public void setStudentsDesiredTexts(Integer studentsDesiredTexts) {
        this.studentsDesiredTexts = studentsDesiredTexts;
    }

    public Integer getStudentsDesiredNoCallDays() {
        return studentsDesiredNoCallDays;
    }

    public void setStudentsDesiredNoCallDays(Integer studentsDesiredNoCallDays) {
        this.studentsDesiredNoCallDays = studentsDesiredNoCallDays;
    }

    public boolean isGrades() {
        return grades;
    }

    public void setGrades(boolean grades) {
        this.grades = grades;
    }

    public boolean isDating() {
        return dating;
    }

    public void setDating(boolean dating) {
        this.dating = dating;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isMoney() {
        return money;
    }

    public void setMoney(boolean money) {
        this.money = money;
    }

    public boolean isJob() {
        return job;
    }

    public void setJob(boolean job) {
        this.job = job;
    }

    public boolean isHealth() {
        return health;
    }

    public void setHealth(boolean health) {
        this.health = health;
    }

    public Integer getPlannedAudioCalls() {
        return plannedAudioCalls;
    }

    public void setPlannedAudioCalls(Integer plannedAudioCalls) {
        this.plannedAudioCalls = plannedAudioCalls;
    }

    public Integer getPlannedVideoCalls() {
        return plannedVideoCalls;
    }

    public void setPlannedVideoCalls(Integer plannedVideoCalls) {
        this.plannedVideoCalls = plannedVideoCalls;
    }

    public Integer getPlannedTextMessages() {
        return plannedTextMessages;
    }

    public void setPlannedTextMessages(Integer plannedTextMessages) {
        this.plannedTextMessages = plannedTextMessages;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
