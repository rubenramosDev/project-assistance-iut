package com.iut.assistance.production.models.dto;

import java.util.Date;

public class AssistanceSheetDtoStudent {

    private Long    assistanceSheetId;
    private String  assistanceSheetStatus;
    private String  teacherName;
    private Date    date;
    private Long    idSemestre;
    private Integer semestre;
    private Long    idGroup;
    private String  groupName;
    private Long    idModule;
    private String  module;
    private Date myAttendanceTime;
    private String statusOfMyAssistance;

    public AssistanceSheetDtoStudent(Long assistanceSheetId, String assistanceSheetStatus, String teacherName, Date date, Long idSemestre, Integer semestre, Long idGroup, String groupName, Long idModule, String module, Date myAttendanceTime, String statusOfMyAssistance) {
        this.assistanceSheetId = assistanceSheetId;
        this.assistanceSheetStatus = assistanceSheetStatus;
        this.teacherName = teacherName;
        this.date = date;
        this.idSemestre = idSemestre;
        this.semestre = semestre;
        this.idGroup = idGroup;
        this.groupName = groupName;
        this.idModule = idModule;
        this.module = module;
        this.myAttendanceTime = myAttendanceTime;
        this.statusOfMyAssistance = statusOfMyAssistance;
    }

    public Long getAssistanceSheetId() {
        return assistanceSheetId;
    }

    public void setAssistanceSheetId(Long assistanceSheetId) {
        this.assistanceSheetId = assistanceSheetId;
    }

    public String getAssistanceSheetStatus() {
        return assistanceSheetStatus;
    }

    public void setAssistanceSheetStatus(String assistanceSheetStatus) {
        this.assistanceSheetStatus = assistanceSheetStatus;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(Long idSemestre) {
        this.idSemestre = idSemestre;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Long idGroup) {
        this.idGroup = idGroup;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getIdModule() {
        return idModule;
    }

    public void setIdModule(Long idModule) {
        this.idModule = idModule;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Date getMyAttendanceTime() {
        return myAttendanceTime;
    }

    public void setMyAttendanceTime(Date myAttendanceTime) {
        this.myAttendanceTime = myAttendanceTime;
    }

    public String getStatusOfMyAssistance() {
        return statusOfMyAssistance;
    }

    public void setStatusOfMyAssistance(String statusOfMyAssistance) {
        this.statusOfMyAssistance = statusOfMyAssistance;
    }
}
