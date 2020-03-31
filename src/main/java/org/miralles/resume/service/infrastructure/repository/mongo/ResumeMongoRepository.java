package org.miralles.resume.service.infrastructure.repository.mongo;

import org.miralles.resume.service.domain.entity.ContactInfo;
import org.miralles.resume.service.domain.entity.Education;
import org.miralles.resume.service.domain.entity.EducationInfo;
import org.miralles.resume.service.domain.entity.Experience;
import org.miralles.resume.service.domain.entity.ExperienceInfo;
import org.miralles.resume.service.domain.entity.Skill;
import org.miralles.resume.service.domain.entity.SkillInfo;
import org.miralles.resume.service.domain.entity.SkillKeyword;
import org.miralles.resume.service.domain.port.secondary.ResumeRepository;
import org.miralles.resume.service.infrastructure.adapter.ContactInfoAdapter;
import org.miralles.resume.service.infrastructure.adapter.EducationAdapter;
import org.miralles.resume.service.infrastructure.adapter.ExperienceAdapter;
import org.miralles.resume.service.infrastructure.repository.mongo.model.EducationEntity;
import org.miralles.resume.service.infrastructure.repository.mongo.model.ExperienceEntity;
import org.miralles.resume.service.infrastructure.repository.mongo.model.ResumeEntity;
import org.miralles.resume.service.infrastructure.repository.mongo.model.SkillEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ResumeMongoRepository implements ResumeRepository {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String ANY_NAME = "Mauricio";//TODO delete this!!!
    private final ContactInfoAdapter contactInfoAdapter;
    private final EducationAdapter educationAdapter;
    private ContactInfoMongo contactInfoMongo;
    private EducationMongo educationMongo;
    private ExperienceMongo experienceMongo;
    private SkillMongo skillMongo;

    public ResumeMongoRepository(final ContactInfoMongo contactInfoMongo,
                                 final EducationMongo educationMongo,
                                 final ContactInfoAdapter contactInfoAdapter,
                                 final EducationAdapter educationAdapter,
                                 final ExperienceMongo experienceMongo,
                                 final SkillMongo skillMongo) {
        this.contactInfoMongo = contactInfoMongo;
        this.educationMongo = educationMongo;
        this.contactInfoAdapter = contactInfoAdapter;
        this.educationAdapter = educationAdapter;
        this.experienceMongo = experienceMongo;
        this.skillMongo = skillMongo;
    }

    @Override
    public ContactInfo getContactInfo() {
        ResumeEntity result = contactInfoMongo.findFirstByContactInfoEntity_Name(ANY_NAME);//TODO H2 integration test

        logger.debug("Info retrieved from the mongo repository for contact info: {}", result);

        return contactInfoAdapter.adaptContactInfoFromRepositoryEntity(result);
    }


    @Override
    public EducationInfo getEducationInfoBy(final String language) {
        List<EducationEntity> educationEntityList = educationMongo.findAllByLanguage(language);
        List<Education> educationInfoList = educationAdapter.adaptEducation(educationEntityList);

        logger.info("Info retrieved from the mongo repository for education: {}", educationEntityList);

        return new EducationInfo(educationInfoList);
    }

    @Override
    public ExperienceInfo getExperienceInfoBy(final String language) {
        List<ExperienceEntity> experiences = experienceMongo.findAllByLanguage(language);

        experiences.forEach(entity -> logger.info("Info retrieved from the mongo repository for experience: {}", entity));

        return new ExperienceInfo(adaptExperience(experiences));
    }

    @Override
    public SkillInfo getSkillInfoBy(final String language) {
        List<SkillEntity> skillsInfo = skillMongo.findAllByLanguage(language);

        return new SkillInfo(adaptSkillEntity(skillsInfo));
    }

    private List<Skill> adaptSkillEntity(List<SkillEntity> skillsInfo) {
        return skillsInfo.stream()
                .map(this::apply)
                .collect(Collectors.toList());
    }

    private List<SkillKeyword> adaptKeywords(SkillEntity skillEntity) {
        return skillEntity.getKeywords()
                .stream()
                .map(SkillKeyword::new)
                .collect(Collectors.toList());
    }

    private List<Experience> adaptExperience(final List<ExperienceEntity> experiences) {//TODO extract to an adapter
        return experiences.stream()
                .map(ExperienceAdapter::adapt)
                .collect(Collectors.toList());
    }

    private Skill apply(SkillEntity skillEntity) {
        return new Skill(skillEntity.getDescription(), skillEntity.getLevel(), adaptKeywords(skillEntity));
    }
}
