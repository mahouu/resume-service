package org.miralles.resume.service.infrastructure.repository.mongo;

import org.miralles.resume.service.infrastructure.repository.mongo.model.ExperienceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceMongo extends MongoRepository<ExperienceEntity, String> {
    List<ExperienceEntity> findAllByLanguage(String language);
}
