package test.borikov.day5.service.impl;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.service.impl.CharDeleteTextServiceImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class CharDeleteTextServiceImplTest {
    CharDeleteTextServiceImpl charDeleteTextService;

    @BeforeClass
    public void setUp() {
        charDeleteTextService = new CharDeleteTextServiceImpl();
    }

    @AfterClass
    public void tearDown() {
        charDeleteTextService = null;
    }

    @DataProvider(name = "deletePunctuationPositiveData")
    public Object[][] createDeletePunctuationPositiveData() {
        char[] actual1 = {'a', 'b', '\'', '1', '~'};
        char[] expected1 = {'a', 'b', ' ', '1', ' '};
        char[] actual2 = {'e', 'а', 'ы', '>', '!', '—'};
        char[] expected2 = {'e', 'а', 'ы', ' ', ' ', ' '};
        char[] actual3 = {'#', '@', '^'};
        char[] expected3 = {' ', ' ', ' '};
        return new Object[][]{
                {actual1, expected1},
                {actual2, expected2},
                {actual3, expected3},
        };
    }

    @Test(dataProvider = "deletePunctuationPositiveData")
    public void deletePunctuationPositiveTest(char[] actual, char[] expected) {
        try {
            charDeleteTextService.deletePunctuation(actual);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "deletePunctuationNegativeData")
    public Object[][] createDeletePunctuationNegativeData() {
        char[] actual1 = {'a', 'b', '\'', '1', '~'};
        char[] expected1 = {'a', 'b', ' ', ' ', ' '};
        char[] actual2 = {'e', 'а', 'ы', '>', '!', '—'};
        char[] expected2 = {'e', 'а', 'ы', ' ', ' '};
        char[] actual3 = {'#', '@', '^'};
        char[] expected3 = {' ', ' ', 'k'};
        return new Object[][]{
                {actual1, expected1},
                {actual2, expected2},
                {actual3, expected3},
        };
    }

    @Test(dataProvider = "deletePunctuationNegativeData")
    public void deletePunctuationNegativeTest(char[] actual, char[] expected) {
        try {
            charDeleteTextService.deletePunctuation(actual);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void deletePunctuationExceptionTest() throws IncorrectDataException {
        char[] actual = null;
        charDeleteTextService.deletePunctuation(actual);
    }

    @DataProvider(name = "deleteWordByLengthAndFirstLetterPositiveData")
    public Object[][] createDeleteWordByLengthAndFirstLetterPositiveData() {
        List<char[]> actual1 = new ArrayList<>();
        actual1.add(new char[]{'Я'});
        actual1.add(new char[]{'т', 'а', 'к'});
        actual1.add(new char[]{'о', 'ч', 'а'});
        actual1.add(new char[]{'п', 'р', 'е'});
        List<char[]> expected1 = new ArrayList<>();
        expected1.add(new char[]{'Я'});
        expected1.add(new char[]{'о', 'ч', 'а'});
        List<char[]> actual2 = new ArrayList<>();
        actual2.add(new char[]{'Я'});
        actual2.add(new char[]{'о', 'ч', 'а', 'р', 'о', 'в', 'а', 'н'});
        actual2.add(new char[]{'п', 'р', 'е', 'л', 'е', 'с', 'т', 'я', 'м', 'и'});
        List<char[]> expected2 = new ArrayList<>();
        expected2.add(new char[]{'Я'});
        expected2.add(new char[]{'о', 'ч', 'а', 'р', 'о', 'в', 'а', 'н'});
        expected2.add(new char[]{'п', 'р', 'е', 'л', 'е', 'с', 'т', 'я', 'м', 'и'});
        List<char[]> actual3 = new ArrayList<>();
        actual3.add(new char[]{'Я'});
        actual3.add(new char[]{'о', 'ч'});
        actual3.add(new char[]{'п', 'р'});
        actual3.add(new char[]{'3', 'р'});
        actual3.add(new char[]{'е', 'р'});
        List<char[]> expected3 = new ArrayList<>();
        expected3.add(new char[]{'Я'});
        expected3.add(new char[]{'п', 'р'});
        expected3.add(new char[]{'3', 'р'});
        return new Object[][]{
                {actual1, 3, false, expected1},
                {actual2, 0, true, expected2},
                {actual3, 2, true, expected3},
        };
    }

    @Test(dataProvider = "deleteWordByLengthAndFirstLetterPositiveData")
    public void deleteWordByLengthAndFirstLetterPositiveTest(List<char[]> actual, int length, boolean isFirstLetterVowel, List<char[]> expected) {
        try {
            charDeleteTextService.deleteWordByLengthAndFirstLetter(actual, length, isFirstLetterVowel);
            boolean result = equalsListCharArray(actual, expected);
            assertTrue(result);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "deleteWordByLengthAndFirstLetterNegativeData")
    public Object[][] createDeleteWordByLengthAndFirstLetterNegativeData() {
        List<char[]> actual1 = new ArrayList<>();
        actual1.add(new char[]{'Я'});
        actual1.add(new char[]{'т', 'а', 'к'});
        actual1.add(new char[]{'о', 'ч', 'а'});
        actual1.add(new char[]{'п', 'р', 'е'});
        List<char[]> expected1 = new ArrayList<>();
        expected1.add(new char[]{'Я'});
        expected1.add(new char[]{'т', 'а', 'к'});
        expected1.add(new char[]{'о', 'ч', 'а'});
        expected1.add(new char[]{'п', 'р', 'е'});
        List<char[]> actual2 = new ArrayList<>();
        actual2.add(new char[]{'Я'});
        actual2.add(new char[]{'о', 'ч', 'а', 'р', 'о', 'в', 'а', 'н'});
        actual2.add(new char[]{'п', 'р', 'е', 'л', 'е', 'с', 'т', 'я', 'м', 'и'});
        List<char[]> expected2 = new ArrayList<>();
        expected2.add(new char[]{'Я'});
        expected2.add(new char[]{'о', 'ч', 'а', 'р', 'о', 'в', 'а', ' '});
        expected2.add(new char[]{'п', 'р', 'е', 'л', 'е', 'с', 'т', 'я', 'м', 'и'});
        List<char[]> actual3 = new ArrayList<>();
        actual3.add(new char[]{'Я'});
        actual3.add(new char[]{'о', 'ч'});
        actual3.add(new char[]{'п', 'р'});
        actual3.add(new char[]{'3', 'р'});
        actual3.add(new char[]{'е', 'р'});
        List<char[]> expected3 = new ArrayList<>();
        expected3.add(new char[]{'п', 'р'});
        expected3.add(new char[]{'3', 'р'});
        return new Object[][]{
                {actual1, 3, false, expected1},
                {actual2, 0, true, expected2},
                {actual3, 2, true, expected3},
        };
    }

    @Test(dataProvider = "deleteWordByLengthAndFirstLetterNegativeData")
    public void deleteWordByLengthAndFirstLetterNegativeTest(List<char[]> actual, int length, boolean isFirstLetterVowel, List<char[]> expected) {
        try {
            charDeleteTextService.deleteWordByLengthAndFirstLetter(actual, length, isFirstLetterVowel);
            boolean result = equalsListCharArray(actual, expected);
            assertFalse(result);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "deleteWordByLengthAndFirstLetterExceptionData")
    public Object[][] createDeleteWordByLengthAndFirstLetterExceptionData() {
        List<char[]> actual1 = new ArrayList<>();
        return new Object[][]{
                {null, 1, false},
                {actual1, -5, false},
        };
    }

    @Test(dataProvider = "deleteWordByLengthAndFirstLetterExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void deleteWordByLengthAndFirstLetterExceptionTest(List<char[]> actual, int length, boolean isFirstLetterVowel) throws IncorrectDataException {
        charDeleteTextService.deleteWordByLengthAndFirstLetter(actual, length, isFirstLetterVowel);
    }

    private boolean equalsListCharArray(List<char[]> firstCharList, List<char[]> secondCharList) {
        boolean result = true;
        if (firstCharList == null || secondCharList == null || firstCharList.size() != secondCharList.size()) {
            result = false;
        } else {
            for (int i = 0; i < firstCharList.size(); i++) {
                if (firstCharList.get(i).length != secondCharList.get(i).length) {
                    result = false;
                    break;
                } else {
                    for (int j = 0; j < firstCharList.get(i).length; j++) {
                        if (firstCharList.get(i)[j] != secondCharList.get(i)[j]) {
                            result = false;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}
