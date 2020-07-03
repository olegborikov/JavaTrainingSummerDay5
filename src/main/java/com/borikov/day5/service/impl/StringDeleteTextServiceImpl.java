package com.borikov.day5.service.impl;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.service.StringDeleteText;

import java.util.List;

public class StringDeleteTextServiceImpl implements StringDeleteText {
    private static final String FIRST_VOWEL_LETTER = "\\b[аоиеёэыуюяАОИЕЁЗЫУЮЯaeiouAEIOU].*";
    private static final String NON_LETTER_SYMBOLS = "[^\\p{L}]";
    private static final String FIRST_LETTER_SYMBOL = "\\b[\\p{L}].*";
    private static final String SPACE = " ";

    @Override
    public String deletePunctuationAndNumbers(String text)
            throws IncorrectDataException {
        if (text == null) {
            throw new IncorrectDataException();
        }
        String formattedText = text.replaceAll(NON_LETTER_SYMBOLS, SPACE);
        return formattedText;
    }

    @Override
    public void deleteWordByLengthAndFirstLetter(List<String> wordText, int length,
                                                 boolean isFirstLetterVowel)
            throws IncorrectDataException {
        if (wordText == null || length < 0) {
            throw new IncorrectDataException();
        }
        for (int i = 0; i < wordText.size(); i++) {
            String word = wordText.get(i);
            if (isFirstLetterVowel) {
                if (word.length() == length && word.matches(FIRST_VOWEL_LETTER)) {
                    wordText.remove(i);
                    i--;
                }
            } else {
                if (word.length() == length &&
                        !word.matches(FIRST_VOWEL_LETTER) &&
                        word.matches(FIRST_LETTER_SYMBOL)) {
                    wordText.remove(i);
                    i--;
                }
            }
        }
    }
}
