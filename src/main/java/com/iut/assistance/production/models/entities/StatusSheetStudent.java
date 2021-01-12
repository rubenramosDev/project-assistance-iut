package com.iut.assistance.production.models.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "status_sheet_students")
public class StatusSheetStudent {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

//    RELATIONS
    @OneToMany(mappedBy = "statusSheetStudent")
    private List<StudentSheetAssistance> studentSheetAssistances;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<StudentSheetAssistance> getStudentSheetAssistances() {
        return studentSheetAssistances;
    }

    public void setStudentSheetAssistances(List<StudentSheetAssistance> studentSheetAssistances) {
        this.studentSheetAssistances = studentSheetAssistances;
    }
}
