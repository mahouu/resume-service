package org.miralles.resume.service.domain.port.primary;

import org.junit.Test;
import org.miralles.resume.service.domain.entity.Skill;
import org.miralles.resume.service.domain.entity.SkillInfo;
import org.miralles.resume.service.domain.entity.SkillKeyword;

import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


public class SkillUseCaseTest {
    private static final String ANY_LANGUAGE = "ANY_LANGUAGE";
    private static final String ANY_DESCRIPTION = "ANY_DESCRIPTION";
    private static final String ANY_LEVEL = "ANY_LEVEL";
    private static final String ANY_KEYWORD_DESCRIPTION = "ANY_KEYWORD_DESCRIPTION";

    @Test
    public void givenAValidLanguage_ThenRetrieveMatchedSkills() {
        SkillUseCase useCase = new SkillUseCase();
        Skill expectedSkill = new Skill(ANY_DESCRIPTION, ANY_LEVEL, Collections.singletonList(new SkillKeyword(ANY_KEYWORD_DESCRIPTION)));
        SkillInfo expected = new SkillInfo(Collections.singletonList(expectedSkill));

        SkillInfo skill = useCase.execute(ANY_LANGUAGE);

        assertThat(skill, is(equalTo(expected)));
    }

}