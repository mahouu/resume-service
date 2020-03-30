package org.miralles.resume.service.domain.port.primary;

import org.miralles.resume.service.domain.entity.ExperienceInfo;
import org.miralles.resume.service.domain.port.secondary.ResumeRepository;

public class ExperienceUseCase {
    private ResumeRepository resumeRepository;

    public ExperienceUseCase(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public ExperienceInfo execute(final String language) {
        return resumeRepository.getExperienceInfoBy(language);
    }
}
