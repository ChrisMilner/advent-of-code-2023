package com.chrisdmilner.adventofcode.twentythree.day20;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class DayTwentyPartTwo extends DayTwenty {
    @Override
    long getSolution(List<String> lines) {
        PulseNetwork network = PulseNetwork.fromLines(lines);

        AtomicBoolean receivedLow = new AtomicBoolean(false);

        int counter = 0;

        while (!receivedLow.get()) {
            counter++;

            if (counter % 1000000 == 0) {
                System.out.println(counter);
            }

            network.start((destination, pulse) -> {
                if (destination.equals("rx") && pulse == Pulse.LOW) {
                    receivedLow.set(true);
                }
            });
        }

        return counter;
    }
}
