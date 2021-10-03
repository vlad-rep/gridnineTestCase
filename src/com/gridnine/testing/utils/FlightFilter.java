package com.gridnine.testing.utils;


import com.gridnine.testing.filters.Filter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.utils.filter.FilterFactory;
import com.gridnine.testing.utils.flight.FlightBuilder;
import com.gridnine.testing.utils.io.InputInterface;
import com.gridnine.testing.utils.io.OutputInterface;

import java.util.List;

public class FlightFilter {

    private final OutputInterface outputInterface;
    private final FlightBuilder flightBuilder;
    private final InputInterface inputInterface;

    public FlightFilter(OutputInterface outputInterface,
                        InputInterface inputInterface,
                        FlightBuilder flightBuilder) {

        this.outputInterface = outputInterface;
        this.inputInterface = inputInterface;
        this.flightBuilder = flightBuilder;
    }

    public void run() {
        List<Flight> testFlights = flightBuilder.createFlights();

        outputInterface.printMessage("Flights:");
        outputInterface.printFlights(testFlights);
        outputInterface.printWelcomeMessage();

        try {
            while (true) {
                String command = inputInterface.readString();
                if (command.equals("q")) {
                    inputInterface.closeInputSource();
                    return;
                }
                Filter filter = FilterFactory.getFilter(command);
                List<Flight> filteredFlights = filter.filtrate(testFlights);

                outputInterface.printMessage("Filtered flights:");
                outputInterface.printFlights(filteredFlights);
                outputInterface.printMenuMessage();
            }
        } catch (Exception exception) {
            outputInterface.printError("Произошла ошибка во время выполнения программы", exception);
        }
    }
}
