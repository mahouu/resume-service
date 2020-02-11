package org.miralles.resume.service.infrastructure.repository.mongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "contactinfo")
public class ResumeEntity {
    private ContactInfoEntity contactInfoEntity;

    public ResumeEntity(ContactInfoEntity contactInfoEntity) {
        this.contactInfoEntity = contactInfoEntity;
    }

    public ContactInfoEntity getContactInfoEntity() {
        return contactInfoEntity;
    }

    public void setContactInfoEntity(ContactInfoEntity contactInfoEntity) {
        this.contactInfoEntity = contactInfoEntity;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResumeEntity)) return false;
        ResumeEntity that = (ResumeEntity) o;
        return Objects.equals(getContactInfoEntity(), that.getContactInfoEntity());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(contactInfoEntity);
    }

    @Override
    public String toString() {
        return "ResumeEntity{" +
                "contactInfoEntity=" + contactInfoEntity +
                '}';
    }
}
