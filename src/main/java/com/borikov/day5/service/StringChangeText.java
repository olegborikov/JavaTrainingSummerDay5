package com.borikov.day5.service;

import com.borikov.day5.exception.IncorrectDataException;

import java.util.List;

public interface StringChangeText extends ChangeText<String> {
    @Override
    void replaceSymbolByPosition(List<String> wordText, int position, char newSymbol)
            throws IncorrectDataException;

    @Override
    void replaceSymbolByBeforeSymbol(List<String> wordText, char beforeSymbol,
                                     char oldSymbol, char newSymbol)
            throws IncorrectDataException;

    @Override
    void replaceWordByLength(List<String> wordText, int length,
                             String newWord) throws IncorrectDataException;
}
