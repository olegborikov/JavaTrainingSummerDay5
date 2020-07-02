package com.borikov.day5.service;

import com.borikov.day5.exception.IncorrectDataException;

import java.util.List;

public interface StringChangeText extends ChangeText<String> {
    @Override
    void replaceSymbolByIndex(List<String> wordText, int index, char newSymbol) throws IncorrectDataException;

    @Override
    void replaceSymbolByBeforeSymbol(List<String> wordText, char beforeSymbol, char oldSymbol, char newSymbol) throws IncorrectDataException;

    @Override
    void replaceWordByLength(List<String> wordText, int length, String newWord) throws IncorrectDataException;
}
