package com.borikov.day5.service.impl;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.service.CharDeleteText;

import java.util.List;

public class CharDeleteTextServiceImpl implements CharDeleteText {
    private static final char[] VOWEL_LETTERS = ("аоиеёэыуюя" +
            "АОИЕЁЗЫУЮЯaeiouAEIOU").toCharArray();
    private static final char[] LETTERS = ("abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "абвгдежзийклмнопрстуфхцчшщъыьэюя" +
            "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ").toCharArray();

    @Override
    public char[] deletePunctuationAndNumbers(char[] text) throws IncorrectDataException {
        if (text == null) {
            throw new IncorrectDataException();
        }
        for (int i = 0; i < text.length; i++) {
            if (!isSymbolNotLetter(text[i])) {
                text[i] = ' ';
            }
        }
        return text;
    }

    private boolean isSymbolNotLetter(char symbol) {
        boolean result = false;
        for (char letter : LETTERS) {
            if (symbol == letter) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public void deleteWordByLengthAndFirstLetter(List<char[]> wordText, int length,
                                                 boolean isFirstLetterVowel)
            throws IncorrectDataException {
        if (wordText == null || length < 0) {
            throw new IncorrectDataException();
        }
        for (int i = 0; i < wordText.size(); i++) {
            char[] word = wordText.get(i);
            if (isFirstLetterVowel) {
                if (word.length == length && isSymbolVowelLetter(word[0])) {
                    wordText.remove(i);
                    i--;
                }
            } else {
                if (word.length == length && isSymbolConsonantLetter(word[0])) {
                    wordText.remove(i);
                    i--;
                }
            }
        }
    }

    private boolean isSymbolVowelLetter(char symbol) {
        boolean result = false;
        for (char vowelLetter : VOWEL_LETTERS) {
            if (symbol == vowelLetter) {
                result = true;
                break;
            }
        }
        return result;
    }

    private boolean isSymbolConsonantLetter(char symbol) {
        boolean result = false;
        for (char letter : LETTERS) {
            if (symbol == letter && !isSymbolVowelLetter(symbol)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
