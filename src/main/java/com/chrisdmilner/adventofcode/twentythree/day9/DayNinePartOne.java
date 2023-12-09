package com.chrisdmilner.adventofcode.twentythree.day9;

import java.util.List;

public class DayNinePartOne extends DayNine {
    @Override
    long extrapolateSequence(List<Integer> sequence) {
        if (sequence.stream().allMatch(i -> i == 0)) {
            return 0;
        }

        return sequence.getLast() + extrapolateSequence(getSequenceDiff(sequence));
    }
}
