package org.miralles.resume.service.infrastructure.repository.mongo;

import org.miralles.resume.service.infrastructure.repository.mongo.model.EducationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationMongo extends MongoRepository<EducationEntity, String> {
    List<EducationEntity> findAllByLanguage(String language);
}
