package org.miralles.resume.service.infrastructure.adapter;

import org.junit.Assert;
import org.junit.Test;
import org.miralles.resume.service.domain.entity.Skill;
import org.miralles.resume.service.domain.entity.SkillKeyword;
import org.miralles.resume.service.infrastructure.repository.mongo.model.SkillEntity;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class SkillAdapterTest {
    private static final String ANY_DESCRIPTION = "ANY_DESCRIPTION";
    private static final String ANY_LEVEL = "ANY_LEVEL";
    private static final String ANY_SKILL = "ANY_SKILL";
    private static final String ANY_LANGUAGE = "ANY_LANGUAGE";

    @Test
    public void givenACorrectSkillEntity_thenRetrieveAnAdaptedSkill() {
        SkillAdapter skillAdapter = new SkillAdapter();
        List<SkillEntity> skillsInfo = singletonList(new SkillEntity(ANY_DESCRIPTION, ANY_LEVEL, singletonList(ANY_SKILL), ANY_LANGUAGE));

        List<Skill> adapted = skillAdapter.adaptSkillEntity(skillsInfo);

        List<Skill> expected = singletonList(new Skill(ANY_DESCRIPTION, ANY_LEVEL, singletonList(new SkillKeyword(ANY_SKILL))));
        Assert.assertThat(adapted, is(equalTo(expected)));
    }

}