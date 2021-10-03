package test;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class FlightTestData {
    public static final LocalDateTime currentDate = LocalDateTime.now();

    public static final Segment seg1 = new Segment(currentDate.plusHours(1), currentDate.plusHours(3));
    public static final Segment seg2 = new Segment(currentDate.minusHours(2), currentDate.plusHours(3));
    public static final Segment seg3 = new Segment(currentDate.plusHours(1), currentDate.plusHours(3));
    public static final Segment seg4 = new Segment(currentDate.plusHours(4), currentDate.plusHours(8));
    public static final Segment seg5 = new Segment(currentDate.plusHours(10), currentDate.plusHours(20));
    public static final Segment seg6 = new Segment(currentDate.plusHours(1), currentDate.minusHours(4));

    public static final Flight flight1 = new Flight(List.of(seg1));
    public static final Flight flight2 = new Flight(List.of(seg2));
    public static final Flight flight3 = new Flight(List.of(seg3, seg4));
    public static final Flight flight4 = new Flight(List.of(seg3, seg4, seg5));
    public static final Flight flight5 = new Flight(List.of(seg6));

    public static List<Flight> getList() {
        return Arrays.asList(flight1, flight2, flight3, flight4, flight5);
    }

    public static List<Flight> getDepartureBeforeCurrentDateExcludeFilteredList() {
        return Arrays.asList(flight1, flight3, flight4, flight5);
    }

    public static List<Flight> getArrivalBeforeDepartureExcludeFilteredList() {
        return Arrays.asList(flight1, flight2, flight3, flight4);
    }

    public static List<Flight> getGroundTimeMoreThanTwoHoursExcludeFilteredList() {
        return Arrays.asList(flight1, flight2, flight3, flight5);
    }
}