package org.miralles.resume.service.infrastructure.rest.adapter;

import org.miralles.resume.service.domain.entity.Skill;
import org.miralles.resume.service.domain.entity.SkillInfo;
import org.miralles.resume.service.domain.entity.SkillKeyword;
import org.miralles.resume.service.infrastructure.rest.model.SkillKeywordView;
import org.miralles.resume.service.infrastructure.rest.model.SkillView;

import java.util.List;
import java.util.stream.Collectors;

public class SkillViewAdapter {

    public List<SkillView> adaptToEducationViews(final SkillInfo skillInfo) {
        return skillInfo.getSkillList().stream()
                .map(SkillViewAdapter::adaptSkill)
                .collect(Collectors.toList());
    }

    private static SkillView adaptSkill(final Skill skill) {
        return new SkillView(skill.getDescription(), skill.getLevel(), skill.getKeywords().stream()
                .map(SkillViewAdapter::adaptSkillView)
                .collect(Collectors.toList()));
    }

    private static SkillKeywordView adaptSkillView(final SkillKeyword keyword) {
        return new SkillKeywordView(keyword.getSkillKeywordDescription());
    }
}
