package com.example.rua.model;

public class Response {

    private String status;
    private String message;
    private String role;
    private boolean surveyCompleted;

    public Response(){

    }

    public Response(String status, String message, String role, boolean surveyCompleted) {
        this.status = status;
        this.message = message;
        this.role = role;
        this.surveyCompleted = surveyCompleted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean getSurveyCompleted() {
        return surveyCompleted;
    }

    public void setSurveyCompleted(boolean surveyCompleted) {
        this.surveyCompleted = surveyCompleted;
    }
}
