package com.borikov.day5.parser;

import com.borikov.day5.exception.IncorrectDataException;

import java.util.ArrayList;
import java.util.List;

public class CharParser {
    public List<char[]> parseStringListToCharArrayList(List<String> data) throws IncorrectDataException {
        if (data == null || data.isEmpty()) {
            throw new IncorrectDataException();
        }
        List<char[]> newData = new ArrayList<>();
        for (String currentData : data) {
            newData.add(currentData.toCharArray());
        }
        return newData;
    }
}
