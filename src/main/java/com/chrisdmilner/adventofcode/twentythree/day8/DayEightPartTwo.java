package com.chrisdmilner.adventofcode.twentythree.day8;

import java.util.List;

public class DayEightPartTwo extends DayEight {
    @Override
    int getNumberOfSteps(char[] route, Network network) {
        List<String> startingLocations = network.allLocation().stream()
                .filter(l -> l.endsWith("A"))
                .toList();

        network.setCurrentLocations(startingLocations);

        int stepsTaken = 0;
        int i = 0;

        while (!network.getCurrentLocations().stream().allMatch(l -> l.endsWith("Z"))) {
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
