package com.borikov.day5.service;

import com.borikov.day5.exception.IncorrectDataException;

import java.util.List;

public interface StringDeleteText extends DeleteText<String> {
    @Override
    String deletePunctuationAndNumbers(String text) throws IncorrectDataException;

    @Override
    void deleteWordByLengthAndFirstLetter(List<String> wordText, int length,
                                          boolean isFirstLetterVowel)
            throws IncorrectDataException;
}
