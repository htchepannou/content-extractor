package com.tchepannou.kiosk.content;

import com.tchepannou.kiosk.content.filter.ContentFilter;
import com.tchepannou.kiosk.content.filter.FilterSet;
import com.tchepannou.kiosk.content.filter.HtmlEntityFilter;
import com.tchepannou.kiosk.content.filter.SanitizeFilter;
import com.tchepannou.kiosk.content.filter.TrimFilter;

import java.util.Arrays;

public class HtmlContentExtractor {
    private final FilterSet<String> filterSet;

    public HtmlContentExtractor(final ExtractorConfig config) {
        this.filterSet = createDefaultFilterSet(config);
    }

    protected HtmlContentExtractor(final FilterSet filterSet) {
        this.filterSet = filterSet;
    }

    public String extract(final String html){
        return filterSet.filter(html);
    }

    private FilterSet<String> createDefaultFilterSet(final ExtractorConfig config){
        return new FilterSet<>(Arrays.asList(
                new SanitizeFilter(),
                new ContentFilter(config.getMinTextLength()),
                new TrimFilter(),
                new HtmlEntityFilter()
        ));
    }
}
