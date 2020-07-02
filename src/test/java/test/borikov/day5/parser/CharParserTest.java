package test.borikov.day5.parser;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.parser.CharParser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CharParserTest {
    CharParser charParser;

    @BeforeClass
    public void setUp() {
        charParser = new CharParser();
    }

    @AfterClass
    public void tearDown() {
        charParser = null;
    }

    @DataProvider(name = "parseTextToWordCharListPositiveData")
    public Object[][] createParseTextToWordCharListPositiveData() {
        String text1 = "Hello, world Привет   мир! \nПривет  " +
                " мир! ,.! Пока1. Пока2!   Пока...   ";
        List<char[]> expected1 = new ArrayList<>();
        expected1.add(new char[]{'H', 'e', 'l', 'l', 'o'});
        expected1.add(new char[]{'w', 'o', 'r', 'l', 'd'});
        expected1.add(new char[]{'П', 'р', 'и', 'в', 'е', 'т'});
        expected1.add(new char[]{'м', 'и', 'р'});
        expected1.add(new char[]{'П', 'р', 'и', 'в', 'е', 'т'});
        expected1.add(new char[]{'м', 'и', 'р'});
        expected1.add(new char[]{'П', 'о', 'к', 'а', '1'});
        expected1.add(new char[]{'П', 'о', 'к', 'а', '2'});
        expected1.add(new char[]{'П', 'о', 'к', 'а'});
        String text2 = "нет да \n\n\n\n\t\t!`~net,,,,da";
        List<char[]> expected2 = new ArrayList<>();
        expected2.add(new char[]{'н', 'е', 'т'});
        expected2.add(new char[]{'д', 'а'});
        expected2.add(new char[]{'n', 'e', 't'});
        expected2.add(new char[]{'d', 'a'});
        String text3 = "###,  !#\t\t!`~,,,,";
        List<char[]> expected3 = new ArrayList<>();
        return new Object[][]{
                {text1, expected1},
                {text2, expected2},
                {text3, expected3}
        };
    }

    @Test(dataProvider = "parseTextToWordCharListPositiveData")
    public void parseTextToWordCharListPositiveTest(
            String text, List<char[]> expected) {
        try {
            List<char[]> actual = charParser.parseTextToWordCharList(text);
            boolean result = equalsListCharArray(actual, expected);
            assertTrue(result);
        } catch (IncorrectDataException e) {
            fail("incorrect data");
        }
    }

    @DataProvider(name = "parseTextToWordCharListNegativeData")
    public Object[][] createParseTextToWordCharListNegativeData() {
        String text1 = "Hello, world Привет   мир! \nПривет " +
                "  мир! ,.! Пока1. Пока2!   Пока...   ";
        List<char[]> expected1 = new ArrayList<>();
        expected1.add(new char[]{'H', 'e', 'l', 'l', 'o'});
        expected1.add(new char[]{'w', 'o', 'r', 'l', 'd'});
        expected1.add(new char[]{'П', 'р', 'и', 'в', 'е', ' '});
        expected1.add(new char[]{'м', 'и', 'р'});
        expected1.add(new char[]{'П', 'р', 'и', 'в', 'е', 'т'});
        expected1.add(new char[]{'м', 'и', 'р'});
        expected1.add(new char[]{'П', 'о', 'к', 'а', '1'});
        expected1.add(new char[]{'П', 'о', 'к', 'а', '2'});
        expected1.add(new char[]{'П', 'о', 'к', 'а'});
        String text2 = "нет да \n\n\n\n\t\t!`~net,,,,da";
        List<char[]> expected2 = new ArrayList<>();
        expected2.add(new char[]{'н', 'е', 'т'});
        expected2.add(new char[]{'д', 'а'});
        expected2.add(new char[]{'n', 'e', 't'});
        String text3 = "###,  !#\t\t!`~,,,,";
        List<char[]> expected3 = new ArrayList<>();
        expected3.add(new char[]{});
        return new Object[][]{
                {text1, expected1},
                {text2, expected2},
                {text3, expected3}
        };
    }

    @Test(dataProvider = "parseTextToWordCharListNegativeData")
    public void parseTextToWordCharListNegativeTest(
            String text, List<char[]> expected) {
        try {
            List<char[]> actual = charParser.parseTextToWordCharList(text);
            boolean result = equalsListCharArray(actual, expected);
            assertFalse(result);
        } catch (IncorrectDataException e) {
            fail("incorrect data");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void parseParagraphListToWordCharListExceptionTest()
            throws IncorrectDataException {
        String text = null;
        charParser.parseTextToWordCharList(text);
    }

    private boolean equalsListCharArray(List<char[]> firstCharList,
                                        List<char[]> secondCharList) {
        boolean result = true;
        if (firstCharList == null || secondCharList == null
                | firstCharList.size() != secondCharList.size()) {
            result = false;
        } else {
            for (int i = 0; i < firstCharList.size(); i++) {
                if (!result) {
                    break;
                }
                if (firstCharList.get(i).length != secondCharList.get(i).length) {
                    result = false;
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
