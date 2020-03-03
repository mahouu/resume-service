package org.miralles.resume.service.domain.port.primary;

import org.junit.Assert;
import org.junit.Test;
import org.miralles.resume.service.domain.entity.Experience;
import org.miralles.resume.service.domain.entity.Task;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class ExperienceUseCaseTest {

    @Test
    public void givenALanguage_ThenRetrieveAllTheExperience() {
        ExperienceUseCase useCase = new ExperienceUseCase();
        String language = "ANY_LANGUAGE";
        String title = "ANY_TITTLE";
        String company = "ANY_COMPANY";
        String url = "ANY_URL";
        String roleDescription = "ANY_ROL_DESCRIPTION";
        String startDate = "ANY_START_DATE";
        String endDate = "ANY_END_DATE";
        String taskDescription = "ANY_TASK_DESCRIPTION";
        List<Task> tasks = Collections.singletonList(new Task(taskDescription));
        Experience expected = new Experience(title, company, url, roleDescription, startDate, endDate, tasks);

        Experience experience = useCase.execute(language);

        Assert.assertThat(experience, is(equalTo(expected)));
    }

}