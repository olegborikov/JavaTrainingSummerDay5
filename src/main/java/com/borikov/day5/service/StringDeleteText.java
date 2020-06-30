package com.borikov.day5.service;

import java.util.List;

public interface StringDeleteText extends DeleteText<String> {
    @Override
    void deletePunctuation(String text);

    @Override
    void deleteWordByLengthAndFirstLetter(List<String> text, int length, boolean isFirstLetterVowel);
}
