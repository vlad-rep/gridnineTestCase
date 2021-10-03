package com.gridnine.testing.utils.io;

import com.gridnine.testing.model.Flight;

import java.util.List;

public class ConsoleOutputHelper implements OutputInterface {

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printFlights(List<Flight> flights) {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
        System.out.println("***************");
    }

    @Override
    public void printWelcomeMessage() {
        System.out.println("""
                Для вас представлены варианты перелетов, выберите нужный фильтр:
                1 - Исключить из списка вылет до текущего момента времени
                2 - Исключить из списка полёты, где имеются сегменты с датой прилёта раньше даты вылета
                3 - Исключить из списка полёты, при которых общее время, проведённое на земле превышает два часа
                q - выход""");
    }

    @Override
    public void printMenuMessage() {
        System.out.println("""
                Выберите фильтр:
                1 - Исключить из списка вылет до текущего момента времени
                2 - Исключить из списка полёты, где имеются сегменты с датой прилёта раньше даты вылета
                3 - Исключить из списка полёты, при которых общее время, проведённое на земле превышает два часа
                q - выход""");
    }

    @Override
    public void printError(String message, Exception exc) {
        System.out.println(message);
        exc.printStackTrace();
    }
}
