package com.borikov.day5.service.impl;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.service.CharDeleteText;

import java.util.List;
import java.util.regex.Pattern;

public class CharDeleteTextServiceImpl implements CharDeleteText {
    private static final Pattern VOWEL_LETTERS = Pattern.compile("\\b[аоиеёэыуюяАОИЕЁЗЫУЮЯaeiouAEIOU]");
    private static final char[] SPECIAL_SYMBOLS = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~—".toCharArray();

    @Override
    public char[] deletePunctuation(char[] text) throws IncorrectDataException {
        if (text == null) {
            throw new IncorrectDataException();
        }
        for (int i = 0; i < text.length; i++) {
            if (!isSymbolNotWord(text[i])) {
                text[i] = ' ';
            }
        }
        return text;
    }

    private boolean isSymbolNotWord(char symbol) {
        boolean result = true;
        for (char specialSymbol : SPECIAL_SYMBOLS) {
            if (symbol == specialSymbol) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public void deleteWordByLengthAndFirstLetter(List<char[]> wordText, int length, boolean isFirstLetterVowel) throws IncorrectDataException {
        if (wordText == null || length < 0) {
            throw new IncorrectDataException();
        }
        for (int i = 0; i < wordText.size(); i++) {
            char[] word = wordText.get(i);
            if (isFirstLetterVowel) {
                if (word.length == length && VOWEL_LETTERS.matcher(word.toString()).find()) {
                    wordText.remove(i);
                    i--;
                }
            } else {
                if (word.length == length && !VOWEL_LETTERS.matcher(word.toString()).find()) {
                    wordText.remove(i);
                    i--;
                }
            }
        }
    }
}
