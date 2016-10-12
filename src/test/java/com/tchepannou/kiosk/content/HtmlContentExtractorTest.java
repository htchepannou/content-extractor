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
public class HtmlContentExtractorTest {
    @Mock
    FilterSet<String> filters;

    ExtractorConfig config = new ExtractorConfig();

    @Test
    public void testExtract() throws Exception {
        final String filtered = "yo";
        when(filters.filter(any())).thenReturn(filtered);

        HtmlContentExtractor extractor = new HtmlContentExtractor(filters);
        final String result = extractor.extract("hello world");

        assertThat(result).isEqualTo(filtered);
    }
}
