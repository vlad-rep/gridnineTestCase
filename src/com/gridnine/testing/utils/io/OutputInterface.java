package com.gridnine.testing.utils.io;

import com.gridnine.testing.model.Flight;

import java.util.List;

public interface OutputInterface {

    void printMessage(String message);
    void printFlights(List<Flight> flights);
    void printWelcomeMessage();
    void printMenuMessage();
    void printError(String message, Exception exc);
}
