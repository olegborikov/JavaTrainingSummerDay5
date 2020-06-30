package com.borikov.day5.service;

import com.borikov.day5.exception.IncorrectDataException;

import java.util.List;

public interface CharChangeText extends ChangeText<char[]> {
    @Override
    void replaceIndexInEachWord(List<char[]> textByWords, int index, char newSymbol) throws IncorrectDataException;

    @Override
    void replaceSymbolByBeforeSymbol(List<char[]> textByWords, char beforeSymbol, char oldSymbol, char newSymbol) throws IncorrectDataException;

    @Override
    void replaceWordByLength(List<char[]> textByWords, String size, char[] newWord) throws IncorrectDataException;
}
