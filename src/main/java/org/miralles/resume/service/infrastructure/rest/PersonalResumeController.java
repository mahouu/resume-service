package org.miralles.resume.service.infrastructure.rest;

import org.miralles.resume.service.domain.entity.ResumeResponse;
import org.miralles.resume.service.domain.port.primary.ResumeUseCase;
import org.miralles.resume.service.infrastructure.rest.model.ContactInfoView;
import org.miralles.resume.service.infrastructure.rest.model.ResumeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonalResumeController {

    @Autowired
    private ResumeUseCase resumeUseCase;

    @CrossOrigin(origins = "http://localhost:3000")//TODO extract to configuration
    @GetMapping(value = "/resume")
    public ResponseEntity<ResumeView> getAllEmployees() {

        ResumeResponse resumeResponse = resumeUseCase.getPersonalInfo();

        ContactInfoView contactInfoView = new ContactInfoView(
                resumeResponse.getContactInfo().getEmail(),
                resumeResponse.getContactInfo().getName(),
                resumeResponse.getContactInfo().getSurname(),
                resumeResponse.getContactInfo().getGitUrl(),
                resumeResponse.getContactInfo().getSonarUrl(),
                resumeResponse.getContactInfo().getPhoneNumber(),
                resumeResponse.getContactInfo().getResumeOnlineUrl());
        //TODO create an adapter
        return new ResponseEntity<>(new ResumeView(contactInfoView), HttpStatus.OK);
    }
}
