package org.miralles.resume.service.infrastructure.repository.mongo;

import org.miralles.resume.service.infrastructure.repository.mongo.model.EducationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;

@Repository
public interface EducationMongo extends MongoRepository<EducationEntity, String> {
    LinkedList<EducationEntity> findAllByLanguageOrderByOrderAsc(String language);
}
