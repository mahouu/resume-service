package org.miralles.resume.service.infrastructure.rest.model;

import org.junit.Test;

import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;

public class ContactInfoViewTest {
    @Test
    public void testContactInfoViewIsImmutable() {
        assertImmutable(ContactInfoView.class);
    }
}