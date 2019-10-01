package org.miralles.resume.service.infrastructure.repository.mongo;

import org.miralles.resume.service.domain.entity.ContactInfo;
import org.miralles.resume.service.domain.port.secondary.ResumeRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ResumeMongoRepository implements ResumeRepository {
    private static final String ANY_EMAIL = "ANY_EMAIL";
    private static final String ANY_MAIL = "ANY_MAIL";
    private static final String ANY_SURNAME = "ANY_SURNAME";
    private static final String ANY_GIT_URL = "ANY_GIT_URL";
    private static final String ANY_SONAR_URL = "ANY_SONAR_URL";
    private static final String ANY_PHONE_NUMBER = "ANY_PHONE_NUMBER";
    private static final String ANY_RESUME_URL = "ANY_RESUME_URL";

    @Override
    public ContactInfo getContactInfo() {
        return new ContactInfo(ANY_EMAIL, ANY_MAIL,
                ANY_SURNAME, ANY_GIT_URL, ANY_SONAR_URL, ANY_PHONE_NUMBER, ANY_RESUME_URL);
    }
}
