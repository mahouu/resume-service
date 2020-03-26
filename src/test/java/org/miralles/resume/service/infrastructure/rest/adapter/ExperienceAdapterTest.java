package org.miralles.resume.service.infrastructure.rest.adapter;

import org.junit.Test;
import org.miralles.resume.service.domain.entity.Experience;
import org.miralles.resume.service.domain.entity.ExperienceInfo;
import org.miralles.resume.service.domain.entity.Task;
import org.miralles.resume.service.infrastructure.rest.model.ExperienceView;
import org.miralles.resume.service.infrastructure.rest.model.TaskView;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExperienceAdapterTest {

    private static final String ANY_TASK_DESCRIPTION = "ANY_TASK_DESCRIPTION";
    private static final String ANY_TITLE = "ANY_TITLE";
    private static final String ANY_COMPANY = "ANY_COMPANY";
    private static final String ANY_URL = "ANY_URL";
    private static final String ANY_ROLE_DESCRIPTION = "ANY_ROLE_DESCRIPTION";
    private static final String ANY_START_DATE = "ANY_START_DATE";
    private static final String ANY_END_DATE = "ANY_END_DATE";

    @Test
    public void adaptEducationView() {
        ExperienceAdapter adapter = new ExperienceAdapter();
        Task task = new Task(ANY_TASK_DESCRIPTION);
        TaskView taskView = new TaskView(ANY_TASK_DESCRIPTION);
        Experience experience = new Experience(ANY_TITLE, ANY_COMPANY, ANY_URL, ANY_ROLE_DESCRIPTION, ANY_START_DATE, ANY_END_DATE, singletonList(task));
        ExperienceInfo experienceInfo = new ExperienceInfo(singletonList(experience));
        ExperienceView experienceViewExpected = new ExperienceView(ANY_TITLE, ANY_COMPANY, ANY_URL, ANY_ROLE_DESCRIPTION, ANY_START_DATE, ANY_END_DATE, singletonList(taskView));
        List<ExperienceView> expected = singletonList(experienceViewExpected);

        List<ExperienceView> experienceAdapted = adapter.adaptToEducationViews(experienceInfo);

        assertThat(experienceAdapted, is(equalTo(expected)));
    }

}