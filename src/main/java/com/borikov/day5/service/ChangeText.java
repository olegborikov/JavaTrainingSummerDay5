package com.borikov.day5.service;

import com.borikov.day5.exception.IncorrectDataException;

import java.util.List;

public interface ChangeText<T> {
    void replaceIndexInEachWord(List<T> textByWords, int index,
                                char newSymbol) throws IncorrectDataException;

    void replaceSymbolByBeforeSymbol(List<T> textByWords, char beforeSymbol,
                                           char oldSymbol, char newSymbol) throws IncorrectDataException;

    void replaceWordByLength(List<T> textByWords, String size,
                                  T newWord) throws IncorrectDataException;
}
