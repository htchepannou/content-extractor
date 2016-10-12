package com.tchepannou.kiosk.content.filter;

public interface Filter<T> {
    T filter(T str);
}
