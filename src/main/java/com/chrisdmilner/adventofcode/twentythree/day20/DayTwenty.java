package com.chrisdmilner.adventofcode.twentythree.day20;

import com.chrisdmilner.adventofcode.twentythree.common.Pair;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleSolution;

import java.io.IOException;

public abstract class DayTwenty implements PuzzleSolution {
    @Override
    public long solution(PuzzleInput input) throws IOException {
        PulseNetwork pulseNetwork = PulseNetwork.fromLines(input.readLines());

        long lowPulses = 0;
        long highPulses = 0;

        for (int i = 0; i < 1000; i++) {
            Pair<Integer, Integer> result = pulseNetwork.start();

            lowPulses += result.a();
            highPulses += result.b();
        }

        return lowPulses * highPulses;
    }
}
