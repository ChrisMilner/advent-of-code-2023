package com.chrisdmilner.adventofcode.twentythree.day13;

import com.chrisdmilner.adventofcode.twentythree.common.ListUtils;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class DayThirteen implements PuzzleSolution {
    abstract long getReflectionPoint(List<Integer> rows, List<Integer> cols);

    @Override
    public long solution(PuzzleInput input) throws IOException {
        return ListUtils.splitList(input.readLines(), String::isBlank).stream()
                .mapToLong(lines -> getReflectionPoint(parseRows(lines), parseCols(lines)))
                .sum();
    }

    private List<Integer> parseRows(List<String> rows) {
        return rows.stream()
                .map(this::parseRow)
                .toList();
    }

    private List<Integer> parseCols(List<String> rows) {
        return IntStream.range(0, rows.getFirst().length())
                .mapToObj(i -> parseRow(getColFromRows(rows, i)))
                .toList();
    }

    private String getColFromRows(List<String> rows, int i) {
        return rows.stream()
                .map(row -> row.toCharArray()[i] + "")
                .collect(Collectors.joining());
    }

    private int parseRow(String line) {
        char[] chars = line.toCharArray();

        return IntStream.range(0, line.length())
                .filter(i -> chars[i] == '#')
                .reduce(0, (acc, i) -> acc + (1 << i));
    }
}
