package org.miralles.resume.service.infrastructure.repository.mongo;

import org.junit.Assert;
import org.junit.Test;
import org.miralles.resume.service.domain.entity.ContactInfo;

import static org.hamcrest.core.IsEqual.equalTo;

public class ResumeMongoRepositoryTest {
    private static final String ANY_EMAIL = "ANY_EMAIL";
    private static final String ANY_MAIL = "ANY_MAIL";
    private static final String ANY_SURNAME = "ANY_SURNAME";
    private static final String ANY_GIT_URL = "ANY_GIT_URL";
    private static final String ANY_SONAR_URL = "ANY_SONAR_URL";
    private static final String ANY_PHONE_NUMBER = "ANY_PHONE_NUMBER";
    private static final String ANY_RESUME_URL = "ANY_RESUME_URL";

    @Test
    public void retrieveContactInfo() {
        ResumeMongoRepository resumeMongoRepository = new ResumeMongoRepository();
        ContactInfo expected = new ContactInfo(ANY_EMAIL, ANY_MAIL,
                ANY_SURNAME, ANY_GIT_URL, ANY_SONAR_URL, ANY_PHONE_NUMBER, ANY_RESUME_URL);

        ContactInfo resumeRepository = resumeMongoRepository.getContactInfo();

        Assert.assertThat(resumeRepository, equalTo(expected));
    }

}