package org.miralles.resume.service.domain.port.primary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.miralles.resume.service.domain.entity.Skill;
import org.miralles.resume.service.domain.entity.SkillInfo;
import org.miralles.resume.service.domain.entity.SkillKeyword;
import org.miralles.resume.service.domain.port.secondary.ResumeRepository;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SkillUseCaseTest {
    @Mock
    private ResumeRepository resumeRepository;
    private static final String ANY_LANGUAGE = "ANY_LANGUAGE";
    private static final String ANY_DESCRIPTION = "ANY_DESCRIPTION";
    private static final String ANY_LEVEL = "ANY_LEVEL";
    private static final String ANY_KEYWORD_DESCRIPTION = "ANY_KEYWORD_DESCRIPTION";

    @Test
    public void givenAValidLanguage_ThenRetrieveMatchedSkills() {
        Skill expectedSkill = new Skill(ANY_DESCRIPTION, ANY_LEVEL, Collections.singletonList(new SkillKeyword(ANY_KEYWORD_DESCRIPTION)));
        SkillInfo expected = new SkillInfo(Collections.singletonList(expectedSkill));
        when(resumeRepository.getSkillInfoBy(ANY_LANGUAGE)).thenReturn(expected);
        SkillUseCase useCase = new SkillUseCase(resumeRepository);

        SkillInfo skill = useCase.execute(ANY_LANGUAGE);

        assertThat(skill, is(equalTo(expected)));
    }

}