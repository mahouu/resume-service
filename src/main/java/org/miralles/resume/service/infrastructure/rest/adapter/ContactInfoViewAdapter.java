package org.miralles.resume.service.infrastructure.rest.adapter;

import org.miralles.resume.service.domain.entity.ResumeResponse;
import org.miralles.resume.service.infrastructure.rest.model.ContactInfoView;
import org.miralles.resume.service.infrastructure.rest.model.LocationView;

public class ContactInfoViewAdapter {
    public ContactInfoView adaptContactInfoViewFromDomain(ResumeResponse resumeResponse) {
        LocationView locationView = new LocationView(resumeResponse.getContactInfo().getLocationInfo().getAddress(),
                resumeResponse.getContactInfo().getLocationInfo().getPostalCode(),
                resumeResponse.getContactInfo().getLocationInfo().getCity(),
                resumeResponse.getContactInfo().getLocationInfo().getRegion(),
                resumeResponse.getContactInfo().getLocationInfo().getCountryCode());//Extract to an adapter and erase Demeter law
        return new ContactInfoView(
                resumeResponse.getContactInfo().getEmail(),
                resumeResponse.getContactInfo().getName(),
                resumeResponse.getContactInfo().getSurname(),
                resumeResponse.getContactInfo().getGitUrl(),
                resumeResponse.getContactInfo().getSonarUrl(),
                resumeResponse.getContactInfo().getPhoneNumber(),
                resumeResponse.getContactInfo().getResumeOnlineUrl(),
                locationView);
    }
}
