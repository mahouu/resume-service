package org.miralles.resume.service.infrastructure.repository.mongo;

import org.miralles.resume.service.infrastructure.repository.mongo.model.SkillEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillMongo extends MongoRepository<SkillEntity, String> {
    List<SkillEntity> findAllByLanguage(String language);
}
