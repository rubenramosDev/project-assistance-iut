package com.iut.assistance.production.models.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "status_sheets")
public class StatusSheet {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

//    RELATIONS
    @OneToMany(mappedBy = "statusSheet")
    private List<AssistanceSheet> assistanceSheets;

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

    public List<AssistanceSheet> getAssistanceSheets() {
        return assistanceSheets;
    }

    public void setAssistanceSheets(List<AssistanceSheet> assistanceSheets) {
        this.assistanceSheets = assistanceSheets;
    }
}
