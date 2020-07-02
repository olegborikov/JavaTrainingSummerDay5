package com.borikov.day5.service;

import com.borikov.day5.exception.IncorrectDataException;

import java.util.List;

public interface ChangeText<T> {
    void replaceSymbolByIndex(List<T> wordText, int index, char newSymbol) throws IncorrectDataException;

    void replaceSymbolByBeforeSymbol(List<T> wordText, char beforeSymbol, char oldSymbol, char newSymbol) throws IncorrectDataException;

    void replaceWordByLength(List<T> wordText, int length, T newWord) throws IncorrectDataException;
}
