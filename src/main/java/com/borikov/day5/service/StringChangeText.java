package com.borikov.day5.service;

import com.borikov.day5.exception.IncorrectDataException;

import java.util.List;

public interface StringChangeText extends ChangeText<String> {
    @Override
    void replaceIndexInEachWord(List<String> textByWords, int index, char newSymbol) throws IncorrectDataException;

    @Override
    void replaceSymbolByBeforeSymbol(List<String> textByWords, char beforeSymbol, char oldSymbol, char newSymbol) throws IncorrectDataException;

    @Override
    void replaceWordByLength(List<String> textByWords, String size, String newWord) throws IncorrectDataException;
}
