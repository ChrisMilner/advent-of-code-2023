package com.chrisdmilner.adventofcode.twentythree.day8;

import com.chrisdmilner.adventofcode.twentythree.common.utils.MathsUtils;

import java.util.ArrayList;
import java.util.List;

public class DayEightPartTwo extends DayEight {
    @Override
    long getNumberOfSteps(char[] route, Network network) {
        List<String> startingLocations = network.allLocation().stream()
                .filter(l -> l.endsWith("A"))
                .toList();

        List<Integer> loopLengths = new ArrayList<>();

        for (String start : startingLocations) {
            network.setCurrentLocation(start);

            int steps = 0;

            while (!network.getCurrentLocation().endsWith("Z")) {
                if (route[steps % route.length] == 'L') {
                    network.goLeft();
                } else {
                    network.goRight();
                }

                steps++;
            }

            loopLengths.add(steps);
        }

        return MathsUtils.lowestCommonMultiple(loopLengths);
    }
}
