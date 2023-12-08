package com.chrisdmilner.adventofcode.twentythree.day8;

public class DayEightPartOne extends DayEight {

    @Override
    int getNumberOfSteps(char[] route, Network network) {
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
