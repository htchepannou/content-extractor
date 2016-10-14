package com.tchepannou.kiosk.content;

import com.tchepannou.kiosk.content.filter.ContentFilter;
import com.tchepannou.kiosk.content.filter.FilterSet;
import com.tchepannou.kiosk.content.filter.HtmlEntityFilter;
import com.tchepannou.kiosk.content.filter.SanitizeFilter;
import com.tchepannou.kiosk.content.filter.TrimFilter;

import java.util.Arrays;

public class ContentExtractor {
    public String extract(final String html, final ExtractorContext context){
        return createDefaultFilterSet(context).filter(html);
    }

    private FilterSet<String> createDefaultFilterSet(final ExtractorContext context){
        return new FilterSet<>(Arrays.asList(
                new SanitizeFilter(),
                new ContentFilter(context.getMinTextLength()),
                new TrimFilter(),
                new HtmlEntityFilter()
        ));
    }
}
