package com.tchepannou.kiosk.content;

import com.tchepannou.kiosk.content.filter.ContentFilter;
import com.tchepannou.kiosk.content.filter.FilterSet;
import com.tchepannou.kiosk.content.filter.HtmlEntityFilter;
import com.tchepannou.kiosk.content.filter.SanitizeFilter;
import com.tchepannou.kiosk.content.filter.TrimFilter;

import java.util.Arrays;

public class DefaultFilterSetProvider implements FilterSetProvider {
    private final int minTextLength;

    public DefaultFilterSetProvider(final int minTextLength) {
        this.minTextLength = minTextLength;
    }

    @Override
    public FilterSet<String> get() {
        return new FilterSet<>(Arrays.asList(
                new SanitizeFilter(),
                new ContentFilter(minTextLength),
                new TrimFilter(),
                new HtmlEntityFilter()
        ));
    }
}
