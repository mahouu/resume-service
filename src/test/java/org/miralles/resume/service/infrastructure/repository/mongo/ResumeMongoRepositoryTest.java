package org.miralles.resume.service.infrastructure.repository.mongo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.miralles.resume.service.domain.entity.ContactInfo;
import org.miralles.resume.service.infrastructure.repository.mongo.model.ContactInfoEntity;
import org.miralles.resume.service.infrastructure.repository.mongo.model.ResumeEntity;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ResumeMongoRepositoryTest {
    private static final String ANY_EMAIL = "ANY_EMAIL";
    private static final String ANY_NAME = "nombre";//TODO change it
    private static final String ANY_SURNAME = "ANY_SURNAME";
    private static final String ANY_GIT_URL = "ANY_GIT_URL";
    private static final String ANY_SONAR_URL = "ANY_SONAR_URL";
    private static final String ANY_PHONE_NUMBER = "ANY_PHONE_NUMBER";
    private static final String ANY_RESUME_URL = "ANY_RESUME_URL";

    @Mock
    private ResumeMongo resumeMongo;
    @Mock
    private EducationMongo educationMongo;
    private ResumeMongoRepository resumeMongoRepository;

    @Before
    public void setUp() {
        ContactInfoEntity contactInfoEntity = new ContactInfoEntity(ANY_EMAIL, ANY_NAME,
                ANY_SURNAME, ANY_GIT_URL, ANY_SONAR_URL, ANY_PHONE_NUMBER, ANY_RESUME_URL);
        ResumeEntity resumeEntity = new ResumeEntity(contactInfoEntity);
        when(resumeMongo.findFirstByContactInfoEntity_Name(ANY_NAME)).thenReturn(resumeEntity);
        resumeMongoRepository = new ResumeMongoRepository(resumeMongo, educationMongo);
    }

    @Test
    public void retrieveContactInfo() {
        ContactInfo expected = new ContactInfo(ANY_EMAIL, ANY_NAME,
                ANY_SURNAME, ANY_GIT_URL, ANY_SONAR_URL, ANY_PHONE_NUMBER, ANY_RESUME_URL);

        ContactInfo resumeRepository = resumeMongoRepository.getContactInfo();

        Assert.assertThat(resumeRepository, equalTo(expected));
    }

}