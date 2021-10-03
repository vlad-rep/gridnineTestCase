package com.gridnine.testing.filters;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.util.ArrayList;
import java.util.List;

public class ArrivalBeforeDepartureExcludeFilter implements Filter {

    @Override
    public List<Flight> filtrate(List<Flight> flights) {
        List<Flight> result = new ArrayList<>(flights);
        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();
            for (Segment segment : segments) {
                if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                    result.remove(flight);
                }
            }
        }
        return result;
    }
}
