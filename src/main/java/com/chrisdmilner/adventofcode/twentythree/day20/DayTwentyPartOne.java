package com.chrisdmilner.adventofcode.twentythree.day20;

import com.chrisdmilner.adventofcode.twentythree.common.Pair;

import java.util.List;

public class DayTwentyPartOne extends DayTwenty {
    @Override
    long getSolution(List<String> lines) {
        PulseNetwork network = PulseNetwork.fromLines(lines);

        long lowPulses = 0;
        long highPulses = 0;

        for (int i = 0; i < 1000; i++) {
            Pair<Integer, Integer> result = network.start();

            lowPulses += result.a();
            highPulses += result.b();
        }

        return lowPulses * highPulses;
    }
}
