package com.example.rua.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Survey {
    @Id
    @SequenceGenerator(
            name="survey_sequence",
            sequenceName = "survey_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator ="survey_sequence"
    )
    private Long id;
    private Integer parentId;
    private Integer studentId;
    private Integer parentsDesiredAudioCalls;
    private Integer parentsDesiredVideoCalls;
    private Integer parentsDesiredTexts;
    private Integer parentsDesiredNoCallDays;

    private Integer studentsDesiredAudioCalls;
    private Integer studentsDesiredVideoCalls;
    private Integer studentsDesiredTexts;
    private Integer studentsDesiredNoCallDays;

    public Survey() {
    }

    public Survey(Long id, Integer parentId, Integer studentId, Integer parentsDesiredAudioCalls, Integer parentsDesiredVideoCalls, Integer parentsDesiredTexts, Integer parentsDesiredNoCallDays, Integer studentsDesiredAudioCalls, Integer studentsDesiredVideoCalls, Integer studentsDesiredTexts, Integer studentsDesiredNoCallDays) {
        this.id = id;
        this.parentId = parentId;
        this.studentId = studentId;
        this.parentsDesiredAudioCalls = parentsDesiredAudioCalls;
        this.parentsDesiredVideoCalls = parentsDesiredVideoCalls;
        this.parentsDesiredTexts = parentsDesiredTexts;
        this.parentsDesiredNoCallDays = parentsDesiredNoCallDays;
        this.studentsDesiredAudioCalls = studentsDesiredAudioCalls;
        this.studentsDesiredVideoCalls = studentsDesiredVideoCalls;
        this.studentsDesiredTexts = studentsDesiredTexts;
        this.studentsDesiredNoCallDays = studentsDesiredNoCallDays;
    }

    public Survey(Integer parentId, Integer studentId, Integer parentsDesiredAudioCalls, Integer parentsDesiredVideoCalls, Integer parentsDesiredTexts, Integer parentsDesiredNoCallDays, Integer studentsDesiredAudioCalls, Integer studentsDesiredVideoCalls, Integer studentsDesiredTexts, Integer studentsDesiredNoCallDays) {
        this.parentId = parentId;
        this.studentId = studentId;
        this.parentsDesiredAudioCalls = parentsDesiredAudioCalls;
        this.parentsDesiredVideoCalls = parentsDesiredVideoCalls;
        this.parentsDesiredTexts = parentsDesiredTexts;
        this.parentsDesiredNoCallDays = parentsDesiredNoCallDays;
        this.studentsDesiredAudioCalls = studentsDesiredAudioCalls;
        this.studentsDesiredVideoCalls = studentsDesiredVideoCalls;
        this.studentsDesiredTexts = studentsDesiredTexts;
        this.studentsDesiredNoCallDays = studentsDesiredNoCallDays;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", studentId=" + studentId +
                ", parentsDesiredAudioCalls=" + parentsDesiredAudioCalls +
                ", parentsDesiredVideoCalls=" + parentsDesiredVideoCalls +
                ", parentsDesiredTexts=" + parentsDesiredTexts +
                ", parentsDesiredNoCallDays=" + parentsDesiredNoCallDays +
                ", studentsDesiredAudioCalls=" + studentsDesiredAudioCalls +
                ", studentsDesiredVideoCalls=" + studentsDesiredVideoCalls +
                ", studentsDesiredTexts=" + studentsDesiredTexts +
                ", studentsDesiredNoCallDays=" + studentsDesiredNoCallDays +
                '}';
    }
}
