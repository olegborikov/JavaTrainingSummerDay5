package com.borikov.day5.service;

import com.borikov.day5.exception.IncorrectDataException;

import java.util.List;

public interface DeleteText<T> {
    T deletePunctuationAndNumbers(T text) throws IncorrectDataException;

    void deleteWordByLengthAndFirstLetter(List<T> wordText, int length,
                                          boolean isFirstLetterConsonant)
            throws IncorrectDataException;
}
