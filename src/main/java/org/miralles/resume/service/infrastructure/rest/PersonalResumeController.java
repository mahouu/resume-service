package org.miralles.resume.service.infrastructure.rest;

import org.miralles.resume.service.infrastructure.rest.model.ContactInfoView;
import org.miralles.resume.service.infrastructure.rest.model.ResumeView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonalResumeController {
    @GetMapping(value = "/resume")
    public ResponseEntity<ResumeView> getAllEmployees() {
        ContactInfoView contactInfoView = new ContactInfoView("mm@mm.com", "Mauricio", "Miralles",
                "Git url", "sonar url", "+0034666554433", "http://someResumeUrl");
        return new ResponseEntity<>(new ResumeView(contactInfoView), HttpStatus.OK);
    }
}
