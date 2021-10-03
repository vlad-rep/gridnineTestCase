package com.gridnine.testing.filters;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DepartureBeforeCurrentDateExcludeFilter implements Filter{

    @Override
    public List<Flight> filtrate(List<Flight> flights) {
        List<Flight> result = new ArrayList<>(flights);
        for (Flight flight : flights) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getDepartureDate().isBefore(LocalDateTime.now())) {
                    result.remove(flight);
                }
            }
        }
        return result;
    }
}
