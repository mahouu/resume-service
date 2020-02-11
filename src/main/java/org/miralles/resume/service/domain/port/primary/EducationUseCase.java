package org.miralles.resume.service.domain.port.primary;

import org.miralles.resume.service.domain.entity.EducationInfo;
import org.miralles.resume.service.domain.port.secondary.ResumeRepository;

public class EducationUseCase {

    private ResumeRepository resumeRepository;

    public EducationUseCase(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public EducationInfo execute(final String language) {
        return resumeRepository.getEducationInfoBy(language);
    }
}
