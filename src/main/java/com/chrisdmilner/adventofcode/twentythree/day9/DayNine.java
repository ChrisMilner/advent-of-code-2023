package com.chrisdmilner.adventofcode.twentythree.day9;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DayNine implements PuzzleSolution {
    abstract long extrapolateSequence(List<Integer> sequence);

    public long solution(PuzzleInput input) throws IOException {
        return input.streamLines()
                .map(this::parseLine)
                .mapToLong(this::extrapolateSequence)
                .sum();
    }

    private List<Integer> parseLine(String line) {
        return Arrays.stream(line.split(" "))
                .map(Integer::parseInt)
                .toList();
    }

    List<Integer> getSequenceDiff(List<Integer> sequence) {
        List<Integer> diffSequence = new ArrayList<>();

        for (int i = 0; i < sequence.size() - 1; i++) {
            diffSequence.add(sequence.get(i + 1) - sequence.get(i));
        }

        return diffSequence;
    }
}
