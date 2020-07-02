package com.borikov.day5.service.impl;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.service.CharChangeText;

import java.util.List;

public class CharChangeTextServiceImpl implements CharChangeText {
    @Override
    public void replaceSymbolByIndex(List<char[]> wordText, int index, char newSymbol) throws IncorrectDataException {
        if (wordText == null || index < 0) {
            throw new IncorrectDataException();
        }
        for (int i = 0; i < wordText.size(); i++) {
            char[] word = wordText.get(i);
            if (word.length > index) {
                word[index] = newSymbol;
            }
        }
    }

    @Override
    public void replaceSymbolByBeforeSymbol(List<char[]> wordText, char beforeSymbol, char oldSymbol, char newSymbol) throws IncorrectDataException {
        if (wordText == null) {
            throw new IncorrectDataException();
        }
        for (int i = 0; i < wordText.size(); i++) {
            char[] word = wordText.get(i);
            for (int j = 0; j < word.length - 1; j++) {
                if (word[j] == beforeSymbol && word[j + 1] == oldSymbol) {
                    word[j + 1] = newSymbol;
                }
            }
        }
    }

    @Override
    public void replaceWordByLength(List<char[]> wordText, int length, char[] newWord) throws IncorrectDataException {
        if (wordText == null || length < 0 || newWord == null) {
            throw new IncorrectDataException();
        }
        for (int i = 0; i < wordText.size(); i++) {
            char[] word = wordText.get(i);
            if(word.length == length){
                wordText.set(i, newWord);
            }
        }
    }
}
