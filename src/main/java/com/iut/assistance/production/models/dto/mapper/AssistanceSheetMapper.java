package com.iut.assistance.production.models.dto.mapper;

import com.iut.assistance.production.models.dto.AssistanceSheetDto;
import com.iut.assistance.production.models.entities.AssistanceSheet;
import org.springframework.stereotype.Component;

@Component
public class AssistanceSheetMapper {

    public AssistanceSheetDto assitanceSheetToDto(AssistanceSheet sheet){
        return new AssistanceSheetDto(
                sheet.getId(),
                sheet.getStatusSheet().getCode(),
                sheet.getTeacher().getUser().getName().concat(" ".concat(sheet.getTeacher().getUser().getLastName())),
                sheet.getStartDate(),
                sheet.getGroup().getSemestre().getSemestre(),
                sheet.getGroup().getName(), null);
    }

}
