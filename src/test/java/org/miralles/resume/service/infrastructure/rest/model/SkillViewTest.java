package org.miralles.resume.service.infrastructure.rest.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;

public class SkillViewTest {
    @Test
    public void testResumeViewIsImmutable() {
        assertImmutable(SkillView.class);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(SkillView.class)
                .suppress(Warning.INHERITED_DIRECTLY_FROM_OBJECT)
                .suppress(Warning.NULL_FIELDS)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

}