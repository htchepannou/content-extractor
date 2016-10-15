package com.tchepannou.kiosk.content;

import java.util.regex.Pattern;

public interface ExtractorContext {
    FilterSetProvider getFilterSetProvider();

    Pattern getTitlePattern();
}
