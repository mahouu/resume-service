package org.miralles.resume.service.infrastructure.rest.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;

public class ContactInfoViewTest {
    @Test
    public void testContactInfoViewIsImmutable() {
        assertImmutable(ContactInfoView.class);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(ContactInfoView.class)
                .suppress(Warning.INHERITED_DIRECTLY_FROM_OBJECT)
                .verify();
    }
}