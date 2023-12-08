package com.chrisdmilner.adventofcode.twentythree.day6;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public abstract class DaySix implements PuzzleSolution {
    abstract long getSolution(List<Integer> times, List<Integer> distances);

    public long solution(PuzzleInput input) throws IOException {
        List<String> lines = input.readLines();

        return getSolution(parseNumbersFromLine(lines.get(0)), parseNumbersFromLine(lines.get(1)));
    }

    private List<Integer> parseNumbersFromLine(String line) {
        return Arrays.stream(line.split(":")[1].split("\\s+"))
                .filter(numberString -> !numberString.isBlank())
                .map(Integer::parseInt)
                .toList();
    }

    Range solveQuadratic(long a, long b, long c) {
        double root = Math.sqrt(Math.pow(b, 2) - (4 * a * c));

        double answerOne = (-b + root) / (2 * a);
        double answerTwo = (-b - root) / (2 * a);

        return new Range(
                (int) Math.ceil(Math.min(answerOne, answerTwo)),
                (int) Math.floor(Math.max(answerOne, answerTwo))
        );
    }

    record Range(long from, long to) {
        public LongStream streamLongsBetween() {
            return LongStream.range(from, to + 1);
        }
    }
}
