package org.miralles.resume.service.infrastructure.repository.mongo.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

public class SkillEntityTest {
    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(SkillEntity.class)
                .suppress(Warning.INHERITED_DIRECTLY_FROM_OBJECT)
                .suppress(Warning.NULL_FIELDS)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }
}