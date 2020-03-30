package org.miralles.resume.service.infrastructure.adapter;

import org.miralles.resume.service.domain.entity.Experience;
import org.miralles.resume.service.domain.entity.Task;
import org.miralles.resume.service.infrastructure.repository.mongo.model.ExperienceEntity;

import java.util.stream.Collectors;

public class ExperienceAdapter {
    private ExperienceAdapter() {
    }

    public static Experience adapt(final ExperienceEntity experienceEntity) {
        return new Experience(experienceEntity.getTitle(), experienceEntity.getCompany(),
                experienceEntity.getUrl(), experienceEntity.getRoleDescription(), experienceEntity.getStartDate(), experienceEntity.getEndDate(),
                experienceEntity.getTasks()
                        .stream()
                        .map(taskEntity -> new Task(taskEntity.getTaskDescription()))
                        .collect(Collectors.toList()));
    }
}
