package org.miralles.resume.service.infrastructure.adapter;

import org.miralles.resume.service.domain.entity.Skill;
import org.miralles.resume.service.domain.entity.SkillKeyword;
import org.miralles.resume.service.infrastructure.repository.mongo.model.SkillEntity;

import java.util.List;
import java.util.stream.Collectors;

public class SkillAdapter {
    public List<Skill> adaptSkillEntity(List<SkillEntity> skillsInfo) {
        return skillsInfo.stream()
                .map(this::apply)
                .collect(Collectors.toList());
    }

    private List<SkillKeyword> adaptKeywords(SkillEntity skillEntity) {
        return skillEntity.getKeywords()
                .stream()
                .map(SkillKeyword::new)
                .collect(Collectors.toList());
    }

    private Skill apply(SkillEntity skillEntity) {
        return new Skill(skillEntity.getDescription(), skillEntity.getLevel(), adaptKeywords(skillEntity));
    }
}
