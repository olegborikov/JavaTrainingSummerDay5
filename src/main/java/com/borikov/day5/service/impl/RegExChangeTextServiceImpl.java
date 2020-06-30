package com.borikov.day5.service.impl;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.service.StringChangeText;

import java.util.List;

public class RegExChangeTextServiceImpl implements StringChangeText {
    @Override
    public void replaceIndexInEachWord(List<String> textByWords, int index, char newSymbol) throws IncorrectDataException {

    }

    @Override
    public void replaceSymbolByBeforeSymbol(List<String> textByWords, char beforeSymbol, char oldSymbol, char newSymbol) throws IncorrectDataException {

    }

    @Override
    public void replaceWordByLength(List<String> textByWords, String size, String newWord) throws IncorrectDataException {

    }
}
