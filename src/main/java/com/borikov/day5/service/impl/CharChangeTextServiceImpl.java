package com.borikov.day5.service.impl;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.service.CharChangeText;

import java.util.List;

public class CharChangeTextServiceImpl implements CharChangeText {
    @Override
    public void replaceIndexInEachWord(List<char[]> textByWords, int index, char newSymbol) throws IncorrectDataException {

    }

    @Override
    public void replaceSymbolByBeforeSymbol(List<char[]> textByWords, char beforeSymbol, char oldSymbol, char newSymbol) throws IncorrectDataException {

    }

    @Override
    public void replaceWordByLength(List<char[]> textByWords, String size, char[] newWord) throws IncorrectDataException {

    }
}
