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
        return readFileLines(getInputFilePath(day));
    }

    public static List<String> readTestInputLines(int day) throws IOException {
        return readFileLines(getTestInputFilePath(day));
    }

    private static List<String> readFileLines(Path path) throws IOException {
        return Files.readAllLines(path).stream().map(String::strip).toList();
    }

    private static Path getInputFilePath(int day) {
        return getFilePath(day, "input.txt");
    }

    private static Path getTestInputFilePath(int day) {
        return getFilePath(day, "test-input.txt");
    }

    private static Path getFilePath(int day, String filename) {
        return RESOURCES_PATH.resolve(Path.of("day-" + day, filename));
    }
}
