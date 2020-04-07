package org.miralles.resume.service.infrastructure.rest;

import org.miralles.resume.service.domain.entity.SkillInfo;
import org.miralles.resume.service.domain.port.primary.SkillUseCase;
import org.miralles.resume.service.infrastructure.rest.adapter.SkillViewAdapter;
import org.miralles.resume.service.infrastructure.rest.model.SkillInfoView;
import org.miralles.resume.service.infrastructure.rest.model.SkillView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SkillController {

    @Autowired
    private SkillUseCase skillUseCase;

    @Autowired
    private SkillViewAdapter skillViewAdapter;

    @GetMapping(value = "/skill/{language}")
    public ResponseEntity<SkillInfoView> getAllExperience(@PathVariable final String language) {

        SkillInfo skillInfo = skillUseCase.execute(language);

        List<SkillView> skillsView = skillViewAdapter.adaptToEducationViews(skillInfo);

        return new ResponseEntity<>(new SkillInfoView(skillsView), HttpStatus.OK);
    }
}
