package com.chrisdmilner.adventofcode.twentythree.day8;

import java.util.List;

public class DayEightPartOne extends DayEight {

    @Override
    int getNumberOfSteps(char[] route, Network network) {
        network.setCurrentLocations(List.of("AAA"));

        int stepsTaken = 0;
        int i = 0;

        while (!network.getCurrentLocations().get(0).equals("ZZZ")) {
            if (route[i] == 'L') {
                network.goLeft();
            } else {
                network.goRight();
            }

            stepsTaken++;
            i = (i + 1) % route.length;
        }

        return stepsTaken;
    }
}
