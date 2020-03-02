package org.miralles.resume.service.infrastructure.repository.mongo;

import org.miralles.resume.service.domain.entity.ContactInfo;
import org.miralles.resume.service.domain.entity.Education;
import org.miralles.resume.service.domain.entity.EducationInfo;
import org.miralles.resume.service.domain.entity.ExperienceInfo;
import org.miralles.resume.service.domain.entity.Task;
import org.miralles.resume.service.domain.port.secondary.ResumeRepository;
import org.miralles.resume.service.infrastructure.adapter.ContactInfoAdapter;
import org.miralles.resume.service.infrastructure.adapter.EducationAdapter;
import org.miralles.resume.service.infrastructure.repository.mongo.model.EducationEntity;
import org.miralles.resume.service.infrastructure.repository.mongo.model.ResumeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ResumeMongoRepository implements ResumeRepository {
    private static final String ANY_NAME = "Mauricio";//TODO delete this!!!
    private ContactInfoMongo contactInfoMongo;
    private EducationMongo educationMongo;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ContactInfoAdapter contactInfoAdapter;
    private final EducationAdapter educationAdapter;

    public ResumeMongoRepository(ContactInfoMongo contactInfoMongo,
                                 EducationMongo educationMongo,
                                 ContactInfoAdapter contactInfoAdapter,
                                 EducationAdapter educationAdapter) {
        this.contactInfoMongo = contactInfoMongo;
        this.educationMongo = educationMongo;
        this.contactInfoAdapter = contactInfoAdapter;
        this.educationAdapter = educationAdapter;
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
    public List<ExperienceInfo> getExperienceInfoBy(final String language) {
        return Collections.singletonList(new ExperienceInfo("ANY_TITLE", "ANY_COMPANY", "ANY_URL", "ANY_DESCRIPTION", "ANY_START_DATE", "ANY_END_DATE", Collections.singletonList(new Task("ANY_TASK_DESCRIPTION"))));
    }


}
