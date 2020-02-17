package org.miralles.resume.service.domain.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class EducationInfo {
    private final List<Education> educationInfoList;

    public EducationInfo(List<Education> education) {
        this.educationInfoList = Collections.unmodifiableList(new ArrayList<>(education));
    }

    public List<Education> getEducationInfoList() {
        return educationInfoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EducationInfo)) return false;
        EducationInfo that = (EducationInfo) o;
        return Objects.equals(getEducationInfoList(), that.getEducationInfoList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEducationInfoList());
    }

    @Override
    public String toString() {
        return "EducationInfo{" +
                "educationInfo=" + educationInfoList +
                '}';
    }
}
