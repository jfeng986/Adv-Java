This is a README file!
    usage: java -jar target/airline-2023.0.0.jar [options] <args>
        args are (in this order):
            airline             The name of the airline
            flightNumber        The flight number
            src                 Three-letter code of departure airport
            depart              Departure date and time (24-hour time)
            dest                Three-letter code of arrival airport
            arrive              Arrival date and time (24-hour time)
        options are (options may appear in any order):
            -host               hostname Host computer on which the server runs
            -port               port Port on which the server is listening
            -search             Search for flights
            -print              Prints a description of the new flight
            -README             Prints a README for this project and exits
    *Date and time should be in the format: mm/dd/yyyy hh:mm