package com.chrisdmilner.adventofcode.twentythree.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class PuzzleInputReader {
    private static final Path RESOURCES_PATH = Path.of("src", "main", "resources");

    public static Stream<String> streamInputLines(int day) throws IOException {
        return readInputLines(day).stream();
    }

    public static List<String> readInputLines(int day) throws IOException {
        return Files.readAllLines(getInputFilePath(day)).stream().map(String::strip).toList();
    }

    private static Path getInputFilePath(int day) {
        return RESOURCES_PATH.resolve(Path.of("day-" + day, "input.txt"));
    }
}
