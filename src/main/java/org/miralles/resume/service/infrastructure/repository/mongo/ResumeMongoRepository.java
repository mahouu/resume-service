package org.miralles.resume.service.infrastructure.repository.mongo;

import org.miralles.resume.service.domain.entity.ContactInfo;
import org.miralles.resume.service.domain.entity.Education;
import org.miralles.resume.service.domain.entity.EducationInfo;
import org.miralles.resume.service.domain.port.secondary.ResumeRepository;
import org.miralles.resume.service.infrastructure.adapter.ContactInfoAdapter;
import org.miralles.resume.service.infrastructure.repository.mongo.model.EducationEntity;
import org.miralles.resume.service.infrastructure.repository.mongo.model.ResumeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ResumeMongoRepository implements ResumeRepository {
    private static final String ANY_NAME = "ANY_NAME";//TODO delete this!!!
    private ContactInfoMongo contactInfoMongo;
    private EducationMongo educationMongo;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final ContactInfoAdapter contactInfoAdapter;

    public ResumeMongoRepository(ContactInfoMongo contactInfoMongo,
                                 EducationMongo educationMongo,
                                 ContactInfoAdapter contactInfoAdapter) {
        this.contactInfoMongo = contactInfoMongo;
        this.educationMongo = educationMongo;
        this.contactInfoAdapter = contactInfoAdapter;
    }

    @Override
    public ContactInfo getContactInfo() {
        ResumeEntity result = contactInfoMongo.findFirstByContactInfoEntity_Name(ANY_NAME);//TODO H2 integration test

        LOGGER.info("Info retrieved from the mongo repository for contact info: " + result);

        return contactInfoAdapter.adaptContactInfoFromRepositoryEntity(result);
    }



    @Override
    public EducationInfo getEducationInfoBy(final String language) {
        List<EducationEntity> educationEntityList = educationMongo.findAllByLanguage(language);
        List<Education> educationInfoList = new ArrayList<>();
        for (EducationEntity educationEntity : educationEntityList) {//TODO extract into an adapter
            educationInfoList.add(new Education(educationEntity.getLanguage(), getFormattedDate(educationEntity), educationEntity.getTitle(), educationEntity.getSubTitle(), educationEntity.getDescription()));
        }

        LOGGER.info("Info retrieved from the mongo repository for education: " + educationEntityList);

        return new EducationInfo(educationInfoList);
    }

    private String getFormattedDate(EducationEntity educationEntity) {
        return (educationEntity.getEndDate() != null) ? educationEntity.getStartDate() + " - " + educationEntity.getEndDate() : educationEntity.getStartDate();
    }
}
