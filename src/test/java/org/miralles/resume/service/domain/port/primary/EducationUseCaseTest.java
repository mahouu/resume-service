package org.miralles.resume.service.domain.port.primary;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.miralles.resume.service.domain.entity.Education;
import org.miralles.resume.service.domain.entity.EducationInfo;
import org.miralles.resume.service.domain.port.secondary.ResumeRepository;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EducationUseCaseTest {
    private static final String ANY_LANGUAGE = "ANY_LANGUAGE";
    private static final String ANY_DATE = "ANY_DATE";
    private static final String ANY_TITLE = "ANY_TITLE";
    private static final String ANY_SUBTITLE = "ANY_SUBTITLE";
    private static final String ANY_DESCRIPTION = "ANY_DESCRIPTION";

    @Mock
    ResumeRepository resumeRepository;

    @Test
    public void givenALanguage_ThenReturnTheCorrectEducationInfo() {
        EducationUseCase educationUseCase = new EducationUseCase(resumeRepository);
        EducationInfo expected = new EducationInfo(singletonList(new Education(ANY_LANGUAGE, ANY_DATE, ANY_TITLE, ANY_SUBTITLE, ANY_DESCRIPTION)));
        when(resumeRepository.getEducationInfoBy(ANY_LANGUAGE)).thenReturn(expected);

        EducationInfo educationInfo = educationUseCase.execute(ANY_LANGUAGE);

        Assert.assertThat(expected, is(equalTo(educationInfo)));
    }
}