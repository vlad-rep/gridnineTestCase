package com.gridnine.testing.utils.filter;

import com.gridnine.testing.filters.ArrivalBeforeDepartureExcludeFilter;
import com.gridnine.testing.filters.DepartureBeforeCurrentDateExcludeFilter;
import com.gridnine.testing.filters.Filter;
import com.gridnine.testing.filters.GroundTimeMoreThanTwoHoursExcludeFilter;

public class FilterFactory {

    public static Filter getFilter(String command) {
        return switch (command) {
            case "1" -> new DepartureBeforeCurrentDateExcludeFilter();
            case "2" -> new ArrivalBeforeDepartureExcludeFilter();
            case "3" -> new GroundTimeMoreThanTwoHoursExcludeFilter();
            default -> throw new IllegalArgumentException("Unknown command: " + command);
        };
    }
}
