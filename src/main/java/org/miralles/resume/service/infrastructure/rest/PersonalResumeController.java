package org.miralles.resume.service.infrastructure.rest;

import org.miralles.resume.service.infrastructure.rest.model.ResumeView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonalResumeController {
    @RequestMapping(value = "/resume", method = RequestMethod.GET)
    public ResponseEntity<ResumeView> getAllEmployees() {
        return new ResponseEntity<>(new ResumeView("This is a test"), HttpStatus.OK);
    }
}
