package com.gridnine.testing.filters;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GroundTimeMoreThanTwoHoursExcludeFilter implements Filter {

    @Override
    public List<Flight> filtrate(List<Flight> flights) {
        List<Flight> result = new ArrayList<>(flights);
        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();
            int groundTime = 0;
            if (segments.size() > 1) {
                for (int i = 0; i < segments.size() - 1; i++) {
                    groundTime += Math.abs(Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate()).toHours());
                }
                if (groundTime > 2) {
                    result.remove(flight);
                }
            }
        }
        return result;
    }
}
