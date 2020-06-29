package com.borikov.day5.validator;

import com.borikov.day5.exception.IncorrectDataException;

import java.util.List;

public class StringValidator {
    private static final String REGEX = "\\s+";

    public boolean isStringEmpty(String line) throws IncorrectDataException {
        if (line == null) {
            throw new IncorrectDataException();
        }
        boolean result = false;
        if (line.matches(REGEX) || line.isEmpty()) {
            result = true;
        }
        return result;
    }

    public boolean isStringListEmpty(List<String> lines) throws IncorrectDataException {
        if (lines == null) {
            throw new IncorrectDataException();
        }
        boolean result = false;
        for (String line : lines) {
            if (isStringEmpty(line)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
