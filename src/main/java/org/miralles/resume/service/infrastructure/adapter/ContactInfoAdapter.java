package org.miralles.resume.service.infrastructure.adapter;

import org.miralles.resume.service.domain.entity.ContactInfo;
import org.miralles.resume.service.infrastructure.repository.mongo.model.ResumeEntity;

public class ContactInfoAdapter {

    public ContactInfo adaptContactInfoFromRepositoryEntity(final ResumeEntity resumeEntity) {
        return new ContactInfo(
                resumeEntity.getContactInfoEntity().getEmail(),
                resumeEntity.getContactInfoEntity().getName(),
                resumeEntity.getContactInfoEntity().getSurname(),
                resumeEntity.getContactInfoEntity().getGitUrl(),
                resumeEntity.getContactInfoEntity().getSonarUrl(),
                resumeEntity.getContactInfoEntity().getPhoneNumber(),
                resumeEntity.getContactInfoEntity().getResumeOnlineUrl());
    }
}
