package com.borikov.day5.service;

import com.borikov.day5.exception.IncorrectDataException;

import java.util.List;

public class StringService {
    public void replaceSymbolString(List<String> words,
                                    int index, char symbol)
            throws IncorrectDataException {
        if (words == null) {
            throw new IncorrectDataException();
        }
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (words.get(i).length() > index) {
                String newWord = word.substring(0, index) + symbol + word.substring(index + 1);
                words.set(i, newWord);
            }
        }
    }

    public void replaceAfterSymbolString(List<String> words, char beforeSymbol,
                                         char oldSymbol, char newSymbol)
            throws IncorrectDataException {
        if (words == null) {
            throw new IncorrectDataException();
        }
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            for (int j = 0; j < word.length() - 1; j++) {
                if (word.charAt(j) == beforeSymbol && word.charAt(j + 1) == oldSymbol) {
                    String newWord = word.substring(0, j + 1) + newSymbol + word.substring(j + 2);
                    words.set(i, newWord);
                }
            }
        }
    }

    public void replaceWordWithSubstringString(List<String> words,
                                               String oldWord, String newWord)
            throws IncorrectDataException {
        if (words == null) {
            throw new IncorrectDataException();
        }
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (word.equals(oldWord)) {
                words.set(i, newWord);
            }
        }
    }

}
