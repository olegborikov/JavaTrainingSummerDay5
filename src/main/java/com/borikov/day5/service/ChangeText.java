package com.borikov.day5.service;

import com.borikov.day5.exception.IncorrectDataException;

import java.util.List;

public interface ChangeText<T> {
    void replaceSymbolByPosition(List<T> wordText, int position, char newSymbol)
            throws IncorrectDataException;

    void replaceSymbolByBeforeSymbol(List<T> wordText, char beforeSymbol,
                                     char oldSymbol, char newSymbol)
            throws IncorrectDataException;

    void replaceWordByLength(List<T> wordText, int length,
                             T newWord) throws IncorrectDataException;
}
