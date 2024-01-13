package com.chrisdmilner.adventofcode.twentythree.day19;

import com.chrisdmilner.adventofcode.twentythree.common.ListUtils;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;

import java.io.IOException;
import java.util.List;

public abstract class DayNineteen implements PuzzleSolution {
    abstract long getSolution(Workflows workflows, List<Part> parts);

    @Override
    public long solution(PuzzleInput input) throws IOException {
        List<List<String>> lineSections = ListUtils.splitList(input.readLines(), String::isBlank);

        Workflows workflows = Workflows.fromLines(lineSections.get(0));
        List<Part> parts = lineSections.get(1).stream()
                .map(Part::fromLine)
                .toList();

        return getSolution(workflows, parts);
    }

    public record Part(int x, int m, int a, int s) {
        public int getRatingFromChar(char c) {
            return switch (c) {
                case 'x' -> x;
                case 'm' -> m;
                case 'a' -> a;
                case 's' -> s;
                default -> throw new RuntimeException("Invalid condition parameter: " + c);
            };
        }

        public int totalRating() {
            return x + m + a + s;
        }

        public static Part fromLine(String line) {
            String withoutBrackets = line.substring(1, line.length() - 1);
            String[] categories = withoutBrackets.split(",");

            return new Part(
                    valueFromCategory(categories[0]),
                    valueFromCategory(categories[1]),
                    valueFromCategory(categories[2]),
                    valueFromCategory(categories[3])
            );
        }

        private static int valueFromCategory(String category) {
            return Integer.parseInt(category.substring(2));
        }
    }
}
