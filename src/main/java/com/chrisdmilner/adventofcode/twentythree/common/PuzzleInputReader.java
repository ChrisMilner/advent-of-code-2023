package com.chrisdmilner.adventofcode.twentythree.common;

import java.io.IOException;
import java.nio.file.Path;

public class PuzzleInputReader {
    private static final Path RESOURCES_PATH = Path.of("src", "main", "resources");

    public static PuzzleInput getInputFile(int day) {
        return new PuzzleInput(getFilePath(day, "input.txt"));
    }

    public static PuzzleInput getTestInputFile(int day) {
        return new PuzzleInput(getFilePath(day, "test-input.txt"));
    }

    private static Path getFilePath(int day, String filename) {
        return RESOURCES_PATH.resolve(Path.of("day-" + day, filename));
    }
}
