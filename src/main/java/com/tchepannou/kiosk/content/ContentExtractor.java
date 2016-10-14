package com.tchepannou.kiosk.content;

import com.tchepannou.kiosk.content.filter.FilterSet;

public class ContentExtractor {
    public String extract(final String html, final ExtractorContext context){
        final FilterSet<String> filterSet = context.getFilterSetProvider().get();
        return filterSet.filter(html);
    }
}
