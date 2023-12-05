package com.chrisdmilner.adventofcode.twentythree.day2;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public abstract class DayTwo {
    abstract int getSolution(Stream<Game> games);

    public int solution(PuzzleInput input) throws IOException {
        return getSolution(input.streamLines().map(this::parseGame));
    }

    private Game parseGame(String line) {
        String[] parts = line.split(": ");

        return new Game(parseId(parts[0]), parseSets(parts[1]));
    }

    private int parseId(String line) {
        return Integer.parseInt(line.substring(5));
    }

    private List<Game.CubeQuantities> parseSets(String line) {
        return Arrays.stream(line.split("; "))
                .map(this::parseSet)
                .toList();
    }

    private Game.CubeQuantities parseSet(String setString) {
        String[] quantities = setString.split(", ");

        int reds = 0;
        int greens = 0;
        int blues = 0;

        for (String quantity : quantities) {
            String[] parts = quantity.split(" ");

            int amount = Integer.parseInt(parts[0]);

            switch (parts[1]) {
                case "red" -> reds += amount;
                case "green" -> greens += amount;
                case "blue" -> blues += amount;
                default -> throw new RuntimeException("Unexpected cube colour: " + parts[0]);
            }
        }

        return new Game.CubeQuantities(reds, greens, blues);
    }

    record Game(int id, Collection<CubeQuantities> sets) {
        record CubeQuantities(int noOfReds, int noOfGreens, int noOfBlues) {}

        public int maxRedsInSet() {
            return sets.stream().mapToInt(CubeQuantities::noOfReds).max().orElse(0);
        }

        public int maxGreensInSet() {
            return sets.stream().mapToInt(CubeQuantities::noOfGreens).max().orElse(0);
        }

        public int maxBluesInSet() {
            return sets.stream().mapToInt(CubeQuantities::noOfBlues).max().orElse(0);
        }
    }
}
