package org.miralles.resume.service.infrastructure.repository.mongo;

import org.miralles.resume.service.domain.entity.ContactInfo;
import org.miralles.resume.service.domain.entity.Education;
import org.miralles.resume.service.domain.entity.EducationInfo;
import org.miralles.resume.service.domain.port.secondary.ResumeRepository;
import org.miralles.resume.service.infrastructure.repository.mongo.model.EducationEntity;
import org.miralles.resume.service.infrastructure.repository.mongo.model.ResumeEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ResumeMongoRepository implements ResumeRepository {
    private static final String ANY_NAME = "nombre";//TODO delete this!!!
    private ResumeMongo resumeMongo;//TODO Change the name to contactInfo
    private EducationMongo educationMongo;

    public ResumeMongoRepository(ResumeMongo resumeMongo, EducationMongo educationMongo) {
        this.resumeMongo = resumeMongo;
        this.educationMongo = educationMongo;
    }

    @Override
    public ContactInfo getContactInfo() {
        ResumeEntity result = resumeMongo.findFirstByContactInfoEntity_Name(ANY_NAME);//TODO H2 integration test

        //TODO put a proper logger
        System.out.println("Info retrieved from the mongo repository: " + result);

        return new ContactInfo(
                result.getContactInfoEntity().getEmail(),
                result.getContactInfoEntity().getName(),
                result.getContactInfoEntity().getSurname(),
                result.getContactInfoEntity().getGitUrl(),
                result.getContactInfoEntity().getSonarUrl(),
                result.getContactInfoEntity().getPhoneNumber(),
                result.getContactInfoEntity().getResumeOnlineUrl());//TODO extract into an adapter
    }

    @Override
    public EducationInfo getEducationInfoBy(final String language) {
        List<EducationEntity> educationEntityList = educationMongo.findAllByLanguage(language);
        List<Education> educationInfoList = new ArrayList<>();
        for (EducationEntity educationEntity : educationEntityList) {//TODO extract into an adapter
            educationInfoList.add(new Education(educationEntity.getLanguage(), getFormattedDate(educationEntity), educationEntity.getTitle(), educationEntity.getSubTitle(), educationEntity.getDescription()));
        }
        return new EducationInfo(educationInfoList);
    }

    private String getFormattedDate(EducationEntity educationEntity) {
        return (educationEntity.getEndDate() != null) ? educationEntity.getStartDate() + " - " + educationEntity.getEndDate() : educationEntity.getStartDate();
    }
}
