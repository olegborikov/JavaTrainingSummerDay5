package com.borikov.day5.service.impl;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.service.StringDeleteText;

import java.util.List;
import java.util.regex.Pattern;

public class StringDeleteTextServiceImpl implements StringDeleteText {
    private static final Pattern VOWEL_LETTERS = Pattern.compile("\\b[аоиеёэыуюяАОИЕЁЗЫУЮЯaeiouAEIOU]");
    private static final String SPECIAL_SYMBOLS = "\\p{Punct}|—|\\d";
    private static final String SPACE = " ";

    @Override
    public String deletePunctuation(String text) throws IncorrectDataException {
        if (text == null) {
            throw new IncorrectDataException();
        }
        return text.replaceAll(SPECIAL_SYMBOLS, SPACE);
    }

    @Override
    public void deleteWordByLengthAndFirstLetter(List<String> wordText, int length, boolean isFirstLetterVowel) throws IncorrectDataException {
        if (wordText == null || length < 0) {
            throw new IncorrectDataException();
        }
        for (int i = 0; i < wordText.size(); i++) {
            String word = wordText.get(i);
            if (isFirstLetterVowel) {
                if (word.length() == length && VOWEL_LETTERS.matcher(word).find()) {
                    wordText.remove(i);
                    i--;
                }
            } else {
                if (word.length() == length && !VOWEL_LETTERS.matcher(word).find()) {
                    wordText.remove(i);
                    i--;
                }
            }
        }
    }
}
