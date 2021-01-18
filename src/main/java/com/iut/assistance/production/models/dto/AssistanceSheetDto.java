package com.iut.assistance.production.models.dto;

import java.util.Date;
import java.util.List;

public class AssistanceSheetDto {

    private Long    assistanceSheetId;
    private String  assistanceSheetStatus;
    private String  teacherName;
    private Date    startDate;
    private Long    idSemestre;
    private Integer semestre;
    private Long    idGroup;
    private String  groupName;
    private Long    idModule;
    private String  module;
    private List<StudentAssistance> students;

    public AssistanceSheetDto(Long assistanceSheetId, String assistanceSheetStatus, String teacherName, Date startDate, Long idSemestre, Integer semestre, Long idGroup, String groupName, Long idModule, String module, List<StudentAssistance> students) {
        this.assistanceSheetId = assistanceSheetId;
        this.assistanceSheetStatus = assistanceSheetStatus;
        this.teacherName = teacherName;
        this.startDate = startDate;
        this.idSemestre = idSemestre;
        this.semestre = semestre;
        this.idGroup = idGroup;
        this.groupName = groupName;
        this.idModule = idModule;
        this.module = module;
        this.students = students;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<StudentAssistance> getStudents() {
        return students;
    }

    public void setStudents(List<StudentAssistance> students) {
        this.students = students;
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

    public Long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Long idGroup) {
        this.idGroup = idGroup;
    }

    public Long getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(Long idSemestre) {
        this.idSemestre = idSemestre;
    }
}
