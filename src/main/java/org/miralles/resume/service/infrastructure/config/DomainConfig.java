package org.miralles.resume.service.infrastructure.config;

import org.miralles.resume.service.domain.port.primary.EducationUseCase;
import org.miralles.resume.service.domain.port.primary.ResumeUseCase;
import org.miralles.resume.service.domain.port.secondary.ResumeRepository;
import org.miralles.resume.service.infrastructure.adapter.ContactInfoAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {
    @Bean
    public ResumeUseCase resumeUseCase(final ResumeRepository resumeRepository){
        return new ResumeUseCase(resumeRepository);
    }

    @Bean
    public EducationUseCase educationUseCase(final ResumeRepository resumeRepository){
        return new EducationUseCase(resumeRepository);
    }

    @Bean
    public ContactInfoAdapter contactInfoAdapter(){
        return new ContactInfoAdapter();
    }
}
