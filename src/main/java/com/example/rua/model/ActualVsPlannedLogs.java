package com.example.rua.model;

public class ActualVsPlannedLogs {

    private Integer plannedAudioCalls;
    private Integer plannedVideoCalls;
    private Integer plannedTextMessages;
    private Integer actualAudioCalls;
    private Integer actualVideoCalls;
    private Integer actualTextMessages;
    private String message;

    public ActualVsPlannedLogs(){

    }

    public ActualVsPlannedLogs(Integer plannedAudioCalls, Integer plannedVideoCalls, Integer plannedTextMessages, Integer actualAudioCalls, Integer actualVideoCalls, Integer actualTextMessages, String message) {
        this.plannedAudioCalls = plannedAudioCalls;
        this.plannedVideoCalls = plannedVideoCalls;
        this.plannedTextMessages = plannedTextMessages;
        this.actualAudioCalls = actualAudioCalls;
        this.actualVideoCalls = actualVideoCalls;
        this.actualTextMessages = actualTextMessages;
        this.message = message;
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

    public Integer getActualAudioCalls() {
        return actualAudioCalls;
    }

    public void setActualAudioCalls(Integer actualAudioCalls) {
        this.actualAudioCalls = actualAudioCalls;
    }

    public Integer getActualVideoCalls() {
        return actualVideoCalls;
    }

    public void setActualVideoCalls(Integer actualVideoCalls) {
        this.actualVideoCalls = actualVideoCalls;
    }

    public Integer getActualTextMessages() {
        return actualTextMessages;
    }

    public void setActualTextMessages(Integer actualTextMessages) {
        this.actualTextMessages = actualTextMessages;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
