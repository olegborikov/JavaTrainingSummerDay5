package com.borikov.day5.service.impl;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.service.StringDeleteText;

import java.util.List;

public class RegExDeleteTextServiceImpl implements StringDeleteText {
    @Override
    public String deletePunctuation(String text) throws IncorrectDataException {
        return "dsa";
    }

    @Override
    public void deleteWordByLengthAndFirstLetter(List<String> wordText, int length, boolean isFirstLetterVowel) {

    }
}
