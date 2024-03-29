package edu.pdx.cs410J.jfeng;

import edu.pdx.cs410J.ParserException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TextDumperTest
{

  /*
  @Test
  void airlineNameIsDumpedInTextFormat() {
    String airlineName = "Test Airline";
    Airline airline = new Airline(airlineName);

    StringWriter sw = new StringWriter();
    TextDumper dumper = new TextDumper(sw);
    dumper.dump(airline);

    String text = sw.toString();
    assertThat(text, containsString(airlineName));
  }

  @Test
  void canParseTextWrittenByTextDumper(@TempDir File tempDir) throws IOException, ParserException {
    String airlineName = "Test Airline";
    Airline airline = new Airline(airlineName);

    File textFile = new File(tempDir, "airline.txt");
    TextDumper dumper = new TextDumper(new FileWriter(textFile));
    dumper.dump(airline);

    TextParser parser = new TextParser(new FileReader(textFile));
    Airline read = parser.parse();
    assertThat(read.getName(), equalTo(airlineName));
  }

   */

    @Test
    void createNewFileAndDumpData() throws IOException, ParserException {
        String filePath = String.format("Test.txt");
        Airline airline = new Airline("Test");
        Flight flight = new Flight(666, "ABC", "4/20/2013", "11:25", "EGF", "03/2/2023", "1:03");
        flight.setDepartPeriod("am");
        flight.setArrivePeriod("pm");
        airline.addFlight(flight);
        TextDumper textDumper = new TextDumper(filePath);
        textDumper.dump(airline);
        TextParser textParser = new TextParser(filePath,airline);
        Airline airlineParsed = textParser.parse();
        assertThat(airline.toString(), containsString(airlineParsed.toString()));
        File deleteFile = new File("Test.txt");
        deleteFile.delete();
    }

    @Test
    void dumpDataToEmptyFile() throws IOException, ParserException {
        String filePath = String.format("Test.txt");
        Airline airline = new Airline("Test");
        Flight flight = new Flight(666, "ABC", "4/20/2013", "11:25", "EGF", "03/2/2023", "1:03");
        flight.setDepartPeriod("am");
        flight.setArrivePeriod("pm");
        airline.addFlight(flight);
        TextDumper textDumper = new TextDumper(filePath);
        textDumper.dump(airline);
        TextParser textParser = new TextParser(filePath,airline);
        Airline airlineParsed = textParser.parse();
        assertThat(airline.toString(), containsString(airlineParsed.toString()));
        File deleteFile = new File("Test.txt");
        deleteFile.delete();
    }

    @Test
    void dumpDataToNotEmptyFile() throws IOException, ParserException {
        String filePath = String.format("Test.txt");
        Airline airline = new Airline("Test");
        Flight flight = new Flight(666, "ABC", "4/20/2013", "11:25", "EGF", "03/2/2023", "1:03");
        flight.setDepartPeriod("am");
        flight.setArrivePeriod("pm");
        airline.addFlight(flight);
        TextDumper textDumper = new TextDumper(filePath);
        textDumper.dump(airline);
        TextParser textParser = new TextParser(filePath,airline);
        Airline airlineParsed = textParser.parse();
        assertThat(airline.toString(), containsString(airlineParsed.toString()));
        File deleteFile = new File("Test.txt");
        deleteFile.delete();
    }

    @Test
    void dumpMalformedData() throws IOException, ParserException {
        String filePath = String.format("Test.txt");
        Airline airline = new Airline("Test");
        Flight flight = new Flight(666, "ABCABC", "4/20/2013", "11:25", "EGF", "03/2/2023", "1:03");
        flight.setDepartPeriod("am");
        flight.setArrivePeriod("pm");
        airline.addFlight(flight);
        TextDumper textDumper = new TextDumper(filePath);
        textDumper.dump(airline);
        TextParser textParser = new TextParser(filePath,airline);
        Airline airlineParsed = textParser.parse();
        assertNull(airlineParsed);
        File deleteFile = new File("Test.txt");
        deleteFile.delete();
    }


}
