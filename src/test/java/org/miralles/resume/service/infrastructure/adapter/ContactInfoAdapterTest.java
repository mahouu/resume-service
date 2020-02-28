package org.miralles.resume.service.infrastructure.adapter;

import org.junit.Assert;
import org.junit.Test;
import org.miralles.resume.service.domain.entity.ContactInfo;
import org.miralles.resume.service.domain.entity.LocationInfo;
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
    private static final String ANY_ADDRESS = "ANY_ADDRESS";
    private static final String ANY_POSTAL_CODE = "ANY_POSTAL_CODE";
    private static final String ANY_CITY = "ANY_CITY";
    private static final String ANY_REGION = "ANY_REGION";
    private static final String ANY_COUNTRY_CODE = "ANY_COUNTRY_CODE";

    @Test
    public void givenAResumeEntity_thenAdaptToContactInfoProperly() {
        LocationInfo locationInfo = new LocationInfo(ANY_ADDRESS, ANY_POSTAL_CODE, ANY_CITY, ANY_REGION, ANY_COUNTRY_CODE);
        ContactInfoEntity contactInfoEntity = new ContactInfoEntity(ANY_EMAIL, ANY_NAME, ANY_SURNAME, ANY_GIT_URL, ANY_SONAR_URL, ANY_PHONE, ANY_RESUME_URL, ANY_ADDRESS, ANY_POSTAL_CODE, ANY_CITY, ANY_REGION, ANY_COUNTRY_CODE);
        ResumeEntity resumeEntity = new ResumeEntity(contactInfoEntity);
        ContactInfoAdapter adapter = new ContactInfoAdapter();
        ContactInfo expected = new ContactInfo(ANY_EMAIL, ANY_NAME, ANY_SURNAME, ANY_GIT_URL, ANY_SONAR_URL, ANY_PHONE, ANY_RESUME_URL, locationInfo);

        ContactInfo result = adapter.adaptContactInfoFromRepositoryEntity(resumeEntity);

        Assert.assertThat(result, is(equalTo(expected)));

    }
}