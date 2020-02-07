package org.miralles.resume.service.infrastructure.repository.mongo;

import org.miralles.resume.service.domain.entity.ContactInfo;
import org.miralles.resume.service.domain.port.secondary.ResumeRepository;
import org.miralles.resume.service.infrastructure.repository.mongo.model.ResumeEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ResumeMongoRepository implements ResumeRepository {
    private static final String ANY_NAME = "nombre";
    private ResumeMongo resumeMongo;

    public ResumeMongoRepository(ResumeMongo resumeMongo) {
        this.resumeMongo = resumeMongo;
    }

    @Override
    public ContactInfo getContactInfo() {
        ResumeEntity result = resumeMongo.findFirstByContactInfoEntity_Name(ANY_NAME);//TODO H2 integration test

        return new ContactInfo(
                result.getContactInfoEntity().getEmail(),
                result.getContactInfoEntity().getName(),
                result.getContactInfoEntity().getSurname(),
                result.getContactInfoEntity().getGitUrl(),
                result.getContactInfoEntity().getSonarUrl(),
                result.getContactInfoEntity().getPhoneNumber(),
                result.getContactInfoEntity().getResumeOnlineUrl());//TODO extract into an adapter
    }
}
