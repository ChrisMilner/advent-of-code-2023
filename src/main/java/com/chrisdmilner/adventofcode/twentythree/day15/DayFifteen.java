package com.chrisdmilner.adventofcode.twentythree.day15;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public abstract class DayFifteen implements PuzzleSolution {
    abstract long getSolution(List<String> instructions);

    @Override
    public long solution(PuzzleInput input) throws IOException {
        List<String> instructions = Arrays.stream(input.readLines().getFirst().split(",")).toList();

        return getSolution(instructions);
    }

    int hash(String input) {
        return input.chars().reduce(0, (acc, curr) -> ((acc + curr) * 17) % 256);
    }
}
