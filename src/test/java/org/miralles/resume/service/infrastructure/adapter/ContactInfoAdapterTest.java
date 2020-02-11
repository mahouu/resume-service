package org.miralles.resume.service.infrastructure.adapter;

import org.junit.Assert;
import org.junit.Test;
import org.miralles.resume.service.domain.entity.ContactInfo;
import org.miralles.resume.service.infrastructure.repository.mongo.model.ContactInfoEntity;
import org.miralles.resume.service.infrastructure.repository.mongo.model.ResumeEntity;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class ContactInfoAdapterTest {

    private static final String ANY_EMAIL = "ANY_EMAIL";
    private static final String ANY_NAME = "ANY_NAME";
    private static final String ANY_SURNAME = "ANY_SURNAME";
    private static final String ANY_GIT_URL = "ANY_GIT_URL";
    private static final String ANY_SONAR_URL = "ANY_SONAR_URL";
    private static final String ANY_PHONE = "ANY_PHONE";
    private static final String ANY_RESUME_URL = "ANY_RESUME_URL";

    @Test
    public void givenAResumeEntity_thenAdaptToContactInfoProperly() {
        ContactInfoEntity contactInfoEntity = new ContactInfoEntity(ANY_EMAIL, ANY_NAME, ANY_SURNAME, ANY_GIT_URL, ANY_SONAR_URL, ANY_PHONE, ANY_RESUME_URL);
        ResumeEntity resumeEntity = new ResumeEntity(contactInfoEntity);
        ContactInfoAdapter adapter = new ContactInfoAdapter();
        ContactInfo expected = new ContactInfo(ANY_EMAIL, ANY_NAME, ANY_SURNAME, ANY_GIT_URL, ANY_SONAR_URL, ANY_PHONE, ANY_RESUME_URL);

        ContactInfo result = adapter.adaptContactInfoFromRepositoryEntity(resumeEntity);

        Assert.assertThat(result, is(equalTo(expected)));

    }
}