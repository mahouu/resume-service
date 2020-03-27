package org.miralles.resume.service.infrastructure.rest.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;

public class ExperienceViewTest {
    @Test
    public void testContactInfoViewIsImmutable() {
        assertImmutable(ExperienceView.class);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(ExperienceView.class)
                .suppress(Warning.INHERITED_DIRECTLY_FROM_OBJECT)
                .verify();
    }
}