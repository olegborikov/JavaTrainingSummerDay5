package com.borikov.day5.service.impl;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.service.StringDeleteText;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDeleteTextServiceImpl implements StringDeleteText {
    private static final String NON_LETTER_SYMBOLS = "[^\\p{L}]";
    private static final String SPACE = " ";
    private static final String FIRST_VOWEL_LETTER_BEGIN =
            "\\b[аоиеёэыуюяАОИЕЁЗЫУЮЯaeiouAEIOU]\\p{L}{";
    private static final String FIRST_CONSONANT_LETTER_BEGIN =
            "\\b[\\p{L}&&[^аоиеёэыуюяАОИЕЁЗЫУЮЯaeiouAEIOU]]\\p{L}{";
    private static final String FIRST_LETTER_END = "}\\b";

    @Override
    public String deletePunctuationAndNumbers(String text)
            throws IncorrectDataException {
        if (text == null) {
            throw new IncorrectDataException();
        }
        Pattern pattern = Pattern.compile(NON_LETTER_SYMBOLS);
        Matcher matcher = pattern.matcher(text);
        String formattedText = text;
        if (matcher.find()) {
            formattedText = matcher.replaceAll(SPACE);
        }
        return formattedText;
    }

    @Override
    public void deleteWordByLengthAndFirstLetter(List<String> wordText, int length,
                                                 boolean isFirstLetterVowel)
            throws IncorrectDataException {
        if (wordText == null || length < 0) {
            throw new IncorrectDataException();
        }
        Pattern pattern;
        if (isFirstLetterVowel) {
            pattern = Pattern.compile(FIRST_VOWEL_LETTER_BEGIN +
                    (length - 1) + FIRST_LETTER_END);
        } else {
            pattern = Pattern.compile(FIRST_CONSONANT_LETTER_BEGIN +
                    (length - 1) + FIRST_LETTER_END);
        }
        Matcher matcher;
        for (int i = 0; i < wordText.size(); i++) {
            matcher = pattern.matcher(wordText.get(i));
            if (matcher.find()) {
                wordText.remove(i);
                i--;
            }
        }
    }
}
