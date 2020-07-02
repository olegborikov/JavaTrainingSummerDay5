package com.borikov.day5.parser;

import com.borikov.day5.exception.IncorrectDataException;

import java.util.ArrayList;
import java.util.List;

public class CharParser {
    private static final String SPECIAL_SYMBOLS = "[^\\p{L}\\d]";

    public List<char[]> parseTextToWordCharList(String text) throws IncorrectDataException {
        if (text == null) {
            throw new IncorrectDataException();
        }
        List<String> wordText = new ArrayList<>();
        String[] wordData = text.split(SPECIAL_SYMBOLS);
        for (String word : wordData) {
            if (!word.equals("")) {
                wordText.add(word);
            }
        }
        List<char[]> wordCharText = new ArrayList<>();
        for (String word : wordText) {
            wordCharText.add(word.toCharArray());
        }
        return wordCharText;
    }
}
