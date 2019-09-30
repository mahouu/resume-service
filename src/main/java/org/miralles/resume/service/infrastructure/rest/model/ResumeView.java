package org.miralles.resume.service.infrastructure.rest.model;

public final class ResumeView {
    private final String bodyContent;

    public ResumeView(String bodyContent) {
        this.bodyContent = bodyContent;
    }

    public String getBodyContent() {
        return bodyContent;
    }
}
