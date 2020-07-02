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

    @Test
    public void testParseListToString() {
    }

    @DataProvider(name = "parseParagraphListToWordListPositiveData")
    public Object[][] createParseParagraphListToWordListPositiveData() {
        List<String> paragraphText1 = new ArrayList<>();
        paragraphText1.add("Hello, world");
        paragraphText1.add("Привет   мир!");
        paragraphText1.add("      ");
        paragraphText1.add("   Пока1. Пока2!   Пока...   ");
        List<String> expected1 = new ArrayList<>();
        expected1.add("Hello");
        expected1.add("world");
        expected1.add("Привет");
        expected1.add("мир");
        expected1.add("Пока1");
        expected1.add("Пока2");
        expected1.add("Пока");
        List<String> paragraphText2 = new ArrayList<String>();
        paragraphText2.add("NONE,,,,,,,.....OF");
        paragraphText2.add(" Hello ");
        List<String> expected2 = new ArrayList<>();
        expected2.add("NONE");
        expected2.add("OF");
        expected2.add("Hello");
        List<String> paragraphText3 = new ArrayList<>();
        paragraphText3.add("ктонибудь");
        paragraphText3.add("NONE,,,,,,,.....OF\n");
        paragraphText3.add(" Hello ");
        List<String> expected3 = new ArrayList<>();
        expected3.add("ктонибудь");
        expected3.add("NONE");
        expected3.add("OF");
        expected3.add("Hello");
        return new Object[][]{
                {paragraphText1, expected1},
                {paragraphText2, expected2},
                {paragraphText3, expected3},
        };
    }

    @Test(dataProvider = "parseParagraphListToWordListPositiveData")
    public void parseParagraphListToWordListPositiveTest(List<String> paragraphText, List<String> expected) {
        try {
            List<String> actual = stringParser.parseParagraphListToWordList(paragraphText);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect data");
        }
    }

    @DataProvider(name = "parseParagraphListToWordListNegativeData")
    public Object[][] createParseParagraphListToWordListNegativeData() {
        List<String> paragraphText1 = new ArrayList<>();
        paragraphText1.add("Hello, world");
        paragraphText1.add("Привет   мир!");
        paragraphText1.add("   Пока. Пока!   Пока...   ");
        List<String> expected1 = new ArrayList<>();
        expected1.add("Hello");
        List<String> paragraphText2 = new ArrayList<>();
        paragraphText2.add("NONE,,,,,,,.....OF");
        paragraphText2.add(" Hello ");
        List<String> expected2 = new ArrayList<>();
        expected2.add("NONE");
        expected2.add("OF1");
        List<String> paragraphText3 = new ArrayList<>();
        paragraphText3.add("NONE,,,,,,,.....OF\n");
        paragraphText3.add(" Hello ");
        List<String> expected3 = new ArrayList<>();
        expected3.add("NONE");
        return new Object[][]{
                {paragraphText1, expected1},
                {paragraphText2, expected2},
                {paragraphText3, expected3},
        };
    }

    @Test(dataProvider = "parseParagraphListToWordListNegativeData")
    public void parseParagraphListToWordListNegativeTest(List<String> paragraphText, List<String> expected) {
        try {
            List<String> actual = stringParser.parseParagraphListToWordList(paragraphText);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect data");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void parseParagraphsListToWordsListExceptionTest() throws IncorrectDataException {
        List<String> paragraphText = null;
        stringParser.parseParagraphListToWordList(paragraphText);
    }
}
