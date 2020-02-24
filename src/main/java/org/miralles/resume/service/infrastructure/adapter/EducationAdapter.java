package org.miralles.resume.service.infrastructure.adapter;

import org.miralles.resume.service.domain.entity.Education;
import org.miralles.resume.service.infrastructure.repository.mongo.model.EducationEntity;

import java.util.List;
import java.util.stream.Collectors;

public class EducationAdapter {
    public List<Education> adaptEducation(List<EducationEntity> educationEntityList) {
        return educationEntityList.stream()
                .map(this::buildEducation)
                .collect(Collectors.toList());
    }

    private Education buildEducation(EducationEntity educationEntity) {
        return new Education(educationEntity.getLanguage(), getFormattedDate(educationEntity), educationEntity.getTitle(), educationEntity.getSubTitle(), educationEntity.getDescription());
    }

    private String getFormattedDate(EducationEntity educationEntity) {
        return (educationEntity.getEndDate() != null) ? educationEntity.getStartDate() + " - " + educationEntity.getEndDate() : educationEntity.getStartDate();
    }
}
