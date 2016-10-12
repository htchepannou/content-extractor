package com.tchepannou.kiosk.content;

public class ExtractorConfig {
    private int minTextLength = 255;

    public int getMinTextLength() {
        return minTextLength;
    }

    public void setMinTextLength(final int minTextLength) {
        this.minTextLength = minTextLength;
    }
}
