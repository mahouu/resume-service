package org.miralles.resume.service.infrastructure.rest.adapter;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.miralles.resume.service.domain.entity.ContactInfo;
import org.miralles.resume.service.domain.entity.LocationInfo;
import org.miralles.resume.service.domain.entity.ResumeResponse;
import org.miralles.resume.service.infrastructure.rest.model.ContactInfoView;
import org.miralles.resume.service.infrastructure.rest.model.LocationView;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class ContactInfoViewAdapterTest {

    private static final String ANY_EMAIL = "ANY_EMAIL";
    private static final String ANY_NAME = "ANY_NAME";
    private static final String ANY_SURNAME = "ANY_SURNAME";
    private static final String ANY_GITURL = "ANY_GITURL";
    private static final String ANY_SONARURL = "ANY_SONARURL";
    private static final String ANY_PHONENUMBER = "ANY_PHONENUMBER";
    private static final String ANY_RESUMEURL = "ANY_RESUMEURL";
    private static final String ANY_ADDRESS = "ANY_ADDRESS";
    private static final String ANY_POSTAL_CODE = "ANY_POSTAL_CODE";
    private static final String ANY_CITY = "ANY_CITY";
    private static final String ANY_REGION = "ANY_REGION";
    private static final String ANY_COUNTRY_CODE = "ANY_COUNTRY_CODE";

    @Test
    public void givenContactInfo_thenAdaptToContactInfoView() {
        LocationInfo locationInfo = new LocationInfo(ANY_ADDRESS, ANY_POSTAL_CODE, ANY_CITY, ANY_REGION, ANY_COUNTRY_CODE);
        LocationView locationView = new LocationView(ANY_ADDRESS, ANY_POSTAL_CODE, ANY_CITY, ANY_REGION, ANY_COUNTRY_CODE);
        ContactInfoViewAdapter contactInfoViewAdapter = new ContactInfoViewAdapter();
        ContactInfo contactInfo = new ContactInfo(ANY_EMAIL, ANY_NAME, ANY_SURNAME, ANY_GITURL, ANY_SONARURL, ANY_PHONENUMBER, ANY_RESUMEURL, locationInfo);
        ResumeResponse resumeResponse = new ResumeResponse(contactInfo);
        ContactInfoView expected = new ContactInfoView(ANY_EMAIL, ANY_NAME, ANY_SURNAME, ANY_GITURL, ANY_SONARURL, ANY_PHONENUMBER, ANY_RESUMEURL, locationView);

        ContactInfoView contactInfoViewAdapted = contactInfoViewAdapter.adaptContactInfoViewFromDomain(resumeResponse);

        Assert.assertThat(contactInfoViewAdapted, is(equalTo(expected)));
    }

}