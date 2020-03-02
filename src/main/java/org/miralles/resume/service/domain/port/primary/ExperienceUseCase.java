package org.miralles.resume.service.domain.port.primary;

import org.miralles.resume.service.domain.entity.ExperienceInfo;
import org.miralles.resume.service.domain.entity.Task;

import java.util.Collections;
import java.util.List;

public class ExperienceUseCase {
    public ExperienceInfo execute(final String language) {
        String title = "ANY_TITTLE";
        String company = "ANY_COMPANY";
        String url = "ANY_URL";
        String roleDescription = "ANY_ROL_DESCRIPTION";
        String startDate = "ANY_START_DATE";
        String endDate = "ANY_END_DATE";
        String taskDescription = "ANY_TASK_DESCRIPTION";
        List<Task> tasks = Collections.singletonList(new Task(taskDescription));
        return new ExperienceInfo(title, company, url, roleDescription, startDate, endDate, tasks);
    }
}
