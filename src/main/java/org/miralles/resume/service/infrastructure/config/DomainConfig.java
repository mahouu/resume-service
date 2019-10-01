package org.miralles.resume.service.infrastructure.config;

import org.miralles.resume.service.domain.port.primary.ResumeUseCase;
import org.miralles.resume.service.domain.port.secondary.ResumeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {
    @Bean
    public ResumeUseCase resumeUseCase(final ResumeRepository resumeRepository){
        return new ResumeUseCase(resumeRepository);
    }
}
