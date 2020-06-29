package test.borikov.day5.service;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.service.StringService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

public class StringServiceTest {
    StringService stringService;

    @BeforeClass
    public void setUp() {
        stringService = new StringService();
    }

    @AfterClass
    public void tearDown() {
        stringService = null;
    }

    @Test
    public void replaceSymbolStringTest() throws IncorrectDataException {
        List<String> words = new ArrayList<>();
        words.add("Hel");
        words.add("worljjj");
        stringService.replaceWordWithSubstringString(words, "Hel", "123");
        System.out.println(words.toString());
    }
}
