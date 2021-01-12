package com.iut.assistance.production.models.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "assistance_sheets")
public class AssistanceSheet {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    //RELATIONS

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "status_sheet_id")
    private StatusSheet statusSheet;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    @OneToMany(mappedBy = "assistanceSheet", fetch = FetchType.EAGER)
    private List<StudentSheetAssistance> studentSheetAssistances;

//    End relations

    public AssistanceSheet() {
    }

    public AssistanceSheet(Date startDate, Teacher teacher, Group group, StatusSheet statusSheet, Module module) {
        this.startDate = startDate;
        this.teacher = teacher;
        this.group = group;
        this.statusSheet = statusSheet;
        this.module = module;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public StatusSheet getStatusSheet() {
        return statusSheet;
    }

    public void setStatusSheet(StatusSheet statusSheet) {
        this.statusSheet = statusSheet;
    }

    public List<StudentSheetAssistance> getStudentSheetAssistances() {
        return studentSheetAssistances;
    }

    public void setStudentSheetAssistances(List<StudentSheetAssistance> studentSheetAssistances) {
        this.studentSheetAssistances = studentSheetAssistances;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
