package test.borikov.day5.parser;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.parser.StringParser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class StringParserTest {
    StringParser stringParser;

    @BeforeClass
    public void setUp() {
        stringParser = new StringParser();
    }

    @AfterClass
    public void tearDown() {
        stringParser = null;
    }

    @DataProvider(name = "parseTextToWordListPositiveData")
    public Object[][] createParseTextToWordListPositiveData() {
        String text1 = "Hello, world Привет   мир! \nПривет" +
                "   мир! ,.! Пока1. Пока2!   Пока...   ";
        List<String> expected1 = new ArrayList<>();
        expected1.add("Hello");
        expected1.add("world");
        expected1.add("Привет");
        expected1.add("мир");
        expected1.add("Привет");
        expected1.add("мир");
        expected1.add("Пока1");
        expected1.add("Пока2");
        expected1.add("Пока");
        String text2 = "нет да \n\n\n\n\t\t!`~net,,,,da";
        List<String> expected2 = new ArrayList<>();
        expected2.add("нет");
        expected2.add("да");
        expected2.add("net");
        expected2.add("da");
        String text3 = "###,  !#\t\t!`~,,,,";
        List<String> expected3 = new ArrayList<>();
        return new Object[][]{
                {text1, expected1},
                {text2, expected2},
                {text3, expected3}
        };
    }

    @Test(dataProvider = "parseTextToWordListPositiveData")
    public void parseTextToWordListPositiveTest(
            String text, List<String> expected) {
        try {
            List<String> actual = stringParser.parseTextToWordList(text);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect data");
        }
    }

    @DataProvider(name = "parseTextToWordListNegativeData")
    public Object[][] createParseTextToWordListNegativeData() {
        String text1 = "Hello, world Привет   мир! \nПривет " +
                "  мир! ,.! Пока1. Пока2!   Пока...   ";
        List<String> expected1 = new ArrayList<>();
        expected1.add("Hello");
        expected1.add("world");
        expected1.add("Привет");
        expected1.add("мир");
        expected1.add("Привет");
        expected1.add("мир");
        expected1.add("Пока1");
        expected1.add("Пока1");
        expected1.add("Пока2");
        expected1.add("Пока");
        String text2 = "нет да \n\n\n\n\t\t!`~net,,,,da";
        List<String> expected2 = new ArrayList<>();
        expected2.add("нет");
        expected2.add("net");
        expected2.add("da");
        String text3 = "###,  !#\t\t!`~,,,,";
        List<String> expected3 = new ArrayList<>();
        expected3.add("");
        return new Object[][]{
                {text1, expected1},
                {text2, expected2},
                {text3, expected3}
        };
    }

    @Test(dataProvider = "parseTextToWordListNegativeData")
    public void parseTextToWordListNegativeTest(
            String text, List<String> expected) {
        try {
            List<String> actual = stringParser.parseTextToWordList(text);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect data");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void parseTextToWordListExceptionData()
            throws IncorrectDataException {
        String text = null;
        stringParser.parseTextToWordList(text);
    }
}
