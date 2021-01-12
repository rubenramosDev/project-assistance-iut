package com.iut.assistance.production.models.dto;

public class StudentAssistanceSheetDto {

    private Long   assistanceSheetId;
    private String identifierNumber;
    private String status;

    public Long getAssistanceSheetId() {
        return assistanceSheetId;
    }

    public void setAssistanceSheetId(Long assistanceSheetId) {
        this.assistanceSheetId = assistanceSheetId;
    }

    public String getIdentifierNumber() {
        return identifierNumber;
    }

    public void setIdentifierNumber(String identifierNumber) {
        this.identifierNumber = identifierNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}