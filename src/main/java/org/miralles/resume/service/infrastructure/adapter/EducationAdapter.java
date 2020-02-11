package org.miralles.resume.service.infrastructure.adapter;

import org.miralles.resume.service.domain.entity.Education;
import org.miralles.resume.service.infrastructure.repository.mongo.model.EducationEntity;

import java.util.ArrayList;
import java.util.List;

public class EducationAdapter {
    public List<Education> adaptEducation(List<EducationEntity> educationEntityList) {
        List<Education> educationInfoList = new ArrayList<>();
        for (EducationEntity educationEntity : educationEntityList) {
            educationInfoList.add(new Education(educationEntity.getLanguage(), getFormattedDate(educationEntity), educationEntity.getTitle(), educationEntity.getSubTitle(), educationEntity.getDescription()));
        }
        return educationInfoList;
    }
    private String getFormattedDate(EducationEntity educationEntity) {
        return (educationEntity.getEndDate() != null) ? educationEntity.getStartDate() + " - " + educationEntity.getEndDate() : educationEntity.getStartDate();
    }
}
