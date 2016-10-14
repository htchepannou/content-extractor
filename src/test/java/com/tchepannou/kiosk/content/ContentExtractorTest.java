package com.tchepannou.kiosk.content;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContentExtractorTest {
    ContentExtractor extractor = new ContentExtractor();

    @Test
    public void testCameroonInfoNet() throws Exception {
        test("cameroon-info.net");
    }


    private void test(final String key) throws Exception{
        final String html = IOUtils.toString(getClass().getResourceAsStream("/extractor/" + key + ".html"));
        final ExtractorContext ctx = createContext();

        final String xhtml = extractor.extract(html, ctx);

        final String expected = IOUtils.toString(getClass().getResourceAsStream("/extractor/" + key + "-content.html"));
        assertHtmlMatches(expected, xhtml);
    }

    private void assertHtmlMatches(final String expected, final String value){
        final String expectedText = Jsoup.parse(expected).text();
        final String valueText = Jsoup.parse(value).text();

        assertThat(expectedText.trim()).isEqualTo(valueText);
    }

    private ExtractorContext createContext() {
        return new ExtractorContext() {
            @Override
            public int getMinTextLength() {
                return 100;
            }
        };
    }
}
