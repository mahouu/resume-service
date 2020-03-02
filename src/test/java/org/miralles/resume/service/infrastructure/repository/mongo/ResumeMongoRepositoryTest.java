package org.miralles.resume.service.infrastructure.repository.mongo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.miralles.resume.service.domain.entity.ExperienceInfo;
import org.miralles.resume.service.domain.entity.Task;
import org.miralles.resume.service.infrastructure.adapter.ContactInfoAdapter;
import org.miralles.resume.service.infrastructure.adapter.EducationAdapter;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class ResumeMongoRepositoryTest {
    private static final String ANY_LANGUAGE = "ANY_LANGUAGE";
    private static final String ANY_TITLE = "ANY_TITLE";
    private static final String ANY_COMPANY = "ANY_COMPANY";
    private static final String ANY_URL = "ANY_URL";
    private static final String ANY_DESCRIPTION = "ANY_DESCRIPTION";
    private static final String ANY_START_DATE = "ANY_START_DATE";
    private static final String ANY_END_DATE = "ANY_END_DATE";
    private static final String ANY_TASK_DESCRIPTION = "ANY_TASK_DESCRIPTION";
    @Mock
    private ContactInfoMongo contactInfoMongo;
    @Mock
    private EducationMongo educationMongo;
    @Mock
    private ContactInfoAdapter contactInfoAdapter;
    @Mock
    private EducationAdapter educationAdapter;
    private ResumeMongoRepository resumeMongoRepository;

    @Before
    public void init() {
        resumeMongoRepository = new ResumeMongoRepository(contactInfoMongo, educationMongo, contactInfoAdapter, educationAdapter);
    }

    @Test
    public void givenALanguage_thenRetrieveAllExperienceInfo() {
        List<ExperienceInfo> experience = resumeMongoRepository.getExperienceInfoBy(ANY_LANGUAGE);
        List<ExperienceInfo> expected = singletonList(new ExperienceInfo(ANY_TITLE, ANY_COMPANY, ANY_URL, ANY_DESCRIPTION, ANY_START_DATE, ANY_END_DATE, singletonList(new Task(ANY_TASK_DESCRIPTION))));

        Assert.assertThat(experience, is(equalTo(expected)));
    }
}