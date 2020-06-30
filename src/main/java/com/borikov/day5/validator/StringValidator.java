package com.borikov.day5.validator;

import java.util.List;

public class StringValidator {
    private static final String SPACES = "\\s+";

    public boolean isStringEmpty(String line) {
        boolean result = false;
        if (line == null || line.matches(SPACES) || line.isEmpty()) {
            result = true;
        }
        return result;
    }

    public boolean isStringListEmpty(List<String> lines) {
        boolean result = false;
        if (lines == null || lines.isEmpty()) {
            result = true;
        } else {
            for (String line : lines) {
                if (isStringEmpty(line)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
