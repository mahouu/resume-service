package org.miralles.resume.service.infrastructure.adapter;

import org.junit.Assert;
import org.junit.Test;
import org.miralles.resume.service.domain.entity.Education;
import org.miralles.resume.service.infrastructure.repository.mongo.model.EducationEntity;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class EducationAdapterTest {

    private static final String ANY_LANGUAGE = "ANY_LANGUAGE";
    private static final String ANY_START_DATE = "ANY_START_DATE";
    private static final String ANY_END_DATE = "ANY_END_DATE";
    private static final String ANY_TITLE = "ANY_TITLE";
    private static final String ANY_SUBTITLE = "ANY_SUBTITLE";
    private static final String ANY_DESCRIPTION = "ANY_DESCRIPTION";
    private static final String SEPARATOR = " - ";
    private static final String ANY_COMPLETE_DATE = ANY_START_DATE + SEPARATOR + ANY_END_DATE;
    private static final String NO_END_DATE = null;
    private final EducationAdapter educationAdapter = new EducationAdapter();

    @Test
    public void givenAnEducationEntity_thenConvertAnEducationWithFullDateFormatted() {
        Education education = new Education(ANY_LANGUAGE, ANY_COMPLETE_DATE, ANY_TITLE, ANY_SUBTITLE, ANY_DESCRIPTION);
        List<Education> expected = Collections.singletonList(education);
        EducationEntity educationEntity = new EducationEntity(ANY_LANGUAGE, ANY_START_DATE, ANY_END_DATE, ANY_TITLE, ANY_SUBTITLE, ANY_DESCRIPTION);

        List<Education> educations = educationAdapter.adaptEducation(Collections.singletonList(educationEntity));

        Assert.assertThat(expected, is(equalTo(educations)));
    }

    @Test
    public void givenAnEducationEntityWithOutEndDate_thenConvertAnEducation() {
        Education education = new Education(ANY_LANGUAGE, ANY_START_DATE, ANY_TITLE, ANY_SUBTITLE, ANY_DESCRIPTION);
        List<Education> expected = Collections.singletonList(education);
        EducationEntity educationEntity = new EducationEntity(ANY_LANGUAGE, ANY_START_DATE, NO_END_DATE, ANY_TITLE, ANY_SUBTITLE, ANY_DESCRIPTION);

        List<Education> educations = educationAdapter.adaptEducation(Collections.singletonList(educationEntity));

        Assert.assertThat(expected, is(equalTo(educations)));
    }
}