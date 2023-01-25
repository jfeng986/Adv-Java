package edu.pdx.cs410J.jfeng;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * A unit test for code in the <code>Project1</code> class.  This is different
 * from <code>Project1IT</code> which is an integration test (and can capture data
 * written to {@link System#out} and the like.
 */
class Project1Test {

    @Test
    void readmeCanBeReadAsResource() throws IOException {
        try (
                InputStream readme = Project1.class.getResourceAsStream("README.txt")
        ) {
            assertThat(readme, not(nullValue()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(readme));
            String line = reader.readLine();
            assertThat(line, containsString("This is a README file!"));
        }
    }

    @Test
    void checkIsValidDateAndTimeMethod()
    {
        String dateAndTime = "11/03/1998 11:03";
        Project1 project1 = new Project1();
        boolean result = project1.isValidDateAndTime(dateAndTime);
        assertTrue(result);
    }
    @Test
    void checkIsValidDateAndTimeMethod2()
    {
        String dateAndTime = "11/03/1998";
        Project1 project1 = new Project1();
        boolean result = project1.isValidDateAndTime(dateAndTime);
        assertFalse(result);
    }

    @Test
    void checkIsValidDateAndTimeMethod3()
    {
        String dateAndTime = "not date";
        Project1 project1 = new Project1();
        boolean result = project1.isValidDateAndTime(dateAndTime);
        assertFalse(result);
    }

    @Test
    void checkIsValidFlightNumberMethod1()
    {
        String flightNumber = "666";
        Project1 project1 = new Project1();
        boolean result = project1.isValidFlightNumber(flightNumber);
        assertTrue(result);
    }

    @Test
    void checkIsValidFlightNumberMethod2()
    {
        String flightNumber = "9999";
        Project1 project1 = new Project1();
        boolean result = project1.isValidFlightNumber(flightNumber);
        assertFalse(result);
    }

    @Test
    void checkIsValidFlightNumberMethod3()
    {
        String flightNumber = "-666";
        Project1 project1 = new Project1();
        boolean result = project1.isValidFlightNumber(flightNumber);
        assertFalse(result);
    }
    @Test
    void checkIsValidFlightNumberMethod4()
    {
        String flightNumber = "abc";
        Project1 project1 = new Project1();
        boolean result = project1.isValidFlightNumber(flightNumber);
        assertFalse(result);
    }

    @Test
    void checkIsValidSrcAndDestCodeMethod1()
    {
        String testSrcOrDest = "abc";
        Project1 project1 = new Project1();
        boolean result = project1.isValidSrcAndDestCode(testSrcOrDest);
        assertTrue(result);
    }

    @Test
    void checkIsValidSrcAndDestCodeMethod2()
    {
        String testSrcOrDest = "ABCD";
        Project1 project1 = new Project1();
        boolean result = project1.isValidSrcAndDestCode(testSrcOrDest);
        assertFalse(result);
    }

}
