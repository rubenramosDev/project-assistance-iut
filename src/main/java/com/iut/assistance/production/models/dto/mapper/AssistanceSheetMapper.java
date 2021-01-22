package com.iut.assistance.production.models.dto.mapper;

import com.iut.assistance.production.models.dto.AssistanceSheetDto;
import com.iut.assistance.production.models.entities.AssistanceSheet;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssistanceSheetMapper {

    public List<AssistanceSheetDto> assitanceSheetToDto(List<AssistanceSheet> sheet) {
        return sheet.stream().map(assistanceSheet -> new AssistanceSheetDto(
                assistanceSheet.getId(),
                assistanceSheet.getStatusSheet().getCode(),
                assistanceSheet.getTeacher().getUser().getName().concat(" ".concat(assistanceSheet.getTeacher().getUser().getLastName())),
                assistanceSheet.getStartDate(),
                assistanceSheet.getGroup().getSemestre().getId(),
                assistanceSheet.getGroup().getSemestre().getSemestre(),
                assistanceSheet.getGroup().getId(),
                assistanceSheet.getGroup().getName(),
                assistanceSheet.getModule().getId(),
                assistanceSheet.getModule().getTitre(), null)).collect(Collectors.toList());
    }

    public AssistanceSheetDto assitanceSheetToDto(AssistanceSheet sheet) {
        return new AssistanceSheetDto(
                sheet.getId(),
                sheet.getStatusSheet().getCode(),
                sheet.getTeacher().getUser().getName().concat(" ".concat(sheet.getTeacher().getUser().getLastName())),
                sheet.getStartDate(),
                sheet.getGroup().getSemestre().getId(),
                sheet.getGroup().getSemestre().getSemestre(),
                sheet.getGroup().getId(),
                sheet.getGroup().getName(),
                sheet.getModule().getId(),
                sheet.getModule().getAbbrev(), null);
    }
}
