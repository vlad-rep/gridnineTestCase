package com.gridnine.testing.filters;


import com.gridnine.testing.model.Flight;

import java.util.List;

public interface Filter {
    List<Flight> filtrate(List<Flight> flights);
}
