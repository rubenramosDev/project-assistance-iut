package com.iut.assistance.production.models.dto;

import javax.validation.constraints.NotBlank;

public class StudentAssistanceSheet {

    private Long   assitanceSheetId;
    @NotBlank private String studentNumber;

    public StudentAssistanceSheet(@NotBlank Long assitanceSheetId, @NotBlank String studentNumber) {
        this.assitanceSheetId = assitanceSheetId;
        this.studentNumber = studentNumber;
    }

    public Long getAssitanceSheetId() {
        return assitanceSheetId;
    }

    public void setAssitanceSheetId(Long assitanceSheetId) {
        this.assitanceSheetId = assitanceSheetId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
}
