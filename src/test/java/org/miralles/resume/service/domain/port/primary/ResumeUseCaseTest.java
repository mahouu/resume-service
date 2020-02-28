package org.miralles.resume.service.domain.port.primary;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.miralles.resume.service.domain.entity.ContactInfo;
import org.miralles.resume.service.domain.entity.LocationInfo;
import org.miralles.resume.service.domain.entity.ResumeResponse;
import org.miralles.resume.service.domain.port.secondary.ResumeRepository;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ResumeUseCaseTest {

    private static final String ANY_EMAIL = "ANY_EMAIL";
    private static final String ANY_MAIL = "ANY_MAIL";
    private static final String ANY_SURNAME = "ANY_SURNAME";
    private static final String ANY_GIT_URL = "ANY_GIT_URL";
    private static final String ANY_SONAR_URL = "ANY_SONAR_URL";
    private static final String ANY_PHONE_NUMBER = "ANY_PHONE_NUMBER";
    private static final String ANY_RESUME_URL = "ANY_RESUME_URL";
    private static final String ANY_ADDRESS = "ANY_ADDRESS";
    private static final String ANY_POSTAL_CODE = "ANY_POSTAL_CODE";
    private static final String ANY_CITY = "ANY_CITY";
    private static final String ANY_REGION = "ANY_REGION";
    private static final String ANY_COUNTRY_CODE = "ANY_COUNTRY_CODE";
    @Mock
    ResumeRepository resumeRepository;

    @Test
    public void retrievePersonalInfo() {
        LocationInfo locationInfo = new LocationInfo(ANY_ADDRESS, ANY_POSTAL_CODE, ANY_CITY, ANY_REGION, ANY_COUNTRY_CODE);
        when(resumeRepository.getContactInfo()).thenReturn(new ContactInfo(ANY_EMAIL, ANY_MAIL,
                ANY_SURNAME, ANY_GIT_URL, ANY_SONAR_URL, ANY_PHONE_NUMBER, ANY_RESUME_URL, locationInfo));
        ResumeUseCase resumeUseCase = new ResumeUseCase(resumeRepository);
        ResumeResponse expected = new ResumeResponse(new ContactInfo(ANY_EMAIL, ANY_MAIL,
                ANY_SURNAME, ANY_GIT_URL, ANY_SONAR_URL, ANY_PHONE_NUMBER, ANY_RESUME_URL, locationInfo));

        ResumeResponse resumeResponse = resumeUseCase.getPersonalInfo();

        Assert.assertThat(resumeResponse, equalTo(expected));
    }
}