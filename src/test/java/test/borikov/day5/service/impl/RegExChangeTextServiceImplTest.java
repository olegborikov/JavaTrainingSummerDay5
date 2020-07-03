package test.borikov.day5.service.impl;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.service.impl.RegExChangeTextServiceImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class RegExChangeTextServiceImplTest {
    RegExChangeTextServiceImpl regExChangeTextService;

    @BeforeClass
    public void setUp() {
        regExChangeTextService = new RegExChangeTextServiceImpl();
    }

    @AfterClass
    public void tearDown() {
        regExChangeTextService = null;
    }

    @DataProvider(name = "replaceSymbolByPositionPositiveData")
    public Object[][] createReplaceSymbolByPositionPositiveData() {
        List<String> actual1 = new ArrayList<>();
        actual1.add("Я");
        actual1.add("так");
        actual1.add("очарован");
        actual1.add("прелестями");
        List<String> expected1 = new ArrayList<>();
        expected1.add("Я");
        expected1.add("так");
        expected1.add("очарАван");
        expected1.add("прелАстями");
        List<String> actual2 = new ArrayList<>();
        actual2.add("Я");
        actual2.add("очарован");
        actual2.add("прелестями");
        List<String> expected2 = new ArrayList<>();
        expected2.add("~");
        expected2.add("~чарован");
        expected2.add("~релестями");
        List<String> actual3 = new ArrayList<>();
        List<String> expected3 = new ArrayList<>();
        return new Object[][]{
                {actual1, 5, 'А', expected1},
                {actual2, 1, '~', expected2},
                {actual3, 3, 'Т', expected3},
        };
    }

    @Test(dataProvider = "replaceSymbolByPositionPositiveData")
    public void replaceSymbolByIndexPositiveTest(List<String> actual, int position,
                                                 char newSymbol,
                                                 List<String> expected) {
        try {
            regExChangeTextService.replaceSymbolByPosition(actual, position, newSymbol);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "replaceSymbolByPositionNegativeData")
    public Object[][] createReplaceSymbolByPositionNegativeData() {
        List<String> actual1 = new ArrayList<>();
        actual1.add("Я");
        actual1.add("так");
        actual1.add("");
        actual1.add("очарован1");
        actual1.add("прелестями");
        List<String> expected1 = new ArrayList<>();
        expected1.add("Я");
        expected1.add("так");
        expected1.add(" ");
        expected1.add("очароАан1");
        expected1.add("прелеАтями");
        List<String> actual2 = new ArrayList<>();
        actual2.add("Я");
        actual2.add("очарован");
        actual2.add("прелестями");
        List<String> expected2 = new ArrayList<>();
        expected2.add("Я");
        expected2.add("~чарован");
        expected2.add("~релестями");
        List<String> actual3 = new ArrayList<>();
        List<String> expected3 = new ArrayList<>();
        expected3.add("так");
        return new Object[][]{
                {actual1, 5, 'А', expected1},
                {actual2, 1, '~', expected2},
                {actual3, 3, 'Т', expected3},
        };
    }

    @Test(dataProvider = "replaceSymbolByPositionNegativeData")
    public void replaceSymbolByPositionNegativeTest(List<String> actual, int position,
                                                    char newSymbol,
                                                    List<String> expected) {
        try {
            regExChangeTextService.replaceSymbolByPosition(actual, position, newSymbol);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "replaceSymbolByIndexExceptionData")
    public Object[][] createReplaceSymbolByIndexExceptionData() {
        List<String> actual1 = new ArrayList<>();
        actual1.add("Я");
        return new Object[][]{
                {null, 5, 'А'},
                {actual1, -1, '~'},
        };
    }

    @Test(dataProvider = "replaceSymbolByIndexExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void replaceSymbolByIndexExceptionTest(List<String> actual, int position,
                                                  char newSymbol)
            throws IncorrectDataException {
        regExChangeTextService.replaceSymbolByPosition(actual, position, newSymbol);
    }

    @DataProvider(name = "replaceSymbolByBeforeSymbolPositiveData")
    public Object[][] createReplaceSymbolByBeforeSymbolPositiveData() {
        List<String> actual1 = new ArrayList<>();
        actual1.add("Я");
        actual1.add("такак");
        actual1.add("очаровая");
        actual1.add("акелестямиа");
        List<String> expected1 = new ArrayList<>();
        expected1.add("Я");
        expected1.add("таЯаЯ");
        expected1.add("очаровая");
        expected1.add("аЯелестямиа");
        List<String> actual2 = new ArrayList<>();
        actual2.add("Я");
        actual2.add("оk рован");
        actual2.add("прелестямч");
        List<String> expected2 = new ArrayList<>();
        expected2.add("Я");
        expected2.add("оkлрован");
        expected2.add("прелестямч");
        List<String> actual3 = new ArrayList<>();
        List<String> expected3 = new ArrayList<>();
        return new Object[][]{
                {actual1, 'а', 'к', 'Я', expected1},
                {actual2, 'k', ' ', 'л', expected2},
                {actual3, 'Я', 'у', 'g', expected3},
        };
    }

    @Test(dataProvider = "replaceSymbolByBeforeSymbolPositiveData")
    public void replaceSymbolByBeforeSymbolPositiveTest(List<String> actual,
                                                        char beforeSymbol,
                                                        char oldSymbol,
                                                        char newSymbol,
                                                        List<String> expected) {
        try {
            regExChangeTextService.replaceSymbolByBeforeSymbol(actual,
                    beforeSymbol, oldSymbol, newSymbol);
            System.out.println(actual);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "replaceSymbolByBeforeSymbolNegativeData")
    public Object[][] createReplaceSymbolByBeforeSymbolNegativeData() {
        List<String> actual1 = new ArrayList<>();
        actual1.add("Я");
        actual1.add("так");
        actual1.add("очаровая");
        actual1.add("акелестями");
        List<String> expected1 = new ArrayList<>();
        expected1.add("Я");
        expected1.add(" ");
        expected1.add("очаровая");
        expected1.add("аЯелестями");
        List<String> actual2 = new ArrayList<>();
        actual2.add("Я");
        actual2.add("оk рован");
        actual2.add("прелестямч");
        List<String> expected2 = new ArrayList<>();
        expected2.add("Я");
        expected2.add("оk рован");
        expected2.add("прелестямч");
        List<String> actual3 = new ArrayList<>();
        List<String> expected3 = new ArrayList<>();
        expected3.add("Я");
        return new Object[][]{
                {actual1, 'а', 'к', 'Я', expected1},
                {actual2, 'k', ' ', 'л', expected2},
                {actual3, 'Я', 'у', 'g', expected3},
        };
    }

    @Test(dataProvider = "replaceSymbolByBeforeSymbolNegativeData")
    public void replaceSymbolByBeforeSymbolNegativeTest(List<String> actual,
                                                        char beforeSymbol,
                                                        char oldSymbol,
                                                        char newSymbol,
                                                        List<String> expected) {
        try {
            regExChangeTextService.replaceSymbolByBeforeSymbol(actual,
                    beforeSymbol, oldSymbol, newSymbol);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void replaceSymbolByBeforeSymbolExceptionTest()
            throws IncorrectDataException {
        List<String> actual = null;
        regExChangeTextService.replaceSymbolByBeforeSymbol(actual, 'a', 'a', 'a');
    }

    @DataProvider(name = "replaceWordByLengthPositiveData")
    public Object[][] createReplaceWordByLengthPositiveData() {
        List<String> actual1 = new ArrayList<>();
        actual1.add("Я");
        actual1.add("так");
        actual1.add("очаровая");
        actual1.add("акелестями");
        List<String> expected1 = new ArrayList<>();
        expected1.add("Я");
        expected1.add(" ");
        expected1.add("очаровая");
        expected1.add("акелестями");
        List<String> actual2 = new ArrayList<>();
        actual2.add("Я");
        actual2.add("оkроваjн");
        actual2.add("прелестя");
        List<String> expected2 = new ArrayList<>();
        expected2.add("Я");
        expected2.add("так");
        expected2.add("так");
        List<String> actual3 = new ArrayList<>();
        actual3.add("Я");
        List<String> expected3 = new ArrayList<>();
        expected3.add("Я");
        return new Object[][]{
                {actual1, 3, " ", expected1},
                {actual2, 8, "так", expected2},
                {actual3, 2, "так", expected3},
        };
    }

    @Test(dataProvider = "replaceWordByLengthPositiveData")
    public void replaceWordByLengthPositiveTest(List<String> actual, int length,
                                                String newWord,
                                                List<String> expected) {
        try {
            regExChangeTextService.replaceWordByLength(actual, length, newWord);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "replaceWordByLengthNegativeData")
    public Object[][] createReplaceWordByLengthNegativeData() {
        List<String> actual1 = new ArrayList<>();
        actual1.add("Я");
        actual1.add("так");
        actual1.add("очаровая");
        actual1.add("акелестями");
        List<String> expected1 = new ArrayList<>();
        expected1.add("Я");
        expected1.add("р");
        expected1.add("очаровая");
        expected1.add("акелестями");
        List<String> actual2 = new ArrayList<>();
        actual2.add("Я");
        actual2.add("оk рован");
        actual2.add("прелестя");
        List<String> expected2 = new ArrayList<>();
        expected2.add("Я");
        expected2.add("так");
        expected2.add(" ");
        List<String> actual3 = new ArrayList<>();
        actual3.add("Я");
        List<String> expected3 = new ArrayList<>();
        expected3.add("Я");
        expected3.add("Я");
        return new Object[][]{
                {actual1, 3, " ", expected1},
                {actual2, 8, "так", expected2},
                {actual3, 2, "так", expected3},
        };
    }

    @Test(dataProvider = "replaceWordByLengthNegativeData")
    public void replaceWordByLengthNegativeTest(List<String> actual, int length,
                                                String newWord,
                                                List<String> expected) {
        try {
            regExChangeTextService.replaceWordByLength(actual, length, newWord);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "replaceWordByLengthExceptionData")
    public Object[][] createReplaceWordByLengthExceptionData() {
        List<String> actual1 = new ArrayList<>();
        actual1.add("Я");
        List<char[]> actual2 = new ArrayList<>();
        return new Object[][]{
                {null, 5, "а"},
                {actual1, -1, ""},
                {actual2, 1, null},
        };
    }

    @Test(dataProvider = "replaceWordByLengthExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void replaceWordByLengthExceptionTest(List<String> actual, int length,
                                                 String newWord)
            throws IncorrectDataException {
        regExChangeTextService.replaceWordByLength(actual, length, newWord);
    }
}
