package org.miralles.resume.service.infrastructure.rest.adapter;

import org.miralles.resume.service.domain.entity.Education;
import org.miralles.resume.service.domain.entity.EducationInfo;
import org.miralles.resume.service.infrastructure.rest.model.EducationView;

import java.util.ArrayList;
import java.util.List;

public class EducationViewAdapter {
    public List<EducationView> adaptToEducationViews(EducationInfo educationInfo) {
        List<EducationView> educationsView = new ArrayList<>();
        for (Education education : educationInfo.getEducationInfoList()) {
            educationsView.add(new EducationView(education.getLanguage(), education.getDate(), education.getTitle(), education.getSubTitle(), education.getDescription()));
        }
        return educationsView;
    }
}
