package test.borikov.day5.service.impl;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.service.impl.CharChangeTextServiceImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CharChangeTextServiceImplTest {
    CharChangeTextServiceImpl charChangeTextService;

    @BeforeClass
    public void setUp() {
        charChangeTextService = new CharChangeTextServiceImpl();
    }

    @AfterClass
    public void tearDown() {
        charChangeTextService = null;
    }

    @DataProvider(name = "replaceSymbolByIndexPositiveData")
    public Object[][] createReplaceSymbolByIndexPositiveData() {
        List<char[]> actual1 = new ArrayList<>();
        actual1.add(new char[]{'Я'});
        actual1.add(new char[]{'т', 'а', 'к'});
        actual1.add(new char[]{});
        actual1.add(new char[]{'о', 'ч', 'а', 'р', 'о', 'в', 'а', 'н'});
        actual1.add(new char[]{'п', 'р', 'е', 'л', 'е', 'с', 'т', 'я', 'м', 'и'});
        List<char[]> expected1 = new ArrayList<>();
        expected1.add(new char[]{'Я'});
        expected1.add(new char[]{'т', 'а', 'к'});
        expected1.add(new char[]{});
        expected1.add(new char[]{'о', 'ч', 'а', 'р', 'о', 'А', 'а', 'н'});
        expected1.add(new char[]{'п', 'р', 'е', 'л', 'е', 'А', 'т', 'я', 'м', 'и'});
        List<char[]> actual2 = new ArrayList<>();
        actual2.add(new char[]{'Я'});
        actual2.add(new char[]{'о', 'ч', 'а', 'р', 'о', 'в', 'а', 'н'});
        actual2.add(new char[]{'п', 'р', 'е', 'л', 'е', 'с', 'т', 'я', 'м', 'и'});
        List<char[]> expected2 = new ArrayList<>();
        expected2.add(new char[]{'~'});
        expected2.add(new char[]{'~', 'ч', 'а', 'р', 'о', 'в', 'а', 'н'});
        expected2.add(new char[]{'~', 'р', 'е', 'л', 'е', 'с', 'т', 'я', 'м', 'и'});
        List<char[]> actual3 = new ArrayList<>();
        List<char[]> expected3 = new ArrayList<>();
        return new Object[][]{
                {actual1, 5, 'А', expected1},
                {actual2, 0, '~', expected2},
                {actual3, 3, 'Т', expected3},
        };
    }

    @Test(dataProvider = "replaceSymbolByIndexPositiveData")
    public void replaceSymbolByIndexPositiveTest(List<char[]> actual, int index, char newSymbol, List<char[]> expected) {
        try {
            charChangeTextService.replaceSymbolByIndex(actual, index, newSymbol);
            boolean result = equalsListCharArray(actual, expected);
            assertTrue(result);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "replaceSymbolByIndexNegativeData")
    public Object[][] createReplaceSymbolByIndexNegativeData() {
        List<char[]> actual1 = new ArrayList<>();
        actual1.add(new char[]{'Я'});
        actual1.add(new char[]{'т', 'а', 'к'});
        actual1.add(new char[]{'о', 'ч', 'а', 'р', 'о', 'в', 'а', 'н'});
        actual1.add(new char[]{'п', 'р', 'е', 'л', 'е', 'с', 'т', 'я', 'м', 'и'});
        List<char[]> expected1 = new ArrayList<>();
        expected1.add(new char[]{'Я'});
        expected1.add(new char[]{'о', 'ч', 'а', 'р', 'о', 'А', 'а', 'н'});
        expected1.add(new char[]{'п', 'р', 'е', 'л', 'е', 'А', 'т', 'я', 'м', 'и'});
        List<char[]> actual2 = new ArrayList<>();
        actual2.add(new char[]{'Я'});
        actual2.add(new char[]{'о', 'ч', ' ', 'р', 'о', 'в', 'а', 'н'});
        actual2.add(new char[]{'п', 'р', 'е', 'л', 'е', 'с', 'т', 'я', 'м', 'и'});
        List<char[]> expected2 = new ArrayList<>();
        expected2.add(new char[]{'Я'});
        expected2.add(new char[]{'~', 'ч', 'а', 'р', 'о', 'в', 'а', 'н'});
        expected2.add(new char[]{'~', 'р', 'е', 'л', 'е', 'с', 'т', 'я', 'м', 'и'});
        List<char[]> actual3 = new ArrayList<>();
        actual3.add(new char[]{'Я'});
        List<char[]> expected3 = new ArrayList<>();
        expected3.add(new char[]{'Я'});
        expected3.add(new char[]{'Я'});
        return new Object[][]{
                {actual1, 5, 'А', expected1},
                {actual2, 0, '~', expected2},
                {actual3, 3, 'Т', expected3},
        };
    }

    @Test(dataProvider = "replaceSymbolByIndexNegativeData")
    public void replaceSymbolByIndexNegativeTest(List<char[]> actual, int index, char newSymbol, List<char[]> expected) {
        try {
            charChangeTextService.replaceSymbolByIndex(actual, index, newSymbol);
            boolean result = equalsListCharArray(actual, expected);
            assertFalse(result);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "replaceSymbolByIndexExceptionData")
    public Object[][] createReplaceSymbolByIndexExceptionData() {
        List<char[]> actual1 = new ArrayList<>();
        actual1.add(new char[]{'Я'});
        return new Object[][]{
                {null, 5, 'А'},
                {actual1, -1, '~'},
        };
    }

    @Test(dataProvider = "replaceSymbolByIndexExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void replaceSymbolByIndexExceptionTest(List<char[]> actual, int index, char newSymbol) throws IncorrectDataException {
        charChangeTextService.replaceSymbolByIndex(actual, index, newSymbol);
    }

    @DataProvider(name = "replaceSymbolByBeforeSymbolPositiveData")
    public Object[][] createReplaceSymbolByBeforeSymbolPositiveData() {
        List<char[]> actual1 = new ArrayList<>();
        actual1.add(new char[]{'Я'});
        actual1.add(new char[]{'т', 'а', 'к'});
        actual1.add(new char[]{'о', 'ч', 'а', 'р', 'о', 'в', 'а', 'а'});
        actual1.add(new char[]{'а', 'к', 'е', 'л', 'е', 'с', 'а', 'я', 'м', 'и'});
        List<char[]> expected1 = new ArrayList<>();
        expected1.add(new char[]{'Я'});
        expected1.add(new char[]{'т', 'а', 'Я'});
        expected1.add(new char[]{'о', 'ч', 'а', 'р', 'о', 'в', 'а', 'а'});
        expected1.add(new char[]{'а', 'Я', 'е', 'л', 'е', 'с', 'а', 'я', 'м', 'и'});
        List<char[]> actual2 = new ArrayList<>();
        actual2.add(new char[]{'Я'});
        actual2.add(new char[]{'о', 'k', ' ', 'р', 'о', 'в', 'а', 'н'});
        actual2.add(new char[]{'п', 'р', 'е', 'л', 'е', 'с', 'т', 'я', 'м', 'ч'});
        List<char[]> expected2 = new ArrayList<>();
        expected2.add(new char[]{'Я'});
        expected2.add(new char[]{'о', 'k', 'л', 'р', 'о', 'в', 'а', 'н'});
        expected2.add(new char[]{'п', 'р', 'е', 'л', 'е', 'с', 'т', 'я', 'м', 'ч'});
        List<char[]> actual3 = new ArrayList<>();
        actual3.add(new char[]{'Я'});
        List<char[]> expected3 = new ArrayList<>();
        expected3.add(new char[]{'Я'});
        return new Object[][]{
                {actual1, 'а', 'к', 'Я', expected1},
                {actual2, 'k', ' ', 'л', expected2},
                {actual3, 'Я', 'у', 'g', expected3},
        };
    }

    @Test(dataProvider = "replaceSymbolByBeforeSymbolPositiveData")
    public void replaceSymbolByBeforeSymbolPositiveTest(List<char[]> actual, char beforeSymbol, char oldSymbol, char newSymbol, List<char[]> expected) {
        try {
            charChangeTextService.replaceSymbolByBeforeSymbol(actual, beforeSymbol, oldSymbol, newSymbol);
            boolean result = equalsListCharArray(actual, expected);
            assertTrue(result);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "replaceSymbolByBeforeSymbolNegativeData")
    public Object[][] createReplaceSymbolByBeforeSymbolNegativeData() {
        List<char[]> actual1 = new ArrayList<>();
        actual1.add(new char[]{'Я'});
        actual1.add(new char[]{'т', 'а', 'к'});
        actual1.add(new char[]{'о', 'ч', 'а', 'р', 'о', 'в', 'а', 'а'});
        actual1.add(new char[]{'а', 'к', 'е', 'л', 'е', 'с', 'а', 'я', 'м', 'и'});
        List<char[]> expected1 = new ArrayList<>();
        expected1.add(new char[]{'Я'});
        expected1.add(new char[]{'т', 'а', 'Я'});
        expected1.add(new char[]{'о', 'ч', 'а', 'р', 'о', 'в', 'а', 'Я'});
        expected1.add(new char[]{'а', 'Я', 'е', 'л', 'е', 'с', 'а', 'я', 'м', 'и'});
        List<char[]> actual2 = new ArrayList<>();
        actual2.add(new char[]{'Я'});
        actual2.add(new char[]{'о', 'k', ' ', 'р', 'о', 'в', 'а', 'н'});
        actual2.add(new char[]{'п', 'р', 'е', 'л', 'е', 'с', 'т', 'я', 'м', 'ч'});
        List<char[]> expected2 = new ArrayList<>();
        expected2.add(new char[]{'Я'});
        expected2.add(new char[]{'о', 'k', ' ', 'р', 'о', 'в', 'а', 'н'});
        expected2.add(new char[]{'п', 'р', 'е', 'л', 'е', 'с', 'т', 'я', 'м', 'ч'});
        List<char[]> actual3 = new ArrayList<>();
        actual3.add(new char[]{'Я'});
        List<char[]> expected3 = new ArrayList<>();
        expected3.add(new char[]{'Я'});
        expected3.add(new char[]{'Я'});
        return new Object[][]{
                {actual1, 'а', 'к', 'Я', expected1},
                {actual2, 'k', ' ', 'л', expected2},
                {actual3, 'Я', 'у', 'g', expected3},
        };
    }

    @Test(dataProvider = "replaceSymbolByBeforeSymbolNegativeData")
    public void replaceSymbolByBeforeSymbolNegativeTest(List<char[]> actual, char beforeSymbol, char oldSymbol, char newSymbol, List<char[]> expected) {
        try {
            charChangeTextService.replaceSymbolByBeforeSymbol(actual, beforeSymbol, oldSymbol, newSymbol);
            boolean result = equalsListCharArray(actual, expected);
            assertFalse(result);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void replaceSymbolByBeforeSymbolExceptionTest() throws IncorrectDataException {
        List<char[]> actual = null;
        charChangeTextService.replaceSymbolByBeforeSymbol(actual, 'a', 'a', 'a');
    }

    @DataProvider(name = "replaceWordByLengthPositiveData")
    public Object[][] createReplaceWordByLengthPositiveData() {
        List<char[]> actual1 = new ArrayList<>();
        actual1.add(new char[]{'Я'});
        actual1.add(new char[]{'т', 'а', 'к'});
        actual1.add(new char[]{'о', 'ч', 'а', 'р', 'о', 'в', 'а', 'а'});
        actual1.add(new char[]{'а', 'к', 'е', 'л', 'е', 'с', 'а', 'я', 'м', 'и'});
        List<char[]> expected1 = new ArrayList<>();
        expected1.add(new char[]{'Я'});
        expected1.add(new char[]{' '});
        expected1.add(new char[]{'о', 'ч', 'а', 'р', 'о', 'в', 'а', 'а'});
        expected1.add(new char[]{'а', 'к', 'е', 'л', 'е', 'с', 'а', 'я', 'м', 'и'});
        List<char[]> actual2 = new ArrayList<>();
        actual2.add(new char[]{'Я'});
        actual2.add(new char[]{'о', 'k', ' ', 'р', 'о', 'в', 'а', 'н'});
        actual2.add(new char[]{'п', 'р', 'е', 'л', 'е', 'с', 'т', 'я'});
        List<char[]> expected2 = new ArrayList<>();
        expected2.add(new char[]{'Я'});
        expected2.add(new char[]{'т', 'а', 'к'});
        expected2.add(new char[]{'т', 'а', 'к'});
        List<char[]> actual3 = new ArrayList<>();
        actual3.add(new char[]{'Я'});
        List<char[]> expected3 = new ArrayList<>();
        expected3.add(new char[]{'Я'});
        return new Object[][]{
                {actual1, 3, new char[]{' '}, expected1},
                {actual2, 8, new char[]{'т', 'а', 'к'}, expected2},
                {actual3, 2, new char[]{'т', 'а', 'к'}, expected3},
        };
    }

    @Test(dataProvider = "replaceWordByLengthPositiveData")
    public void replaceWordByLengthPositiveTest(List<char[]> actual, int length, char[] newWord, List<char[]> expected) {
        try {
            charChangeTextService.replaceWordByLength(actual, length, newWord);
            boolean result = equalsListCharArray(actual, expected);
            assertTrue(result);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "replaceWordByLengthNegativeData")
    public Object[][] createReplaceWordByLengthNegativeData() {
        List<char[]> actual1 = new ArrayList<>();
        actual1.add(new char[]{'Я'});
        actual1.add(new char[]{'т', 'а', 'к'});
        actual1.add(new char[]{'о', 'ч', 'а', 'р', 'о', 'в', 'а', 'а'});
        actual1.add(new char[]{'а', 'к', 'е', 'л', 'е', 'с', 'а', 'я', 'м', 'и'});
        List<char[]> expected1 = new ArrayList<>();
        expected1.add(new char[]{'Я'});
        expected1.add(new char[]{' '});
        expected1.add(new char[]{'о', 'ч', 'а', 'р', 'о', 'в', 'а', 'а'});
        expected1.add(new char[]{'а', 'к', 'е', 'л', 'е', 'с', 'а', 'я', 'м', 'и'});
        List<char[]> actual2 = new ArrayList<>();
        actual2.add(new char[]{'Я'});
        actual2.add(new char[]{'п', 'р', 'е', 'л', 'е', 'с', 'т', 'я'});
        List<char[]> expected2 = new ArrayList<>();
        expected2.add(new char[]{'Я'});
        expected2.add(new char[]{'т', 'а', 'к'});
        expected2.add(new char[]{'т', 'а', 'к'});
        List<char[]> actual3 = new ArrayList<>();
        actual3.add(new char[]{'Я'});
        List<char[]> expected3 = new ArrayList<>();
        expected3.add(new char[]{'Я'});
        expected3.add(new char[]{'Я'});
        return new Object[][]{
                {actual1, 10, new char[]{' '}, expected1},
                {actual2, 8, new char[]{'т', 'а', 'к'}, expected2},
                {actual3, 2, new char[]{'т', 'а', 'к'}, expected3},
        };
    }


    @Test(dataProvider = "replaceWordByLengthNegativeData")
    public void replaceWordByLengthNegativeTest(List<char[]> actual, int length, char[] newWord, List<char[]> expected) {
        try {
            charChangeTextService.replaceWordByLength(actual, length, newWord);
            boolean result = equalsListCharArray(actual, expected);
            assertFalse(result);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "replaceWordByLengthExceptionData")
    public Object[][] createReplaceWordByLengthExceptionData() {
        List<char[]> actual1 = new ArrayList<>();
        actual1.add(new char[]{'Я'});
        List<char[]> actual2 = new ArrayList<>();
        return new Object[][]{
                {null, 5, new char[]{'a'}},
                {actual1, -1, new char[]{}},
                {actual2, 1, null},
        };
    }

    @Test(dataProvider = "replaceWordByLengthExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void replaceWordByLengthExceptionTest(List<char[]> actual, int length, char[] newWord) throws IncorrectDataException {
        charChangeTextService.replaceWordByLength(actual, length, newWord);
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
