package com.tchepannou.kiosk.content;

import com.tchepannou.kiosk.content.filter.FilterSet;

public interface FilterSetProvider {
    FilterSet<String> get();
}
