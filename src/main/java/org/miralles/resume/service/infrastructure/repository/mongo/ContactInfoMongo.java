package org.miralles.resume.service.infrastructure.repository.mongo;

import org.miralles.resume.service.infrastructure.repository.mongo.model.ResumeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInfoMongo extends MongoRepository<ResumeEntity, String> {
    ResumeEntity findFirstByContactInfoEntity_Name(String name);
}
