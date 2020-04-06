package org.miralles.resume.service.infrastructure.repository.mongo;

import org.miralles.resume.service.domain.entity.ContactInfo;
import org.miralles.resume.service.domain.entity.Education;
import org.miralles.resume.service.domain.entity.EducationInfo;
import org.miralles.resume.service.domain.entity.Experience;
import org.miralles.resume.service.domain.entity.ExperienceInfo;
import org.miralles.resume.service.domain.entity.SkillInfo;
import org.miralles.resume.service.domain.port.secondary.ResumeRepository;
import org.miralles.resume.service.infrastructure.adapter.ContactInfoAdapter;
import org.miralles.resume.service.infrastructure.adapter.EducationAdapter;
import org.miralles.resume.service.infrastructure.adapter.ExperienceAdapter;
import org.miralles.resume.service.infrastructure.adapter.SkillAdapter;
import org.miralles.resume.service.infrastructure.repository.mongo.model.EducationEntity;
import org.miralles.resume.service.infrastructure.repository.mongo.model.ExperienceEntity;
import org.miralles.resume.service.infrastructure.repository.mongo.model.ResumeEntity;
import org.miralles.resume.service.infrastructure.repository.mongo.model.SkillEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.toCollection;

@Repository
public class ResumeMongoRepository implements ResumeRepository {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String ANY_NAME = "Mauricio";//TODO delete this!!!
    private final ContactInfoAdapter contactInfoAdapter;
    private final EducationAdapter educationAdapter;
    private final SkillAdapter skillAdapter;
    private ContactInfoMongo contactInfoMongo;
    private EducationMongo educationMongo;
    private ExperienceMongo experienceMongo;
    private SkillMongo skillMongo;

    public ResumeMongoRepository(final ContactInfoMongo contactInfoMongo,
                                 final EducationMongo educationMongo,
                                 final ContactInfoAdapter contactInfoAdapter,
                                 final EducationAdapter educationAdapter,
                                 final ExperienceMongo experienceMongo,
                                 final SkillMongo skillMongo,
                                 final SkillAdapter skillAdapter) {
        this.contactInfoMongo = contactInfoMongo;
        this.educationMongo = educationMongo;
        this.contactInfoAdapter = contactInfoAdapter;
        this.educationAdapter = educationAdapter;
        this.experienceMongo = experienceMongo;
        this.skillMongo = skillMongo;
        this.skillAdapter = skillAdapter;
    }

    @Override
    public ContactInfo getContactInfo() {
        ResumeEntity result = contactInfoMongo.findFirstByContactInfoEntity_Name(ANY_NAME);//TODO H2 integration test

        logger.debug("Info retrieved from the mongo repository for contact info: {}", result);

        return contactInfoAdapter.adaptContactInfoFromRepositoryEntity(result);
    }


    @Override
    public EducationInfo getEducationInfoBy(final String language) {
        LinkedList<EducationEntity> educationEntityList = educationMongo.findAllByLanguageOrderByOrderAsc(language);
        List<Education> educationInfoList = educationAdapter.adaptEducation(educationEntityList);

        logger.info("Info retrieved from the mongo repository for education: {}", educationEntityList);

        return new EducationInfo(educationInfoList);
    }

    @Override
    public ExperienceInfo getExperienceInfoBy(final String language) {
        LinkedList<ExperienceEntity> experiences = experienceMongo.findAllByLanguageOrderByOrderAsc(language);

        experiences.forEach(entity -> logger.info("Info retrieved from the mongo repository for experience: {}", entity));

        return new ExperienceInfo(adaptExperience(experiences));
    }

    @Override
    public SkillInfo getSkillInfoBy(final String language) {
        List<SkillEntity> skillsInfo = skillMongo.findAllByLanguage(language);

        return new SkillInfo(skillAdapter.adaptSkillEntity(skillsInfo));
    }


    private LinkedList<Experience> adaptExperience(final LinkedList<ExperienceEntity> experiences) {
        return experiences.stream()
                .map(ExperienceAdapter::adapt)
                .collect(toCollection(LinkedList::new));
    }
}
