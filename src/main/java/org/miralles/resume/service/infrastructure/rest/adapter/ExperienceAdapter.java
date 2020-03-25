package org.miralles.resume.service.infrastructure.rest.adapter;

import org.miralles.resume.service.domain.entity.ExperienceInfo;
import org.miralles.resume.service.infrastructure.rest.model.ExperienceView;

import java.util.List;
import java.util.stream.Collectors;

public class ExperienceAdapter {//TODO implement test

    public List<ExperienceView> adaptToEducationViews(final ExperienceInfo experienceInfo) {
        return experienceInfo.getExperiences()
                .stream()
                .map(experience ->
                        new ExperienceView(
                                experience.getTitle(),
                                experience.getCompany(),
                                experience.getUrl(),
                                experience.getRoleDescription(),
                                experience.getStartDate(),
                                experience.getEndDate(),
                                experience.getTasks()))
                .collect(Collectors.toList());
    }
}
