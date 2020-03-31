package org.miralles.resume.service.infrastructure.rest.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;

public class SkillInfoViewTest {
    @Test
    public void testResumeViewIsImmutable() {
        assertImmutable(SkillInfoView.class);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(SkillInfoView.class)
                .suppress(Warning.INHERITED_DIRECTLY_FROM_OBJECT)
                .suppress(Warning.NULL_FIELDS)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

}