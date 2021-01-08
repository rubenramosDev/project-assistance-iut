package com.iut.assistance.production.models.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student_sheet_assistances")
public class StudentSheetAssistance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    //Relations
    @ManyToOne @JoinColumn(name = "assistance_sheet_id")
    private AssistanceSheet assistanceSheet;

    @ManyToOne @JoinColumn(name = "status_assistance_sheet_id")
    private StatusSheetStudent statusSheetStudent;

    @ManyToOne @JoinColumn(name = "student_id")
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AssistanceSheet getAssistanceSheet() {
        return assistanceSheet;
    }

    public void setAssistanceSheet(AssistanceSheet assistanceSheet) {
        this.assistanceSheet = assistanceSheet;
    }

    public StatusSheetStudent getStatusSheetStudent() {
        return statusSheetStudent;
    }

    public void setStatusSheetStudent(StatusSheetStudent statusSheetStudent) {
        this.statusSheetStudent = statusSheetStudent;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
