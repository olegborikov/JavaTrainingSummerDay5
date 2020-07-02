package com.borikov.day5.parser;

import com.borikov.day5.exception.IncorrectDataException;

import java.util.ArrayList;
import java.util.List;

public class CharParser {
    private static final String SPECIAL_SYMBOLS = "\\p{Punct}+|\\s+|—";
    private static final String SPACE = " ";

    public List<char[]> parseParagraphListToWordCharList(List<String> paragraphText) throws IncorrectDataException {
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
        List<char[]> wordCharText = new ArrayList<>();
        for (String word : wordText) {
            wordCharText.add(word.toCharArray());
        }
        return wordCharText;
    }

    public char[] parseListToCharArray(List<String> paragraphText) throws IncorrectDataException {
        if (paragraphText == null) {
            throw new IncorrectDataException();
        }
        String stringText = String.join(SPACE, paragraphText);
        return stringText.toCharArray();
    }
}
