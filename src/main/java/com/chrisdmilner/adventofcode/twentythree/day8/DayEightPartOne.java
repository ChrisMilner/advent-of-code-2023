package com.chrisdmilner.adventofcode.twentythree.day8;

public class DayEightPartOne extends DayEight {

    @Override
    long getNumberOfSteps(char[] route, Network network) {
        network.setCurrentLocation("AAA");

        int stepsTaken = 0;

        while (!network.getCurrentLocation().equals("ZZZ")) {
            if (route[stepsTaken % route.length] == 'L') {
                network.goLeft();
            } else {
                network.goRight();
            }

            stepsTaken++;
        }

        return stepsTaken;
    }
}
