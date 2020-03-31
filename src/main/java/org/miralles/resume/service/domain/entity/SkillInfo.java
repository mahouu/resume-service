package org.miralles.resume.service.domain.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class SkillInfo {
    private final List<Skill> skillList;

    public SkillInfo(final List<Skill> skillList) {
        this.skillList = Collections.unmodifiableList(new ArrayList<>(skillList));
    }

    public final List<Skill> getSkillList() {
        return skillList;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkillInfo)) return false;
        SkillInfo skillInfo = (SkillInfo) o;
        return Objects.equals(getSkillList(), skillInfo.getSkillList());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getSkillList());
    }
}
