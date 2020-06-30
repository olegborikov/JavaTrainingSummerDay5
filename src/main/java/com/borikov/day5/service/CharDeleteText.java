package com.borikov.day5.service;

import java.util.List;

public interface CharDeleteText extends DeleteText<char[]> {
    @Override
    void deletePunctuation(char[] text);

    @Override
    void deleteWordByLengthAndFirstLetter(List<char[]> text, int length, boolean isFirstLetterVowel);
}
