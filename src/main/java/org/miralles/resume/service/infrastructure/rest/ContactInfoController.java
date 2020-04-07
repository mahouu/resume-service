package org.miralles.resume.service.infrastructure.rest;

import org.miralles.resume.service.domain.entity.ResumeResponse;
import org.miralles.resume.service.domain.port.primary.ResumeUseCase;
import org.miralles.resume.service.infrastructure.rest.adapter.ContactInfoViewAdapter;
import org.miralles.resume.service.infrastructure.rest.model.ContactInfoView;
import org.miralles.resume.service.infrastructure.rest.model.ResumeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactInfoController {

    @Autowired
    private ResumeUseCase resumeUseCase;

    @Autowired
    private ContactInfoViewAdapter contactInfoViewAdapter;

    @GetMapping(value = "/contactInfo")
    public ResponseEntity<ResumeView> getAllContactInfo() {

        ResumeResponse resumeResponse = resumeUseCase.getPersonalInfo();

        ContactInfoView contactInfoView = contactInfoViewAdapter.adaptContactInfoViewFromDomain(resumeResponse);
        return new ResponseEntity<>(new ResumeView(contactInfoView), HttpStatus.OK);
    }
}
