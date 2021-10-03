package test;

import com.gridnine.testing.filters.Filter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.utils.filter.FilterFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TestingFlightFilterTest {

    List<Flight> testFlights = FlightTestData.getList();

    private static void getAssertionFlightFilter(
            List<Flight> expectedFlightList,
            Filter filter,
            List<Flight> testFlights
    ) {
        List<Flight> expectedResult = new ArrayList<>(expectedFlightList);
        List<Flight> filteredResult = filter.filtrate(testFlights);
        System.out.println("expectedResult = " + expectedResult);
        System.out.println("filteredResult = " + filteredResult);

        Assertions.assertEquals(expectedResult, filteredResult);
    }

    @Test
    public void departureBeforeCurrentDateExcludeFilterSuccessTest() {
        List<Flight> departureBeforeCurrentDateExcludeFilteredList =
                FlightTestData.getDepartureBeforeCurrentDateExcludeFilteredList();

        getAssertionFlightFilter(departureBeforeCurrentDateExcludeFilteredList,
                FilterFactory.getFilter("1"),
                testFlights);
        System.out.println("departureBeforeCurrentDateExcludeFilterSuccessTest is done!");
    }

    @Test
    public void arrivalBeforeDepartureExcludeFilterSuccessTest() {
        List<Flight> arrivalBeforeDepartureExcludeFilteredList =
                FlightTestData.getArrivalBeforeDepartureExcludeFilteredList();

        getAssertionFlightFilter(arrivalBeforeDepartureExcludeFilteredList,
                FilterFactory.getFilter("2"),
                testFlights);
        System.out.println("arrivalBeforeDepartureExcludeFilterSuccessTest is done!");
    }

    @Test
    public void groundTimeMoreThanTwoHoursExcludeFilterSuccessTest() {
        List<Flight> groundTimeMoreThanTwoHoursExcludeFilteredList =
                FlightTestData.getGroundTimeMoreThanTwoHoursExcludeFilteredList();

        getAssertionFlightFilter(groundTimeMoreThanTwoHoursExcludeFilteredList,
                FilterFactory.getFilter("3"),
                testFlights);
        System.out.println("arrivalBeforeDepartureExcludeFilterSuccessTest is done!");
    }
}
