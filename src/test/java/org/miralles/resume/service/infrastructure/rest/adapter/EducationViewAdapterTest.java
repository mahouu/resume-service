package org.miralles.resume.service.infrastructure.rest.adapter;

import org.junit.Assert;
import org.junit.Test;
import org.miralles.resume.service.domain.entity.Education;
import org.miralles.resume.service.domain.entity.EducationInfo;
import org.miralles.resume.service.infrastructure.rest.model.EducationView;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class EducationViewAdapterTest {

    private static final String ANY_LANGUAGE = "ANY_LANGUAGE";
    private static final String ANY_DATE = "ANY_DATE";
    private static final String ANY_TITLE = "ANY_TITLE";
    private static final String ANY_SUBTITLE = "ANY_SUBTITLE";
    private static final String ANY_DESCRIPTION = "ANY_DESCRIPTION";

    @Test
    public void givenAnEducationInfo_ThenAdaptToEducationView() {
        EducationViewAdapter adapter = new EducationViewAdapter();
        Education education = new Education(ANY_LANGUAGE, ANY_DATE, ANY_TITLE, ANY_SUBTITLE, ANY_DESCRIPTION);
        List<Education> educations = Collections.singletonList(education);
        EducationInfo educationInfo = new EducationInfo(educations);
        List<EducationView> expected = Collections.singletonList(new EducationView(ANY_LANGUAGE, ANY_DATE, ANY_TITLE, ANY_SUBTITLE, ANY_DESCRIPTION));

        List<EducationView> result = adapter.adaptToEducationViews(educationInfo);

        Assert.assertThat(result, is(equalTo(expected)));
    }

}