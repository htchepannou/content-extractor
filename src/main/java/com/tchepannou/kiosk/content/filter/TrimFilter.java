package com.tchepannou.kiosk.content.filter;

public class TrimFilter implements Filter<String> {
    @Override
    public String filter(final String str) {
        final String html = str.trim();
        return html.startsWith("|") ? html.substring(1) : html;
    }
}
