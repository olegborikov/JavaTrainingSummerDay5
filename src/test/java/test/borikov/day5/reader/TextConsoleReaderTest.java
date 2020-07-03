package test.borikov.day5.reader;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.reader.TextConsoleReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.testng.Assert.*;

public class TextConsoleReaderTest {
    TextConsoleReader textConsoleReader;

    @BeforeClass
    public void setUp() {
        textConsoleReader = new TextConsoleReader();
    }

    @AfterClass
    public void tearDown() {
        textConsoleReader = null;
    }

    @DataProvider(name = "readTextPositiveData")
    public Object[][] createReadTextPositiveData() {
        return new Object[][]{
                {"abc", "abc"},
                {" ", " "},
                {"wesfsdfdsf,!fsdfgs\\321", "wesfsdfdsf,!fsdfgs\\321"}
        };
    }

    @Test(dataProvider = "readTextPositiveData")
    public void readTextPositiveTest(String data, String expected) {
        try {
            InputStream inputData = new ByteArrayInputStream(data.getBytes());
            String actual = textConsoleReader.readText(inputData);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "readTextNegativeData")
    public Object[][] createReadTextNegativeData() {
        return new Object[][]{
                {"abc", "ac"},
                {" ", " d"},
                {"wesfsdfdsf,!gs\\321", "wesfsdfdsf,!fsdfgs\\321"}
        };
    }

    @Test(dataProvider = "readTextNegativeData")
    public void readTextNegativeTest(String data, String expected) {
        try {
            InputStream inputData = new ByteArrayInputStream(data.getBytes());
            String actual = textConsoleReader.readText(inputData);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void readTextExceptionTest() throws IncorrectDataException {
        InputStream inputData = null;
        textConsoleReader.readText(inputData);
    }
}
