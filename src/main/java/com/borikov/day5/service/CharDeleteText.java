package com.borikov.day5.service;

import com.borikov.day5.exception.IncorrectDataException;

import java.util.List;

public interface CharDeleteText extends DeleteText<char[]> {
    @Override
    char[] deletePunctuationAndNumbers(char[] text) throws IncorrectDataException;

    @Override
    void deleteWordByLengthAndFirstLetter(List<char[]> wordText, int length,
                                          boolean isFirstLetterVowel)
            throws IncorrectDataException;
}
