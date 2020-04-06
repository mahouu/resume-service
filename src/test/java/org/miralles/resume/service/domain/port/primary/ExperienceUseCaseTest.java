package org.miralles.resume.service.domain.port.primary;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.miralles.resume.service.domain.entity.Experience;
import org.miralles.resume.service.domain.entity.ExperienceInfo;
import org.miralles.resume.service.domain.entity.Task;
import org.miralles.resume.service.domain.port.secondary.ResumeRepository;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;

import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExperienceUseCaseTest {
    @Mock
    private ResumeRepository resumeRepository;
    private ExperienceUseCase useCase;

    private final static String ANY_LANGUAGE = "ANY_LANGUAGE";
    private final static String ANY_TITTLE = "ANY_TITTLE";
    private final static String ANY_COMPANY = "ANY_COMPANY";
    private final static String ANY_URL = "ANY_URL";
    private final static String ANY_ROL_DESCRIPTION = "ANY_ROL_DESCRIPTION";
    private final static String ANY_START_DATE = "ANY_START_DATE";
    private final static String ANY_END_DATE = "ANY_END_DATE";
    private final static String ANY_TASK_DESCRIPTION = "ANY_TASK_DESCRIPTION";

    @Before
    public void setUp() {
        useCase = new ExperienceUseCase(resumeRepository);
    }

    @Test
    public void givenALanguage_ThenRetrieveAllTheExperience() {
        Experience expected = new Experience(ANY_TITTLE, ANY_COMPANY, ANY_URL, ANY_ROL_DESCRIPTION, ANY_START_DATE, ANY_END_DATE, singletonList(new Task(ANY_TASK_DESCRIPTION)));
        LinkedList<Experience> expectedList = new LinkedList();
        expectedList.add(expected);
        ExperienceInfo expectedExperienceInfo = new ExperienceInfo(expectedList);
        when(resumeRepository.getExperienceInfoBy(ANY_LANGUAGE)).thenReturn(expectedExperienceInfo);
        ExperienceInfo experienceInfoExpected = new ExperienceInfo(expectedList);

        ExperienceInfo experience = useCase.execute(ANY_LANGUAGE);

        Assert.assertThat(experience, is(equalTo(experienceInfoExpected)));
    }

}