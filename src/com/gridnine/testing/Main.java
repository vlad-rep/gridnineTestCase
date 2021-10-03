package com.gridnine.testing;

import com.gridnine.testing.utils.flight.DefaultFlightBuilder;
import com.gridnine.testing.utils.io.ConsoleInputHelper;
import com.gridnine.testing.utils.io.ConsoleOutputHelper;
import com.gridnine.testing.utils.FlightFilter;

public class Main {

    public static void main(String[] args) {
        FlightFilter flightFilter =
                new FlightFilter(
                        new ConsoleOutputHelper(),
                        new ConsoleInputHelper(),
                        new DefaultFlightBuilder()
                );
        flightFilter.run();
    }
}
