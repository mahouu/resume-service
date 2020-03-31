package org.miralles.resume.service.infrastructure.rest.adapter;

import org.junit.Assert;
import org.junit.Test;
import org.miralles.resume.service.domain.entity.Skill;
import org.miralles.resume.service.domain.entity.SkillInfo;
import org.miralles.resume.service.domain.entity.SkillKeyword;
import org.miralles.resume.service.infrastructure.rest.model.SkillKeywordView;
import org.miralles.resume.service.infrastructure.rest.model.SkillView;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class SkillViewAdapterTest {

    public static final String ANY_DESCRIPTION = "ANY_DESCRIPTION";
    public static final String ANY_LEVEL = "ANY_LEVEL";
    public static final String ANY_SKILL = "ANY_SKILL";

    @Test
    public void givenASkillInfo_thenAdaptToSkillView() {
        SkillViewAdapter skillViewAdapter = new SkillViewAdapter();
        Skill skill = new Skill(ANY_DESCRIPTION, ANY_LEVEL, singletonList(new SkillKeyword(ANY_SKILL)));
        SkillInfo skillInfo = new SkillInfo(singletonList(skill));
        List<SkillView> expected = singletonList(new SkillView(ANY_DESCRIPTION, ANY_LEVEL, singletonList(new SkillKeywordView(ANY_SKILL))));

        List<SkillView> skillViewAdapted = skillViewAdapter.adaptToEducationViews(skillInfo);

        Assert.assertThat(skillViewAdapted, is(equalTo(expected)));
    }

}