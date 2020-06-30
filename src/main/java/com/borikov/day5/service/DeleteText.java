package com.borikov.day5.service;

import java.util.List;

public interface DeleteText<T> {

    void deletePunctuation(T text);

    void deleteWordByLengthAndFirstLetter(List<T> text, int length, boolean isFirstLetterVowel);
}
