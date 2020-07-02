package test.borikov.day5.reader;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.reader.TextFileReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TextFileReaderTest {
    TextFileReader textFileReader;

    @BeforeClass
    public void setUp() {
        textFileReader = new TextFileReader();
    }

    @AfterClass
    public void tearDown() {
        textFileReader = null;
    }

    @DataProvider(name = "readTextPositiveData")
    public Object[][] createReadTextPositiveData() {
        String defaultDataText = "— Я так очарован прелестями ума и образования " +
                "общества, в особенности женского.\n" +
                "Here you can find activities to practise your reading skills.";
        String validDataText = "— Я как-то очаро3ван прелестями,, ума и" +
                " образования общ2ества.\n" +
                " Reading will help you to imp3-rove   the language" +
                " and -build your voca6bulary.";
        return new Object[][]{
                {null, defaultDataText},
                {"input/validData.txt", validDataText}
        };
    }

    @Test(dataProvider = "readTextPositiveData")
    public void readTextPositiveTest(String fileName, String expected) {
        try {
            String actual = textFileReader.readText(fileName);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "readTextNegativeData")
    public Object[][] createReadTextNegativeData() {
        String defaultDataText = "—Я так очарован прелестями ума и " +
                "образования общества, в особенности женского.\n" +
                "Here you can find activities to practise your reading skills.\n";
        String validDataText = "— Я как-то очаро3ван прелестями,, ума" +
                " и образования общ2ества.\n" +
                " Reading will help you to imp3-rove  the language " +
                "and -build your voca6bulary.\n";
        return new Object[][]{
                {null, defaultDataText},
                {"input/validData.txt", validDataText},
        };
    }

    @Test(dataProvider = "readTextNegativeData")
    public void readTextNegativeTest(String fileName, String expected) {
        try {
            String actual = textFileReader.readText(fileName);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }
}
