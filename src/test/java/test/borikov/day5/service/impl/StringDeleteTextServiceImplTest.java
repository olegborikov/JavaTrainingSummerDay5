package test.borikov.day5.service.impl;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.service.impl.StringDeleteTextServiceImpl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class StringDeleteTextServiceImplTest {
    StringDeleteTextServiceImpl stringDeleteTextService;

    @BeforeMethod
    public void setUp() {
        stringDeleteTextService = new StringDeleteTextServiceImpl();
    }

    @AfterMethod
    public void tearDown() {
        stringDeleteTextService = null;
    }

    @DataProvider(name = "deletePunctuationPositiveData")
    public Object[][] createDeletePunctuationPositiveData() {
        String actual1 = "asd'gfdg_-";
        String expected1 = "asd gfdg  ";
        String actual2 = "aVРукЁ~~~, ,hgf";
        String expected2 = "aVРукЁ      hgf";
        String actual3 = "—";
        String expected3 = " ";
        return new Object[][]{
                {actual1, expected1},
                {actual2, expected2},
                {actual3, expected3},
        };
    }

    @Test(dataProvider = "deletePunctuationPositiveData")
    public void deletePunctuationPositiveTest(String text, String expected) {
        try {
            String actual = stringDeleteTextService.deletePunctuation(text);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "deletePunctuationNegativeData")
    public Object[][] createDeletePunctuationNegativeData() {
        String actual1 = "asd'gfdg_-";
        String expected1 = "asdgfdg";
        String actual2 = "aVРукЁ~~~, ,hgf";
        String expected2 = "aVРукЁ     hgf";
        String actual3 = "—";
        String expected3 = "";
        return new Object[][]{
                {actual1, expected1},
                {actual2, expected2},
                {actual3, expected3},
        };
    }

    @Test(dataProvider = "deletePunctuationNegativeData")
    public void deletePunctuationNegativeTest(String text, String expected) {
        try {
            String actual = stringDeleteTextService.deletePunctuation(text);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void deletePunctuationExceptionTest() throws IncorrectDataException {
        String text = null;
        stringDeleteTextService.deletePunctuation(text);
    }

    @DataProvider(name = "deleteWordByLengthAndFirstLetterPositiveData")
    public Object[][] createDeleteWordByLengthAndFirstLetterPositiveData() {
        List<String> actual1 = new ArrayList<>();
        actual1.add("Я");
        actual1.add("так");
        actual1.add("оча");
        actual1.add("аке");
        List<String> expected1 = new ArrayList<>();
        expected1.add("Я");
        expected1.add("так");
        List<String> actual2 = new ArrayList<>();
        actual2.add("gfdgdf");
        actual2.add("Ёавы");
        actual2.add("Павы");
        actual2.add("УКйв");
        actual2.add("Wads");
        List<String> expected2 = new ArrayList<>();
        expected2.add("gfdgdf");
        expected2.add("Ёавы");
        expected2.add("УКйв");
        List<String> actual3 = new ArrayList<>();
        actual3.add("Я");
        List<String> expected3 = new ArrayList<>();
        expected3.add("Я");
        return new Object[][]{
                {actual1, 3, true, expected1},
                {actual2, 4, false, expected2},
                {actual3, 2, false, expected3},
        };
    }

    @Test(dataProvider = "deleteWordByLengthAndFirstLetterPositiveData")
    public void deleteWordByLengthAndFirstLetterPositiveTest(List<String> actual, int length, boolean isFirstLetterVowel, List<String> expected) {
        try {
            stringDeleteTextService.deleteWordByLengthAndFirstLetter(actual, length, isFirstLetterVowel);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

     @DataProvider(name = "deleteWordByLengthAndFirstLetterNegativeData")
    public Object[][] createDeleteWordByLengthAndFirstLetterNegativeData() {
       List<String> actual1 = new ArrayList<>();
        actual1.add("3ча");
        actual1.add("аке");
        List<String> expected1 = new ArrayList<>();
        List<String> actual2 = new ArrayList<>();
        actual2.add("gfdgdf");
        actual2.add("Ёавы");
        actual2.add("Павы");
        actual2.add("УКйв");
        actual2.add("Wads");
        List<String> expected2 = new ArrayList<>();
        expected2.add("gfdgdf");
        expected2.add("УКйв");
        List<String> actual3 = new ArrayList<>();
        actual3.add("Я");
        List<String> expected3 = new ArrayList<>();
        expected3.add(" ");
        return new Object[][]{
                {actual1, 3, true, expected1},
                {actual2, 4, false, expected2},
                {actual3, 2, false, expected3},
        };
    }

    @Test(dataProvider = "deleteWordByLengthAndFirstLetterNegativeData")
    public void deleteWordByLengthAndFirstLetterNegativeTest(List<String> actual, int length, boolean isFirstLetterVowel, List<String> expected) {
        try {
            stringDeleteTextService.deleteWordByLengthAndFirstLetter(actual, length, isFirstLetterVowel);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "deleteWordByLengthAndFirstLetterExceptionData")
    public Object[][] createDeleteWordByLengthAndFirstLetterExceptionData() {
        List<String> actual1 = new ArrayList<>();
        return new Object[][]{
                {null, 1, false},
                {actual1, -5, false},
        };
    }

    @Test(dataProvider = "deleteWordByLengthAndFirstLetterExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void deleteWordByLengthAndFirstLetterExceptionTest(List<String> actual, int length, boolean isFirstLetterVowel) throws IncorrectDataException {
        stringDeleteTextService.deleteWordByLengthAndFirstLetter(actual, length, isFirstLetterVowel);
    }
}
