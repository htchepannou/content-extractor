package com.tchepannou.kiosk.content;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TitleSanitizer {
    String sanitize(final String title, final ExtractorContext context) {
        final Pattern pattern = context.getTitlePattern();
        if (pattern != null) {
            final Matcher matcher = pattern.matcher(title);
            if (matcher.find()) {
                return matcher.group(1).trim();
            }

        }
        return title.trim();
    }
}
