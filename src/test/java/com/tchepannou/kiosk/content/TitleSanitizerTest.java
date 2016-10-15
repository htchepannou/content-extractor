package com.tchepannou.kiosk.content;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class TitleSanitizerTest {
    private static final String CAMER_BE_REGEX = ".[^:]+:+(.[^:]+)";

    private final TitleSanitizer sanitizer = new TitleSanitizer();

    @Test
    public void shouldNotSanitizeIfNoPattern() throws Exception {
        final String title = "France- Cameroun- Diaspora: France Claudette fete son 27eme aniversaire a Paris";
        final String result = sanitizer.sanitize(title, mock(ExtractorContext.class));

        assertThat(result).isEqualTo(title);
    }

    @Test
    public void shouldSanitizeCamer_be() throws Exception {
        final String title = "France- Cameroun- Diaspora: France Claudette fete son 27eme anniversaire a Paris";
        final String result = sanitizer.sanitize(title, createExtractorContext(CAMER_BE_REGEX));

        assertThat(result).isEqualTo("France Claudette fete son 27eme anniversaire a Paris");
    }

    @Test
    public void shouldSanitizeCamer_be_WithSuffix() throws Exception {
        final String title = "France- Cameroun- Diaspora: France Claudette fete son 27eme anniversaire a Paris :: Cameroon";
        final String result = sanitizer.sanitize(title, createExtractorContext(CAMER_BE_REGEX));

        assertThat(result).isEqualTo("France Claudette fete son 27eme anniversaire a Paris");
    }


    private ExtractorContext createExtractorContext(final String regex) {
        return new ExtractorContext() {
            @Override
            public FilterSetProvider getFilterSetProvider() {
                return null;
            }

            @Override
            public Pattern getTitlePattern() {
                return Pattern.compile(regex);
            }
        };
    }
}
