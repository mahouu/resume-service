package org.miralles.resume.service.domain.entity;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;

public class SkillTest {
    @Test
    public void contactInfoIsImmutable() {
        assertImmutable(Skill.class);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Skill.class)
                .suppress(Warning.INHERITED_DIRECTLY_FROM_OBJECT)
                .suppress(Warning.NULL_FIELDS)
                .verify();
    }
}