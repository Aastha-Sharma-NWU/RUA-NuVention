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
    private Long parentId;
    private Long studentId;
    private Integer parentsDesiredAudioCalls;
    private Integer parentsDesiredVideoCalls;
    private Integer parentsDesiredTexts;
    private Integer parentsDesiredNoCallDays;

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


    public Survey() {
    }

    public Survey(Long id, Long parentId, Long studentId, Integer parentsDesiredAudioCalls, Integer parentsDesiredVideoCalls, Integer parentsDesiredTexts, Integer parentsDesiredNoCallDays, Integer studentsDesiredAudioCalls, Integer studentsDesiredVideoCalls, Integer studentsDesiredTexts, Integer studentsDesiredNoCallDays, boolean grades, boolean dating, boolean food, boolean money, boolean job, boolean health, Integer plannedAudioCalls, Integer plannedVideoCalls, Integer plannedTextMessages) {
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
        this.grades = grades;
        this.dating = dating;
        this.food = food;
        this.money = money;
        this.job = job;
        this.health = health;
        this.plannedAudioCalls = plannedAudioCalls;
        this.plannedVideoCalls = plannedVideoCalls;
        this.plannedTextMessages = plannedTextMessages;
    }

    public Survey(Long parentId, Long studentId, Integer parentsDesiredAudioCalls, Integer parentsDesiredVideoCalls, Integer parentsDesiredTexts, Integer parentsDesiredNoCallDays, Integer studentsDesiredAudioCalls, Integer studentsDesiredVideoCalls, Integer studentsDesiredTexts, Integer studentsDesiredNoCallDays, boolean grades, boolean dating, boolean food, boolean money, boolean job, boolean health, Integer plannedAudioCalls, Integer plannedVideoCalls, Integer plannedTextMessages) {
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
        this.grades = grades;
        this.dating = dating;
        this.food = food;
        this.money = money;
        this.job = job;
        this.health = health;
        this.plannedAudioCalls = plannedAudioCalls;
        this.plannedVideoCalls = plannedVideoCalls;
        this.plannedTextMessages = plannedTextMessages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
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
                ", grades=" + grades +
                ", dating=" + dating +
                ", food=" + food +
                ", money=" + money +
                ", job=" + job +
                ", health=" + health +
                ", plannedAudioCalls=" + plannedAudioCalls +
                ", plannedVideoCalls=" + plannedVideoCalls +
                ", plannedTextMessages=" + plannedTextMessages +
                '}';
    }
}
