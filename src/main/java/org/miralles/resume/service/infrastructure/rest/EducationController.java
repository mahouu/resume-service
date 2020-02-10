package org.miralles.resume.service.infrastructure.rest;

import org.miralles.resume.service.domain.entity.Education;
import org.miralles.resume.service.domain.entity.EducationInfo;
import org.miralles.resume.service.domain.port.primary.EducationUseCase;
import org.miralles.resume.service.infrastructure.rest.model.EducationInfoView;
import org.miralles.resume.service.infrastructure.rest.model.EducationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EducationController {

    @Autowired
    private EducationUseCase educationUseCase;

    @CrossOrigin(origins = "http://localhost:3000")//TODO extract to configuration
    @GetMapping(value = "/education/{language}")
    public ResponseEntity<EducationInfoView> getAllEmployees(@PathVariable final String language) {

        EducationInfo educationInfo = educationUseCase.execute(language);

        List<EducationView> educationsView = new ArrayList<>();
        //TODO extract to an adapter
        List<Education> listOfEducationInfo = educationInfo.getEducationInfo();
        for (Education education : listOfEducationInfo) {
            educationsView.add(new EducationView(education.getLanguage(), education.getDate(), education.getTitle(), education.getSubTitle(), education.getDescription()));
        }

        return new ResponseEntity<>(new EducationInfoView(educationsView), HttpStatus.OK);
    }
}
