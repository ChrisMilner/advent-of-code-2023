package com.chrisdmilner.adventofcode.twentythree.day18;

import com.chrisdmilner.adventofcode.twentythree.common.Coordinates;
import com.chrisdmilner.adventofcode.twentythree.common.Direction;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class DayEighteen implements PuzzleSolution {
    abstract Instruction parseInstruction(String line);

    @Override
    public long solution(PuzzleInput input) throws IOException {
        return calculateVolume(input.streamLines().map(this::parseInstruction).toList());
    }

    long calculateVolume(List<Instruction> instructions) {
        Set<Coordinates> borders = new HashSet<>();
        Coordinates currentCoordinates = Coordinates.of(0, 0);

        for (Instruction instruction : instructions) {
            for (int i = 0; i < instruction.distance(); i++) {
                borders.add(currentCoordinates.move(instruction.direction(), i));
            }

            currentCoordinates = currentCoordinates.move(instruction.direction(), instruction.distance());
        }

        return new TrenchVolumeFinder(borders).countInside(Coordinates.of(1, 1)) + borders.size();
    }

    public record Instruction(Direction direction, int distance) {}
}
