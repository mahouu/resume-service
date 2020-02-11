package org.miralles.resume.service.infrastructure.repository.mongo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.miralles.resume.service.domain.entity.ContactInfo;
import org.miralles.resume.service.domain.entity.Education;
import org.miralles.resume.service.domain.entity.EducationInfo;
import org.miralles.resume.service.infrastructure.adapter.ContactInfoAdapter;
import org.miralles.resume.service.infrastructure.repository.mongo.model.ContactInfoEntity;
import org.miralles.resume.service.infrastructure.repository.mongo.model.EducationEntity;
import org.miralles.resume.service.infrastructure.repository.mongo.model.ResumeEntity;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContactInfoMongoRepositoryTest {
    private static final String ANY_EMAIL = "ANY_EMAIL";
    private static final String ANY_NAME = "ANY_NAME";
    private static final String ANY_SURNAME = "ANY_SURNAME";
    private static final String ANY_GIT_URL = "ANY_GIT_URL";
    private static final String ANY_SONAR_URL = "ANY_SONAR_URL";
    private static final String ANY_PHONE_NUMBER = "ANY_PHONE_NUMBER";
    private static final String ANY_RESUME_URL = "ANY_RESUME_URL";
    private static final String ANY_LANGUAGE = "ANY_LANGUAGE";
    private static final String ANY_DATE = "ANY_DATE";
    private static final String ANY_FULL_DATE = "ANY_DATE - ANY_DATE";
    private static final String ANY_TITLE = "ANY_TITLE";
    private static final String ANY_SUBTITLE = "ANY_SUBTITLE";
    private static final String ANY_DESCRIPTION = "ANY_DESCRIPTION";

    @Mock
    private ContactInfoMongo contactInfoMongo;
    @Mock
    private EducationMongo educationMongo;
    @Mock
    private ContactInfoAdapter contactInfoAdapter;
    private ResumeMongoRepository resumeMongoRepository;

    @Before
    public void setUp() {
        ContactInfoEntity contactInfoEntity = new ContactInfoEntity(ANY_EMAIL, ANY_NAME,
                ANY_SURNAME, ANY_GIT_URL, ANY_SONAR_URL, ANY_PHONE_NUMBER, ANY_RESUME_URL);
        ResumeEntity resumeEntity = new ResumeEntity(contactInfoEntity);
        when(contactInfoMongo.findFirstByContactInfoEntity_Name(ANY_NAME)).thenReturn(resumeEntity);
        List<EducationEntity> educationEntity = List.of(new EducationEntity(ANY_LANGUAGE, ANY_DATE, null, ANY_TITLE, ANY_SUBTITLE, ANY_DESCRIPTION));
        when(educationMongo.findAllByLanguage(ANY_LANGUAGE)).thenReturn(educationEntity);
        resumeMongoRepository = new ResumeMongoRepository(contactInfoMongo, educationMongo, contactInfoAdapter);
    }

    @Test
    public void retrieveContactInfo() {
        ContactInfo expected = new ContactInfo(ANY_EMAIL, ANY_NAME,
                ANY_SURNAME, ANY_GIT_URL, ANY_SONAR_URL, ANY_PHONE_NUMBER, ANY_RESUME_URL);
        when(contactInfoAdapter.adaptContactInfoFromRepositoryEntity(any())).thenReturn(expected);

        ContactInfo resumeRepository = resumeMongoRepository.getContactInfo();

        Assert.assertThat(resumeRepository, equalTo(expected));
    }

    @Test
    public void retrieveEducationInfoWithoutEndDate() {
        EducationInfo expectedEducationInfo = new EducationInfo(singletonList(new Education(ANY_LANGUAGE, ANY_DATE, ANY_TITLE, ANY_SUBTITLE, ANY_DESCRIPTION)));

        EducationInfo educationInfo = resumeMongoRepository.getEducationInfoBy(ANY_LANGUAGE);

        Assert.assertThat(educationInfo, equalTo(expectedEducationInfo));
    }

    @Test
    public void retrieveEducationInfoWithEndDate() {
        List<EducationEntity> educationEntity = List.of(new EducationEntity(ANY_LANGUAGE, ANY_DATE, ANY_DATE, ANY_TITLE, ANY_SUBTITLE, ANY_DESCRIPTION));
        when(educationMongo.findAllByLanguage(ANY_LANGUAGE)).thenReturn(educationEntity);
        EducationInfo expectedEducationInfo = new EducationInfo(singletonList(new Education(ANY_LANGUAGE, ANY_FULL_DATE, ANY_TITLE, ANY_SUBTITLE, ANY_DESCRIPTION)));

        EducationInfo educationInfo = resumeMongoRepository.getEducationInfoBy(ANY_LANGUAGE);

        Assert.assertThat(educationInfo, equalTo(expectedEducationInfo));
    }

}