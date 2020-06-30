package test.borikov.day5.validator;

import com.borikov.day5.validator.StringValidator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class StringValidatorTest {
    StringValidator stringValidator;

    @BeforeClass
    public void setUp() {
        stringValidator = new StringValidator();
    }

    @AfterClass
    public void tearDown() {
        stringValidator = null;
    }

    @DataProvider(name = "isStringEmptyPositiveData")
    public Object[][] createIsStringEmptyPositiveData() {
        return new Object[][]{
                {"123dsa"},
                {"1"},
                {"gf-[['"},
        };
    }

    @Test(dataProvider = "isStringEmptyPositiveData")
    public void isStringEmptyPositiveTest(String line) {
        boolean actual = stringValidator.isStringEmpty(line);
        assertFalse(actual);
    }

    @DataProvider(name = "isStringEmptyNegativeData")
    public Object[][] createIsStringEmptyNegativeData() {
        return new Object[][]{
                {""},
                {"    "},
                {null},
        };
    }

    @Test(dataProvider = "isStringEmptyNegativeData")
    public void isStringEmptyNegativeTest(String line) {
        boolean actual = stringValidator.isStringEmpty(line);
        assertTrue(actual);
    }


    @DataProvider(name = "isStringListEmptyPositiveData")
    public Object[][] createIsStringListEmptyPositiveData() {
        List<String> data1 = new ArrayList<>();
        data1.add("qwerty");
        data1.add("World321");
        List<String> data2 = new ArrayList<>();
        data2.add(",,,,[]");
        List<String> data3 = new ArrayList<>();
        data3.add("Ad312");
        data3.add("23213");
        data3.add("\\kll;p]p[");
        return new Object[][]{
                {data1},
                {data2},
                {data3},
        };
    }

    @Test(dataProvider = "isStringListEmptyPositiveData")
    public void isStringListEmptyPositiveTest(List<String> lines) {
        boolean actual = stringValidator.isStringListEmpty(lines);
        assertFalse(actual);
    }

    @DataProvider(name = "isStringListEmptyNegativeData")
    public Object[][] createIsStringListEmptyNegativeData() {
        List<String> data1 = new ArrayList<>();
        List<String> data2 = new ArrayList<>();
        data2.add(",,,,[]");
        data2.add(" ");
        List<String> data3 = new ArrayList<>();
        data3.add("Ad312");
        data3.add("");
        data3.add("\\kll;p]p[");
        return new Object[][]{
                {data1},
                {data2},
                {data3},
        };
    }

    @Test(dataProvider = "isStringListEmptyNegativeData")
    public void isStringListEmptyNegativeTest(List<String> lines) {
        boolean actual = stringValidator.isStringListEmpty(lines);
        assertTrue(actual);
    }
}
