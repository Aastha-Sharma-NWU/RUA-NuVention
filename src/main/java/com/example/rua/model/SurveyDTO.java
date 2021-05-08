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

    public SurveyDTO(String studentContactNumber, Integer parentsDesiredAudioCalls, Integer parentsDesiredVideoCalls, Integer parentsDesiredTexts, Integer parentsDesiredNoCallDays, String parentContactNumber, Integer studentsDesiredAudioCalls, Integer studentsDesiredVideoCalls, Integer studentsDesiredTexts, Integer studentsDesiredNoCallDays) {
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
}
