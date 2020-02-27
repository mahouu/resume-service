package org.miralles.resume.service.infrastructure.rest.adapter;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.miralles.resume.service.domain.entity.ContactInfo;
import org.miralles.resume.service.domain.entity.ResumeResponse;
import org.miralles.resume.service.infrastructure.rest.model.ContactInfoView;

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

    @Test
    @Ignore
    public void givenContactInfo_thenAdaptToContactInfoView() {
        ContactInfoViewAdapter contactInfoViewAdapter = new ContactInfoViewAdapter();
        ContactInfo contactInfo = new ContactInfo(ANY_EMAIL, ANY_NAME, ANY_SURNAME, ANY_GITURL, ANY_SONARURL, ANY_PHONENUMBER, ANY_RESUMEURL, null);//TODO refactor this test
        ResumeResponse resumeResponse = new ResumeResponse(contactInfo);
        ContactInfoView expected = new ContactInfoView(ANY_EMAIL, ANY_NAME, ANY_SURNAME, ANY_GITURL, ANY_SONARURL, ANY_PHONENUMBER, ANY_RESUMEURL, null); //TODO refactor this

        ContactInfoView contactInfoViewAdapted = contactInfoViewAdapter.adaptContactInfoViewFromDomain(resumeResponse);

        Assert.assertThat(contactInfoViewAdapted, is(equalTo(expected)));
    }

}