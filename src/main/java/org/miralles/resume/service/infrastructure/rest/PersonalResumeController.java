package org.miralles.resume.service.infrastructure.rest;

import org.miralles.resume.service.infrastructure.rest.model.ResumeView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonalResumeController {
    @GetMapping(value = "/resume")
    public ResponseEntity<ResumeView> getAllEmployees() {
        return new ResponseEntity<>(new ResumeView("This is a test"), HttpStatus.OK);
    }
}
