package org.miralles.resume.service.domain.port.primary;

import org.miralles.resume.service.domain.entity.Experience;
import org.miralles.resume.service.domain.entity.ExperienceInfo;
import org.miralles.resume.service.domain.port.secondary.ResumeRepository;

import java.util.ArrayList;
import java.util.List;

public class ExperienceUseCase {
    private ResumeRepository resumeRepository;

    public ExperienceUseCase(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public ExperienceInfo execute(final String language) {
        return resumeRepository.getExperienceInfoBy(language);
        //return adaptExperienceFrom(allExperienceListFromRepo);
    }

    private ExperienceInfo adaptExperienceFrom(final List<Experience> allExperienceListFromRepo) {
        List<Experience> experienceInfoList = new ArrayList<>();
        for (Experience experienceFromRepo : allExperienceListFromRepo) {
            Experience experienceAdapted = new Experience(
                    experienceFromRepo.getTitle(),
                    experienceFromRepo.getCompany(),
                    experienceFromRepo.getUrl(),
                    experienceFromRepo.getRoleDescription(),
                    experienceFromRepo.getStartDate(),
                    experienceFromRepo.getEndDate(),
                    experienceFromRepo.getTasks());
            experienceInfoList.add(experienceAdapted);
        }
        return new ExperienceInfo(experienceInfoList);
    }
}
