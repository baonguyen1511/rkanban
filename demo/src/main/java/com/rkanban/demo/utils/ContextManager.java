package com.rkanban.demo.utils;

public class ContextManager {
    public boolean isNullOrEmpty(String content) {
        return !((content != null) && (content.length() > 0));
    }
}
