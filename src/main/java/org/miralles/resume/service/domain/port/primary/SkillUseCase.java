package org.miralles.resume.service.domain.port.primary;

import org.miralles.resume.service.domain.entity.Skill;
import org.miralles.resume.service.domain.entity.SkillInfo;
import org.miralles.resume.service.domain.entity.SkillKeyword;

import java.util.Collections;

public class SkillUseCase {
    public SkillInfo execute(final String language) {

        Skill skill = new Skill("ANY_DESCRIPTION", "ANY_LEVEL", Collections.singletonList(new SkillKeyword("ANY_KEYWORD_DESCRIPTION")));
        return new SkillInfo(Collections.singletonList(skill));
    }
}
