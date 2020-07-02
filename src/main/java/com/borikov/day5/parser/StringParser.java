package com.borikov.day5.parser;

import com.borikov.day5.exception.IncorrectDataException;

import java.util.ArrayList;
import java.util.List;

public class StringParser {
    private static final String SPECIAL_SYMBOLS = "\\p{Punct}+|\\s+|—";

    public List<String> parseParagraphListToWordList(List<String> paragraphText) throws IncorrectDataException {
        if (paragraphText == null) {
            throw new IncorrectDataException();
        }
        List<String> wordText = new ArrayList<>();
        for (String paragraph : paragraphText) {
            String[] wordData = paragraph.split(SPECIAL_SYMBOLS);
            for (String word : wordData) {
                if (!word.equals("")) {
                    wordText.add(word);
                }
            }
        }
        return wordText;
    }
}
