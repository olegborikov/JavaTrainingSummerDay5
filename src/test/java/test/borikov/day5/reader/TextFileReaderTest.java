package test.borikov.day5.reader;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.reader.TextFileReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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
        List<String> defaultDataText = new ArrayList<>();
        defaultDataText.add("— Я так очарован прелестями ума и образования общества, в особенности женского.");
        defaultDataText.add("Анна Павловна для удобства наблюдения присоединила их к общему кружку.");
        defaultDataText.add("В это время в гостиную вошло какое-то новое лицо.");
        defaultDataText.add("Here you can find activities to practise your reading skills.");
        List<String> validDataText = new ArrayList<>();
        validDataText.add("— Я как-то очаро3ван прелестями,, ума и образования общ2ества.");
        validDataText.add("  Here you can find activities to practise your reading s3kills.");
        validDataText.add("Reading will help you to imp3-rove   the language and -build your voca6bulary.");
        List<String> invalidDataText = new ArrayList<>();
        return new Object[][]{
                {null, defaultDataText},
                {"input/validData.txt", validDataText},
                {"input/invalidData.txt", invalidDataText},
        };
    }

    @Test(dataProvider = "readTextPositiveData")
    public void readTextPositiveTest(String file, List<String> expected) {
        try {
            List<String> actual = textFileReader.readText(file);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "readTextNegativeData")
    public Object[][] createReadTextNegativeData() {
        List<String> defaultDataText = new ArrayList<>();
        defaultDataText.add("— Я так очарован прелестями ума и образования общества, в особенности женского.");
        List<String> validDataText = new ArrayList<>();
        validDataText.add("Reading will help you to imp3-rove   the language and -build your voca6bulary.");
        List<String> invalidDataText = new ArrayList<>();
        invalidDataText.add("— Я так очарован прелестями ума и образования общества, в особенности женского.");
        return new Object[][]{
                {null, defaultDataText},
                {"input/validData.txt", validDataText},
                {"input/invalidData.txt", invalidDataText},
        };
    }

    @Test(dataProvider = "readTextNegativeData")
    public void readTextNegativeTest(String file, List<String> expected) {
        try {
            List<String> actual = textFileReader.readText(file);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }
}
