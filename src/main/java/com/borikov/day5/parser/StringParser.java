package com.borikov.day5.parser;

import com.borikov.day5.exception.IncorrectDataException;

import java.util.ArrayList;
import java.util.List;

public class StringParser {
    public List<String> parseParagraphsListToWordsList(List<String> paragraphsList) throws IncorrectDataException {
        if (paragraphsList == null || paragraphsList.isEmpty()) {
            throw new IncorrectDataException();
        }
        List<String> wordsList = new ArrayList<>();
        for (String paragraph : paragraphsList) {
            String[] wordData = paragraph.split("\\p{Punct}|\\s");
            for (String word : wordData) {
                if (!word.equals("")) {
                    wordsList.add(word);
                }
            }
        }
        return wordsList;
    }

    public String parseListToString(List<String> textData) throws IncorrectDataException {
        if (textData == null || textData.isEmpty()) {
            throw new IncorrectDataException();
        }
        StringBuilder text = new StringBuilder();
        for (String data : textData) {
            text.append(data);
        }
        return text.toString();
    }
}
