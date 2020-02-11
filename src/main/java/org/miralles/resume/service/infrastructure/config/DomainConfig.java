package org.miralles.resume.service.infrastructure.config;

import org.miralles.resume.service.domain.port.primary.EducationUseCase;
import org.miralles.resume.service.domain.port.primary.ResumeUseCase;
import org.miralles.resume.service.domain.port.secondary.ResumeRepository;
import org.miralles.resume.service.infrastructure.adapter.ContactInfoAdapter;
import org.miralles.resume.service.infrastructure.adapter.EducationAdapter;
import org.miralles.resume.service.infrastructure.rest.adapter.ContactInfoViewAdapter;
import org.miralles.resume.service.infrastructure.rest.adapter.EducationViewAdapter;
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

    @Bean
    public ContactInfoViewAdapter contactInfoViewAdapter(){
        return new ContactInfoViewAdapter();
    }

    @Bean
    public EducationViewAdapter educationViewAdapter(){
        return new EducationViewAdapter();
    }

    @Bean
    public EducationAdapter educationAdapter(){
        return new EducationAdapter();
    }
}
