package com.borikov.day5.service.impl;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.service.StringChangeText;

import java.util.List;

public class StringChangeTextServiceImpl implements StringChangeText {
    @Override
    public void replaceSymbolByIndex(List<String> wordText, int index, char newSymbol) throws IncorrectDataException {
        if (wordText == null || index < 0) {
            throw new IncorrectDataException();
        }
        for (int i = 0; i < wordText.size(); i++) {
            String word = wordText.get(i);
            if (word.length() > index) {
                String newWord = word.substring(0, index) + newSymbol + word.substring(index + 1);
                wordText.set(i, newWord);
            }
        }
    }

    @Override
    public void replaceSymbolByBeforeSymbol(List<String> wordText, char beforeSymbol, char oldSymbol, char newSymbol) throws IncorrectDataException {
        if (wordText == null) {
            throw new IncorrectDataException();
        }
        for (int i = 0; i < wordText.size(); i++) {
            String word = wordText.get(i);
            for (int j = 0; j < word.length() - 1; j++) {
                if (word.charAt(j) == beforeSymbol && word.charAt(j + 1) == oldSymbol) {
                    String newWord = word.substring(0, j + 1) + newSymbol + word.substring(j + 2);
                    wordText.set(i, newWord);
                }
            }
        }
    }

    @Override
    public void replaceWordByLength(List<String> wordText, int length, String newWord) throws IncorrectDataException {
        if (wordText == null || length < 0 || newWord == null) {
            throw new IncorrectDataException();
        }
        for (int i = 0; i < wordText.size(); i++) {
            String word = wordText.get(i);
            if (word.length() == length) {
                wordText.set(i, newWord);
            }
        }
    }
}
