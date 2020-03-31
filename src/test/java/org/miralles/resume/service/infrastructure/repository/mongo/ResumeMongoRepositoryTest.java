package org.miralles.resume.service.infrastructure.repository.mongo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.miralles.resume.service.domain.entity.Experience;
import org.miralles.resume.service.domain.entity.ExperienceInfo;
import org.miralles.resume.service.domain.entity.Skill;
import org.miralles.resume.service.domain.entity.SkillInfo;
import org.miralles.resume.service.domain.entity.SkillKeyword;
import org.miralles.resume.service.domain.entity.Task;
import org.miralles.resume.service.infrastructure.adapter.ContactInfoAdapter;
import org.miralles.resume.service.infrastructure.adapter.EducationAdapter;
import org.miralles.resume.service.infrastructure.adapter.SkillAdapter;
import org.miralles.resume.service.infrastructure.repository.mongo.model.ExperienceEntity;
import org.miralles.resume.service.infrastructure.repository.mongo.model.SkillEntity;
import org.miralles.resume.service.infrastructure.repository.mongo.model.TaskEntity;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

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
    private static final String ANY_LEVEL = "ANY_LEVEL";
    private static final String ANY_SKILL = "ANY_SKILL";
    @Mock
    private ContactInfoMongo contactInfoMongo;
    @Mock
    private EducationMongo educationMongo;
    @Mock
    private ContactInfoAdapter contactInfoAdapter;
    @Mock
    private EducationAdapter educationAdapter;
    private ResumeMongoRepository resumeMongoRepository;
    @Mock
    private ExperienceMongo experienceMongo;
    @Mock
    private SkillMongo skillMongo;
    @Mock
    private SkillAdapter skillAdapter;

    @Before
    public void init() {
        resumeMongoRepository = new ResumeMongoRepository(contactInfoMongo, educationMongo, contactInfoAdapter, educationAdapter, experienceMongo, skillMongo, skillAdapter);
    }

    @Test
    public void givenALanguage_thenRetrieveAllExperienceInfo() {
        ExperienceInfo expected = new ExperienceInfo(singletonList(new Experience(ANY_TITLE, ANY_COMPANY, ANY_URL, ANY_DESCRIPTION, ANY_START_DATE, ANY_END_DATE, singletonList(new Task(ANY_TASK_DESCRIPTION)))));
        List<ExperienceEntity> experienceEntity = singletonList(new ExperienceEntity(ANY_LANGUAGE, ANY_TITLE, ANY_COMPANY, ANY_URL, ANY_DESCRIPTION, ANY_START_DATE, ANY_END_DATE, singletonList(new TaskEntity(ANY_TASK_DESCRIPTION))));
        when(experienceMongo.findAllByLanguage(ANY_LANGUAGE)).thenReturn(experienceEntity);

        ExperienceInfo experience = resumeMongoRepository.getExperienceInfoBy(ANY_LANGUAGE);

        assertThat(experience, is(equalTo(expected)));
    }

    @Test
    public void givenALanguage_thenRetrieveAllSkillsInfo() {
        List<SkillEntity> skillEntity = singletonList(new SkillEntity(ANY_DESCRIPTION, ANY_LEVEL, singletonList(ANY_SKILL), ANY_LANGUAGE));
        when(skillMongo.findAllByLanguage(ANY_LANGUAGE)).thenReturn(skillEntity);
        Skill skill = new Skill(ANY_DESCRIPTION, ANY_LEVEL, singletonList(new SkillKeyword(ANY_SKILL)));
        SkillInfo expected = new SkillInfo(singletonList(skill));
        when(skillAdapter.adaptSkillEntity(skillEntity)).thenReturn(singletonList(skill));

        SkillInfo skillInfo = resumeMongoRepository.getSkillInfoBy(ANY_LANGUAGE);

        assertThat(skillInfo, is(equalTo(expected)));
    }
}