package com.borikov.day5.service.impl;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.service.StringChangeText;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExChangeTextServiceImpl implements StringChangeText {
    private static final String WORD_SYMBOL_POSITION_BEGIN = "\\b(\\p{L}{";
    private static final String WORD_SYMBOL_POSITION_END = "})(\\p{L})(\\p{L}*)\\b";
    private static final String WORD_FIRST_PART = "$1";
    private static final String WORD_THIRD_PART = "$3";
    private static final String WORD_CURRENT_LENGTH_BEGIN = "\\b\\p{L}{";
    private static final String WORD_CURRENT_LENGTH_END = "}\\b";

    @Override
    public void replaceSymbolByPosition(List<String> wordText, int position,
                                        char newSymbol) throws IncorrectDataException {
        if (wordText == null || position < 1) {
            throw new IncorrectDataException();
        }
        Pattern pattern = Pattern.compile(WORD_SYMBOL_POSITION_BEGIN + (position - 1) +
                WORD_SYMBOL_POSITION_END);
        Matcher matcher;
        for (int i = 0; i < wordText.size(); i++) {
            matcher = pattern.matcher(wordText.get(i));
            if (matcher.find()) {
                String word = matcher.replaceAll(WORD_FIRST_PART +
                        newSymbol + WORD_THIRD_PART);
                wordText.set(i, word);
            }
        }
    }

    @Override
    public void replaceSymbolByBeforeSymbol(List<String> wordText, char beforeSymbol,
                                            char oldSymbol, char newSymbol)
            throws IncorrectDataException {
        if (wordText == null) {
            throw new IncorrectDataException();
        }
        Pattern pattern = Pattern.compile("" + beforeSymbol + oldSymbol);
        Matcher matcher;
        for (int i = 0; i < wordText.size(); i++) {
            matcher = pattern.matcher(wordText.get(i));
            if (matcher.find()) {
                String word = matcher.replaceAll("" + beforeSymbol + newSymbol);
                wordText.set(i, word);
            }
        }
    }

    @Override
    public void replaceWordByLength(List<String> wordText, int length,
                                    String newWord) throws IncorrectDataException {
        if (wordText == null || length < 0 || newWord == null) {
            throw new IncorrectDataException();
        }
        Pattern pattern = Pattern.compile(WORD_CURRENT_LENGTH_BEGIN + length +
                WORD_CURRENT_LENGTH_END);
        Matcher matcher;
        for (int i = 0; i < wordText.size(); i++) {
            matcher = pattern.matcher(wordText.get(i));
            if (matcher.find()) {
                String word = matcher.replaceAll(newWord);
                wordText.set(i, word);
            }
        }
    }
}
