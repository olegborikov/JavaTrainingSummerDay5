package com.borikov.day5.service;

import com.borikov.day5.exception.IncorrectDataException;

import java.util.List;

public interface CharChangeText extends ChangeText<char[]> {
    @Override
    void replaceSymbolByIndex(List<char[]> wordText, int index, char newSymbol) throws IncorrectDataException;

    @Override
    void replaceSymbolByBeforeSymbol(List<char[]> wordText, char beforeSymbol, char oldSymbol, char newSymbol) throws IncorrectDataException;

    @Override
    void replaceWordByLength(List<char[]> wordText, int length, char[] newWord) throws IncorrectDataException;
}
