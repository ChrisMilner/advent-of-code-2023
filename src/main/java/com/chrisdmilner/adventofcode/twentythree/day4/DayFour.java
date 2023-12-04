package com.chrisdmilner.adventofcode.twentythree.day4;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInputReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public abstract class DayFour {
    abstract int getPoints(List<Card> cards);

    public int solution() throws IOException {
        return getPoints(
                PuzzleInputReader.streamInputLines(4)
                        .map(Card::fromString)
                        .toList()
        );
    }

    record Card(List<Integer> winningNumbers, List<Integer> ourNumbers) {
        public static Card fromString(String string) {
            String numbers = string.split(": ")[1];

            String[] numberParts = numbers.split(" \\| ");

            return new Card(
                    parseIntsFromString(numberParts[0].strip()),
                    parseIntsFromString(numberParts[1].strip())
            );
        }

        private static List<Integer> parseIntsFromString(String input) {
            return Arrays.stream(input.split("\\s+"))
                    .map(Integer::parseInt)
                    .toList();
        }
    }
}
