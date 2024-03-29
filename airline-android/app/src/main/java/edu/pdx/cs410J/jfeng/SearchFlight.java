package edu.pdx.cs410J.jfeng;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class SearchFlight extends AppCompatActivity {

    private ArrayAdapter<Flight> flights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_flight);
    }

    public void returnToMain(View view){
        finish();
    }

    public void search(View view){
        ListView listOfFlights = findViewById(R.id.flights);
        EditText airlineName = findViewById(R.id.airline_name_input);
        EditText sourceCode = findViewById(R.id.source_code_input);
        EditText destinationCode = findViewById(R.id.destination_code_input);

        String airlineNameString = airlineName.getText().toString();
        String sourceCodeString = sourceCode.getText().toString().toUpperCase();
        String destinationCodeString = destinationCode.getText().toString().toUpperCase();

        Validator validator = new Validator();
        String validationResult = validator.validationSearchFlight(airlineNameString, sourceCodeString, destinationCodeString);
        if(!validationResult.equals("valid")){
            Toast.makeText(this, validationResult, Toast.LENGTH_SHORT).show();
            return;
        }

        Airline airline = new Airline(airlineNameString);
        readAirlineFile(airline, sourceCodeString, destinationCodeString);
        airline.sort();
        flights = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,(List)airline.getFlights());
        listOfFlights.setAdapter(flights);
    }

    @Nullable
    private File getFilePath(String fileName){
        File dataDir = this.getDataDir();
        return new File(dataDir,fileName+".txt");
    }

    private void readAirlineFile(Airline airline, String src, String dest) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(getFilePath(airline.getName())))){
            for(String line = bufferedReader.readLine(); line!=null; line=bufferedReader.readLine()){
                String[] flightDetail = line.split(" ");
                if(src.equals(flightDetail[1]) && dest.equals(flightDetail[5])){
                    Flight flight = new Flight();
                    flight.setFlightNumber(Integer.parseInt(flightDetail[0]));
                    flight.setSourceCode(flightDetail[1]);
                    flight.setDepartDate(flightDetail[2]);
                    flight.setDepartTime(flightDetail[3]);
                    flight.setDepartPeriod(flightDetail[4]);
                    flight.setDestinationCode(flightDetail[5]);
                    flight.setArrivalDate(flightDetail[6]);
                    flight.setArrivalTime(flightDetail[7]);
                    flight.setArrivalPeriod(flightDetail[8]);
                    airline.addFlight(flight);
                }
            }
        } catch (IOException e) {
            Toast.makeText(this, "Airline does not exist", Toast.LENGTH_SHORT).show();
        }
    }
}