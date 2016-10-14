package com.tchepannou.kiosk.content;

import com.tchepannou.kiosk.content.filter.FilterSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContentExtractorTest {
    ContentExtractor extractor = new ContentExtractor();

    @Mock
    FilterSet filterSet;

    @Mock
    FilterSetProvider provider;

    @Mock
    ExtractorContext context;

    @Test
    public void shouldExtractText(){

        when(filterSet.filter(any())).thenReturn("hello");
        when(provider.get()).thenReturn(filterSet);

        when(context.getFilterSetProvider()).thenReturn(provider);

        final String xhtml = extractor.extract("foo", context);

        assertThat(xhtml).isEqualTo("hello");
    }
}
