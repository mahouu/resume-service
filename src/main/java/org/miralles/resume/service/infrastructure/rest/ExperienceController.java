package org.miralles.resume.service.infrastructure.rest;

import org.miralles.resume.service.domain.entity.ExperienceInfo;
import org.miralles.resume.service.domain.port.primary.ExperienceUseCase;
import org.miralles.resume.service.infrastructure.rest.adapter.ExperienceAdapter;
import org.miralles.resume.service.infrastructure.rest.model.ExperienceInfoView;
import org.miralles.resume.service.infrastructure.rest.model.ExperienceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExperienceController {

    @Autowired
    private ExperienceUseCase experienceUseCase;

    @Autowired
    private ExperienceAdapter experienceViewAdapter;

    @CrossOrigin(origins = "http://192.168.1.148:3000")//TODO extract to configuration
    @GetMapping(value = "/experience/{language}")
    public ResponseEntity<ExperienceInfoView> getAllExperience(@PathVariable final String language) {

        ExperienceInfo experienceInfo = experienceUseCase.execute(language);

        List<ExperienceView> educationsView = experienceViewAdapter.adaptToEducationViews(experienceInfo);

        return new ResponseEntity<>(new ExperienceInfoView(educationsView), HttpStatus.OK);
    }
}
