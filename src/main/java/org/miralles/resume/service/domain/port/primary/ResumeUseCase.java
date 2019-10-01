package org.miralles.resume.service.domain.port.primary;

import org.miralles.resume.service.domain.entity.ResumeResponse;
import org.miralles.resume.service.domain.port.secondary.ResumeRepository;

public class ResumeUseCase {

    private final ResumeRepository resumeRepository;

    public ResumeUseCase(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public ResumeResponse getPersonalInfo() {
        return new ResumeResponse(resumeRepository.getContactInfo());
    }
}
