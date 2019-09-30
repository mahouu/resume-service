package org.miralles.resume.service.infrastructure.rest.model;

import org.junit.Test;

import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;

public class ResumeViewTest {
    @Test
    public void testResumeViewIsImmutable() {
        assertImmutable(ResumeView.class);
    }
}