package org.miralles.resume.service.domain.port.primary;

import org.miralles.resume.service.domain.entity.SkillInfo;
import org.miralles.resume.service.domain.port.secondary.ResumeRepository;

public class SkillUseCase {

    private ResumeRepository resumeRepository;

    public SkillUseCase(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public SkillInfo execute(final String language) {
        return resumeRepository.getSkillInfoBy(language);
    }
}
